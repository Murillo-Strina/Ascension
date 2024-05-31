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
    private String message;

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
        this.message = "";
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
    }

    private void heroTurn() {
        switch (this.heroSkillChosen) {
            case 1:
                this.heroAction = this.hero.ElementSkillA();
                message += "===== Heroi usou Skill 1 =====\n";
                break;
            case 2:
                this.heroAction = this.hero.ElementSkillB();
                message += "===== Heroi usou Skill 2 =====\n";
                break;
            case 3:
                this.heroAction = this.hero.ElementSkillC();
                message += "===== Heroi usou Skill 3 =====\n";
                break;
            case 4:
                this.heroAction = this.hero.ElementSkillD();
                message += "===== Heroi usou Skill 4 =====\n";
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
                    message += this.hero.getName() + " ganhou " + this.heroAction + " de escudo\n";
                } else if (this.hero.getElementInt() == 5) {
                    this.hero.increaseHp(this.heroAction);
                    message += this.hero.getName() + " se curou em " + this.heroAction + " de vida\n";
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
                message += this.hero.getName() + " causou " + this.heroAction + " de dano com Skill 3\n";
                ShowEnemyHP();
                break;
            case 4:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                message += this.hero.getName() + " causou " + this.heroAction + " de dano com Skill 4\n";
                ShowEnemyHP();
                break;
        }
    }

    private void enemyTurn() {
        if (!this.enemy.isStunned()) {
            this.enemySkillChosen = this.random.nextInt(2) + 1;
            message += "\n===== " + this.enemy.getName() + " usou a ação " + this.enemySkillChosen + " =====\n";
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
            message += this.enemy.getName() + " tomou " + this.heroAction + " de dano! Vida atual: 0/"
                    + this.enemy.getMaximumHP() + "\n";
            message += this.hero.getName() + " venceu a batalha!\n";
        } else {
            message += this.enemy.getName() + " tomou " + this.heroAction + " de dano! Vida atual: "
                    + this.enemy.getHealth() + "/" + this.enemy.getMaximumHP() + "\n";
        }
    }

    private void ShowHeroHP() {
        if (this.hero.getHp() <= 0) {
            message += this.hero.getName() + " tomou " + this.enemyAction + " de dano! Vida atual: 0/"
                    + this.hero.getMaximumHP() + "\n";
            message += this.enemy.getName() + " venceu a batalha!\n";
        } else {
            message += this.hero.getName() + " tomou " + this.enemyAction + " de dano! Vida atual: "
                    + this.hero.getHp() + "/" + this.hero.getMaximumHP() + "\n";
        }
    }

    public Hero getHero() {
        return hero;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public String getMessage() {
        return message;
    }

    public void setHeroSkill(int skill) {
        this.heroSkillChosen = skill;
    }

    public void startBattle() {
        System.out.println("Iniciando batalha...");
        message = ""; // Reset message log
        message = "Batalha entre " + hero.getName() + " e " + enemy.getName() + "\n";
        System.out.println("Mensagem de batalha: " + message);
        this.heroBattleSpeed = this.random.nextInt(21) + this.hero.getSpd();
        this.enemyBattleSpeed = this.random.nextInt(21) + this.enemy.getSpd();
        performTurn();
    }
}
