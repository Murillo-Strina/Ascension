public class Hero {
    private int hp;
    private String name;
    private String gender;
    private int baseAttack;
    private int level;
    private int coins;
    private int exp;
    private int maximumEXP;
    private int spd;
    private int maximumHP;

    public Hero(String name, String gender) {
        this.hp = 20;
        this.name = name;
        this.gender = gender;
        this.exp = 0;
        this.level = 1;
        this.baseAttack = 5;
        this.maximumEXP = 10;
        this.coins = 1000;
        this.spd = 10;
        this.maximumHP = 20;
    }

    public int heroLevelUp() {
        if (exp >= maximumEXP) {
            exp -= maximumEXP;
            level += 1;
            upgradeStats();
            exp = 0;
            return level;
        } else {
            return 0;
        }
    }

    public void upgradeStats() {
        this.baseAttack += 5;
        this.spd += 2;
        this.maximumEXP += 10;
        this.maximumHP += 20;
        this.hp = this.maximumHP;
    }

    public String showStats() {
        return "================\n" + "Status do herói:\n" +
                "Nome: " + name + "\n" +
                "Gênero: " + gender + "\n" +
                "Nível: " + level + "\n" +
                "HP: " + hp + "/" + maximumHP + "\n" +
                "Ataque: " + baseAttack + "\n" +
                "Velocidade: " + spd + "\n" +
                "EXP: " + exp + "/" + maximumEXP + "\n" +
                "================\n";
    }

    public void increaseHp(int amount) {
        this.hp += amount;
        if (this.hp > this.maximumHP)
            this.hp = this.maximumHP;

    }

    public void increaseMaximumHp(int amount) {
        this.maximumHP += amount;
    }

    public void increaseSpeed(int amount) {
        this.spd += amount;
    }

    public void increaseAttack(int amount) {
        this.baseAttack += amount;
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

    public int getMaximumEXP() {
        return maximumEXP;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public void setMaximumEXP(int maximumEXP) {
        this.maximumEXP = maximumEXP;
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
