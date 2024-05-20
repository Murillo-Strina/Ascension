public class Hero {
    private int hp;
    private String name;
    private String gender;
    private int baseAttack;
    private int level;
    private int exp;
    private int maximumEXP;

    public Hero(int hp, String name, String gender) {
        this.hp = hp;
        this.name = name;
        this.gender = gender;
        this.exp = 0;
        this.level = 1;
        this.baseAttack = 5;
        this.maximumEXP = 10;
    }

    public int heroLevelUp() {
        if (exp >= maximumEXP) {
            exp = 0;
            return level += 1;
        } else
            return 0;
    }

    public void upgradeStats() {
        for (int i = 1; i <= level; i++) {
            this.hp += 10;
            this.baseAttack += 5;
            this.maximumEXP += 50;
        }
    }

    public String showStats() {
        upgradeStats();
        return "================\n" + "Hero Stats:\n" +
                "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Level: " + level + "\n" +
                "HP: " + hp + "\n" +
                "Base Attack: " + baseAttack + "\n" +
                "EXP: " + exp + "/" + maximumEXP + "\n" +
                "================\n";
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
