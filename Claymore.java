import java.util.Random;

public class Claymore implements Weapon {
    private int attack;
    private String name;
    private double critRate;
    private int critDamage;
    private int spd;
    private int additionalHp;
    private int accuracy;
    private Random r = new Random();
    private int upgrade;
    private boolean isBlocking;
    Hero hero = new Hero();

    public Claymore() {
        this.attack = 15;
        this.name = "Espadão";
        this.critRate = 0.4;
        this.critDamage = 2 * this.attack;
        this.additionalHp = 30;
        this.accuracy = r.nextInt(101);
        this.spd = 5;
        this.upgrade = hero.getLevel() / 5;
        this.isBlocking = false;
    }

    public void weaponEquiped(Hero hero) {
        hero.increaseAttack(this.attack);
        hero.increaseMaximumHp(this.additionalHp);
        hero.increaseSpeed(this.spd);
    }

    public int WeaponSkillB() {
        this.isBlocking = true;
        return this.spd = 100;
    }

    public int CritAttack() {
        if (r.nextDouble() > critRate) {
            return critDamage;
        } else {
            return 1;
        }
    }

    public String StatusWeapon() {
        String msg = "Detalhes da Arma:\n" +
                "----------------\n" +
                "Tipo: " + name + "\n" +
                "Ataque: " + attack + "\n" +
                "Taxa crítica: " + (critRate * 100) + "%\n" +
                "HP adicional: " + additionalHp + "\n" +
                "Velocidade: " + spd + "\n"
                + "----------------";
        return msg;
    }

    public int WeaponSkillA() {
        int totalDamage = 0;
        for (int i = 1; i <= this.upgrade + 2; i++) {
            this.accuracy = r.nextInt(101);
            if (this.accuracy >= 30) {
                if (CritAttack() != 1) {
                    totalDamage += this.critDamage;
                    System.out.println("Ataque " + i + ":" + " Critou!");
                } else {
                    totalDamage += this.attack;
                    System.out.println("Ataque " + i + ":" + " Dano normal");
                }
            } else {
                System.out.println("Errou!");
            }
        }
        return totalDamage;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int NormalizeAttack() {
        return this.attack /= 2;
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

    public void setCritRate(double critRate) {
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