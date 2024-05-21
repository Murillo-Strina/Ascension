public class Hero {
    private int hp;
    private String name;
    private String gender;
    private int baseAttack;
    private int level;
    private int coins;
    private int exp;
    private int maximumEXP;

    public Hero(String name, String gender) {
        this.hp = 20;
        this.name = name;
        this.gender = gender;
        this.exp = 0;
        this.level = 1;
        this.baseAttack = 5;
        this.maximumEXP = 10;
        this.coins = 0;
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
        return "================\n" + "Status do herói:\n" +
                "Nome: " + name + "\n" +
                "Gênero: " + gender + "\n" +
                "Nível: " + level + "\n" +
                "HP: " + hp + "\n" +
                "Ataque: " + baseAttack + "\n" +
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

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
