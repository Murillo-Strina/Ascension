public class Enemy {
    private String element;
    private int hp;
    private int atk;
    private int cr;
    private int cd;
    private int acc;
    private String name;
    private int spd;

    public Enemy(String element, int hp, int atk, int cr, int cd, int acc, String name, int spd) {
        this.element = element;
        this.hp = hp;
        this.atk = atk;
        this.cr = cr;
        this.cd = cd;
        this.acc = acc;
        this.name = name;
        this.spd = spd;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int Attack()
    {
        return this.atk;
    }
}
