import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int baseAttack;
    private int level;
    private int spd;
    private int maximumHP;
    private boolean isPoisoned;
    private boolean isFrozen;
    private boolean isSleeping;
    private boolean isBlind;
    private int accuracy;
    private Random r = new Random();
    private Hero hero;

    public Enemy(String name) {
        this.name = name;
        this.health = hero.getMaximumHP();
        this.maximumHP = hero.getMaximumHP();
        this.accuracy = r.nextInt(101);
        this.isPoisoned = false;
        this.isFrozen = false;
        this.isSleeping = false;
        this.isBlind = false;
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
}
