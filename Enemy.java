import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int baseAttack;
    private int level;
    private int spd;
    private int maximumHP;
    private int normalAttack;
    private boolean isPoisoned;
    private boolean isFrozen;
    private boolean isSleeping;
    private boolean isBlind;
    private boolean isBurning;
    private boolean isSeeded;
    private boolean isStunned;
    private int accuracy;
    private Random r = new Random();
    //private Hero hero;

    public Enemy(String name) {
        this.name = name;
        this.health = 30;
        this.baseAttack = 5;
        this.normalAttack = this.baseAttack;
        this.maximumHP = 30;
        this.accuracy = r.nextInt(101);
        this.isPoisoned = false;
        this.isFrozen = false;
        this.isSleeping = false;
        this.isBlind = false;
    }

    public void setNormalAtk(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public int getNormalAtk() {
        return this.normalAttack;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean isPoisoned) {
        this.isPoisoned = isPoisoned;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public boolean isBlind() {
        return isBlind;
    }

    public void setBlind(boolean isBlind) {
        this.isBlind = isBlind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int decreaseHealth(int damage) {
        return health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getMaximumHP() {
        return maximumHP;
    }

    public void setMaximumHP(int maximumHP) {
        this.maximumHP = maximumHP;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public int basicAttack() {
        if (this.isBlind) {
            this.accuracy = 0;
        } else {
            this.accuracy = this.r.nextInt(101);
        }

        if (this.accuracy >= 30) {
            return this.baseAttack;
        } else {
            return 0;
        }
    }

    public int elementalSkill() {
        if (this.isBlind) {
            this.accuracy = 0;
        } else {
            this.accuracy = this.r.nextInt(101);
        }

        if (this.accuracy >= 30) {
            return (this.baseAttack + 2);
        } else {
            return 0;
        }
    }

    public boolean isBurning() {
        return this.isBurning;
    }

    public void setBurning(boolean isBurning) {
        this.isBurning = isBurning;
    }

    public boolean isSeeded() {
        return this.isSeeded;
    }

    public void setSeeded(boolean isSeeded) {
        this.isSeeded = isSeeded;
    }

    public boolean isStunned() {
        return this.isStunned;
    }

    public void setStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }
}
