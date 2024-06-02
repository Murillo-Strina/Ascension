import java.util.Random;

public class BattleSystem {
    private Random random;
    private Hero hero;
    private Enemy enemy;
    private StatusChecker statusChecker;
    private int heroBattleSpeed;
    private int enemyBattleSpeed;
    private int enemySkillChosen;
    private int heroSkillChosen;
    private int heroAction;
    private int enemyAction;
    private StringBuilder msg;

    public BattleSystem(Hero hero, Enemy enemy, StatusChecker statusChecker) {
        this.random = new Random();
        this.hero = hero;
        this.enemy = enemy;
        this.statusChecker = statusChecker;
        this.heroBattleSpeed = 0;
        this.enemyBattleSpeed = 0;
        this.enemySkillChosen = 0;
        this.heroSkillChosen = 0;
        this.heroAction = 0;
        this.enemyAction = 0;
        this.msg = new StringBuilder();
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
        this.statusChecker.setEnemy(enemy);
    }

    public void performTurn() {
        statusChecker.normalizeStatus();
        if (this.heroBattleSpeed >= this.enemyBattleSpeed) {
            heroTurn();
            if (this.enemy.getHealth() > 0) {
                enemyTurn();
            }
        } else {
            enemyTurn();
            if (this.hero.getHp() > 0) {
                heroTurn();
            }
        }
        this.statusChecker.checkStatusConditions();
        msg.append(statusChecker.getMessageLog());
        statusChecker.getMessageLog();
    }

    private void heroTurn() {
        switch (this.heroSkillChosen) {
            case 1:
                this.heroAction = this.hero.ElementSkillA();
                msg.append("===== Heroi usou Skill 1 =====\n");
                break;
            case 2:
                this.heroAction = this.hero.ElementSkillB();
                msg.append("===== Heroi usou Skill 2 =====\n");
                break;
            case 3:
                this.heroAction = this.hero.getWeapon().WeaponSkillA();
                msg.append("===== Heroi usou Skill 3 =====\n");
                break;
            case 4:
                this.heroAction = this.hero.getWeapon().WeaponSkillB();
                msg.append("===== Heroi usou Skill 4 =====\n");
                break;
            default:
                this.heroAction = 0;
                break;
        }

        applyHeroSkillEffects();
    }

    private void applyHeroSkillEffects() {
        switch (this.heroSkillChosen) {
            case 1:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                ShowEnemyHP();
                break;
            case 2:
                if (this.hero.getElementInt() == 4) {
                    this.hero.setHp(this.hero.getHp() + this.heroAction);
                    msg.append(this.hero.getName()).append(" ganhou ").append(this.heroAction)
                            .append(" de escudo\n");
                } else if (this.hero.getElementInt() == 5) {
                    this.hero.increaseHp(this.heroAction);
                    msg.append(this.hero.getName()).append(" se curou em ").append(this.heroAction)
                            .append(" de vida\n");
                } else {
                    switch (this.hero.getElementInt()) {
                        case 1:
                            this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                            this.enemy.setSeeded(true);
                            ShowEnemyHP();
                            break;
                        case 2:
                            this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                            this.enemy.setBurning(true);
                            ShowEnemyHP();
                            break;
                        case 3:
                            this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                            this.enemy.setFrozen(true);
                            ShowEnemyHP();
                            break;
                        case 4:
                            this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                            this.enemy.setStunned(true);
                            ShowEnemyHP();
                            break;
                    }
                }
                break;
            case 3:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                msg.append(this.hero.getName()).append(" causou ").append(this.heroAction)
                        .append(" de dano com Skill 3\n");
                ShowEnemyHP();
                break;
            case 4:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                msg.append(this.hero.getName()).append(" causou ").append(this.heroAction)
                        .append(" de dano com Skill 4\n");
                ShowEnemyHP();
                break;
        }
    }

    private void enemyTurn() {
        if (!this.enemy.isStunned()) {
            this.enemySkillChosen = this.random.nextInt(2) + 1;
            msg.append("\n===== ").append(this.enemy.getName()).append(" usou a ação ")
                    .append(this.enemySkillChosen).append(" =====\n");
            if (this.enemySkillChosen == 1) {
                this.enemyAction = this.enemy.basicAttack();
                this.hero.setHp(this.hero.getHp() - this.enemyAction);
                ShowHeroHP();
            } else {
                this.enemyAction = this.enemy.elementalSkill();
                this.hero.setHp(this.hero.getHp() - this.enemyAction);
                ShowHeroHP();
            }
        }
    }

    private void ShowEnemyHP() {
        if (this.enemy.getHealth() <= 0) {
            msg.append(this.enemy.getName()).append(" tomou ").append(this.heroAction)
                    .append(" de dano! Vida atual: 0/")
                    .append(this.enemy.getMaximumHP()).append("\n");
            msg.append(this.hero.getName()).append(" venceu a batalha!\n");
        } else {
            msg.append(this.enemy.getName()).append(" tomou ").append(this.heroAction)
                    .append(" de dano! Vida atual: ")
                    .append(this.enemy.getHealth()).append("/").append(this.enemy.getMaximumHP()).append("\n");
        }
    }

    private void ShowHeroHP() {
        if (this.hero.getHp() <= 0) {
            msg.append(this.hero.getName()).append(" tomou ").append(this.enemyAction)
                    .append(" de dano! Vida atual: 0/")
                    .append(this.hero.getMaximumHP()).append("\n");
            msg.append(this.enemy.getName()).append(" venceu a batalha!\n");
        } else {
            msg.append(this.hero.getName()).append(" tomou ").append(this.enemyAction)
                    .append(" de dano! Vida atual: ")
                    .append(this.hero.getHp()).append("/").append(this.hero.getMaximumHP()).append("\n");
        }
    }

    public Hero getHero() {
        return hero;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public String getMessage() {
        return msg.toString();
    }

    public void setHeroSkill(int skill) {
        this.heroSkillChosen = skill;

    }

    public void startBattle() {
        System.out.println("Iniciando batalha...");
        msg = new StringBuilder();
        msg.append("Batalha entre ").append(hero.getName()).append(" e ").append(enemy.getName()).append("\n");
        System.out.println("Mensagem de batalha: " + msg);
        this.heroBattleSpeed = this.random.nextInt(21) + this.hero.getSpd();
        this.enemyBattleSpeed = this.random.nextInt(21) + this.enemy.getSpd();
        performTurn();
    }
}
