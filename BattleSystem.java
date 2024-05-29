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
        this.hero.setElementInt(5);
        this.message = "";
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

    public void setHeroElement(int element) {
        this.hero.setElementInt(element);
    }

    public void setHeroSkill(int skill) {
        this.heroSkillChosen = skill;
    }

    public void startBattle() {
        this.heroBattleSpeed = this.random.nextInt(21) + this.hero.getSpd();
        this.enemyBattleSpeed = this.random.nextInt(21) + this.enemy.getSpd();
        battleTurn();
    }

    private void battleTurn() {
        if (this.hero.getHp() > 0 && this.enemy.getHealth() > 0) {
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
        }
    }

    private void heroTurn() {
        statusChecker.normalizeStatus();
        performHeroSkill();
        statusChecker.checkStatusConditions();
    }

    private void enemyTurn() {
        statusChecker.checkStatusConditions();
        if (this.enemy.getHealth() > 0 && !this.enemy.isStunned()) {
            this.enemySkillChosen = this.random.nextInt(2) + 1;
            message = "\n" + this.enemy.getName() + " usou a ação " + this.enemySkillChosen;
            performEnemySkill();
        }
    }

    private void performHeroSkill() {
        switch (this.heroSkillChosen) {
            case 1:
                this.heroAction = this.hero.getWeapon().WeaponSkillA();
                break;
            case 2:
                this.heroAction = this.hero.getWeapon().WeaponSkillB();
                break;
            case 3:
                this.heroAction = this.hero.ElementSkillA();
                break;
            case 4:
                this.heroAction = this.hero.ElementSkillB();
                if (this.hero.getElementInt() == 4) {
                    this.hero.setHp(this.hero.getHp() + this.heroAction);
                    message = this.hero.getName() + " ganhou " + this.heroAction + " de escudo";
                } else if (this.hero.getElementInt() == 5) {
                    this.hero.increaseHp(this.heroAction);
                    message = this.hero.getName() + " se curou em " + this.heroAction + " de vida";
                } else {
                    applyElementEffect();
                }
                return;
        }
        this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
        showEnemyHP();
    }

    private void applyElementEffect() {
        switch (this.hero.getElementInt()) {
            case 1:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                this.enemy.setSeeded(true);
                break;
            case 2:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                this.enemy.setBurning(true);
                break;
            case 3:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                this.enemy.setFrozen(true);
                break;
            case 6:
                this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                this.enemy.setStunned(true);
                break;
        }
        showEnemyHP();
    }

    private void performEnemySkill() {
        if (this.enemySkillChosen == 1) {
            this.enemyAction = this.enemy.basicAttack();
        } else {
            this.enemyAction = this.enemy.elementalSkill();
        }
        this.hero.setHp(this.hero.getHp() - this.enemyAction);
        showHeroHP();
    }

    private void showEnemyHP() {
        if (this.enemy.getHealth() <= 0) {
            message = this.enemy.getName() + " tomou " + this.heroAction + " de dano! Vida atual: 0/" + this.enemy.getMaximumHP();
        } else {
            message = this.enemy.getName() + " tomou " + this.heroAction + " de dano! Vida atual: " + this.enemy.getHealth() + "/" + this.enemy.getMaximumHP();
        }
    }

    private void showHeroHP() {
        if (this.hero.getHp() <= 0) {
            message = this.hero.getName() + " tomou " + this.enemyAction + " de dano! Vida atual: 0/" + this.hero.getMaximumHP();
        } else {
            message = this.hero.getName() + " tomou " + this.enemyAction + " de dano! Vida atual: " + this.hero.getHp() + "/" + this.hero.getMaximumHP();
        }
    }
}
