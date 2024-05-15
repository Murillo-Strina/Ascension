import java.util.Random;

public class Sword implements Weapon {
    private int attack;
    private String name;
    private int critRate;
    private int critDamage;
    private int spd;
    private int additionalHp;
    private int accuracy;
    private Random r = new Random();
    private int upgrade;
    Hero hero = new Hero();

    public Sword() {
        this.attack = 5;
        this.name = "Sword";
        this.critRate = 3 / 5;
        this.critDamage = 2 * this.attack;
        this.additionalHp = 15;
        this.accuracy = r.nextInt(101);
        this.upgrade = hero.getLevel() / 5;
    }

    public int WeaponSkillA() {
        this.accuracy = r.nextInt(101);
        if (this.accuracy >= 30) {
            return attack * 3 + upgrade;
        } else {
            return 0;
        }
    }

    public int WeaponSkillB() {

        return 2;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCritRate() {
        return critRate;
    }

    public void setCritRate(int critRate) {
        this.critRate = critRate;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getAdditionalHp() {
        return additionalHp;
    }

    public void setAdditionalHp(int additionalHp) {
        this.additionalHp = additionalHp;
    }

    public static void main(String[] args) {
        Sword sword = new Sword();
        int f = sword.WeaponSkillA();
        System.err.println(f);

    }

}
