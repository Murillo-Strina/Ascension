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
    private StringBuilder message;

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
        this.message = new StringBuilder();
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
                message.append(String.format("Herói usou Habilidade 1 e causou %d de dano%n", this.heroAction));
                break;
            case 2:
                this.heroAction = this.hero.ElementSkillB();
                message.append(String.format("Herói usou Habilidade 2 e causou %d de dano%n", this.heroAction));
                break;
            case 3:
                this.heroAction = this.hero.getWeapon().WeaponSkillA();
                message.append(String.format("Herói usou Habilidade 3 e causou %d de dano%n", this.heroAction));
                break;
            case 4:
                this.heroAction = this.hero.getWeapon().WeaponSkillB();
                message.append(String.format("Herói usou Habilidade 4 e causou %d de dano%n", this.heroAction));
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
                    message.append(String.format("%s ganhou %d de escudo%n", this.hero.getName(), this.heroAction));
                } else if (this.hero.getElementInt() == 5) {
                    this.hero.increaseHp(this.heroAction);
                    message.append(String.format("%s curou %d de HP%n", this.hero.getName(), this.heroAction));
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
                message.append(
                        String.format("%s causou %d de dano com Habilidade 3%n", this.hero.getName(), this.heroAction));
                ShowEnemyHP();
                break;
            case 4:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                message.append(
                        String.format("%s causou %d de dano com Habilidade 4%n", this.hero.getName(), this.heroAction));
                ShowEnemyHP();
                break;
        }
    }

    private void enemyTurn() {
        if (!this.enemy.isStunned()) {
            this.enemySkillChosen = this.random.nextInt(2) + 1;
            message.append(String.format("%n%s usou ação %d%n", this.enemy.getName(), this.enemySkillChosen));
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
            message.append(String.format("%s tomou %d de dano! HP atual: 0/%d%n", this.enemy.getName(), this.heroAction,
                    this.enemy.getMaximumHP()));
            message.append(String.format("%s venceu a batalha!%n", this.hero.getName()));
        } else {
            message.append(String.format("%s tomou %d de dano! HP atual: %d/%d%n", this.enemy.getName(),
                    this.heroAction, this.enemy.getHealth(), this.enemy.getMaximumHP()));
        }
    }

    private void ShowHeroHP() {
        if (this.hero.getHp() <= 0) {
            message.append(String.format("%s tomou %d de dano! HP atual: 0/%d%n", this.hero.getName(), this.enemyAction,
                    this.hero.getMaximumHP()));
            message.append(String.format("%s venceu a batalha!%n", this.enemy.getName()));
        } else {
            message.append(String.format("%s tomou %d de dano! HP atual: %d/%d%n", this.hero.getName(),
                    this.enemyAction, this.hero.getHp(), this.hero.getMaximumHP()));
        }
    }

    public Hero getHero() {
        return hero;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public String getMessage() {
        return message.toString();
    }

    public void setHeroSkill(int skill) {
        this.heroSkillChosen = skill;
        System.out.println("Habilidade do herói definida para: " + skill);
    }

    public void startBattle() {
        System.out.println("Iniciando batalha...");
        message = new StringBuilder();
        message.append("=====================\nBatalha entre ").append(hero.getName()).append(" e ")
                .append(enemy.getName())
                .append("\n=====================\n");
        System.out.println("Mensagem de batalha: " + message);
        this.heroBattleSpeed = this.random.nextInt(21) + this.hero.getSpd();
        this.enemyBattleSpeed = this.random.nextInt(21) + this.enemy.getSpd();
        performTurn();
    }
}
