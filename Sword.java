import java.util.Random;

public class Sword implements Weapon {
    private int attack;
    private String name;
    private double critRate;
    private int critDamage;
    private int spd;
    private int additionalHp;
    private int accuracy;
    private Random r = new Random();
    private int upgrade;
    Hero hero = new Hero();

    public Sword() {
        this.attack = 5;
        this.name = "Espada";
        this.critRate = 0.6;
        this.critDamage = 2 * this.attack;
        this.additionalHp = 15;
        this.accuracy = r.nextInt(101);
        this.upgrade = hero.getLevel() / 5;
    }

    public int WeaponSkillA() {
        this.accuracy = r.nextInt(101);
        if (this.accuracy >= 30) {
            if (CritAttack() != 1) {
                return critDamage * 3 + upgrade;
            } else
                return attack * 3 + upgrade;
        } else {
            return 0;
        }
    }

    public int CritAttack() {
        if (r.nextDouble(101) / 100 > critRate) {
            return critDamage;
        } else
            return 1;
    }

    public String StatusWeapon() {
        String msg = "Detalhes da Arma:\n" +
                "----------------\n" +
                "Tipo: " + name + "\n" +
                "Ataque: " + attack + "\n" +
                "Taxa crítica: " + (critRate * 100) + "%\n" +
                "HP adicional: " + additionalHp + "\n" + "----------------";
        return msg;
    }

    public int WeaponSkillB() {
        return this.attack *= 2;
    }

    public int NormalizeAttack() {
        return this.attack /= 2;
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

    public double getCritRate() {
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

}
