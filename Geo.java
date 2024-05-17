import java.util.Random;

public class Geo implements Element {
    private int shieldValue;
    private int geoDamage;
    private int shieldDuration;
    private boolean isShielded;
    private int accuracy;
    private Random random;

    public Geo()
    {
        this.shieldValue = 5;
        this.shieldDuration = 1;
        this.geoDamage = 10;
        this.isShielded = false;
        this.accuracy = random.nextInt(101);
    }

    public int ElementSkillA() //pedrada
    {
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            return geoDamage;
        }

        else
        {
            return 0;
        }
    }

    public int ElementSkillB() //shield
    {
        this.isShielded = true;
        return shieldValue;
    }

    public void setShieldValue(int shieldValue) {
        this.shieldValue = shieldValue;
    }

    public void setGeoDamage(int geoDamage) {
        this.geoDamage = geoDamage;
    }

    public int getShieldDuration() {
        return shieldDuration;
    }

    public void setShieldDuration(int shieldDuration) {
        this.shieldDuration = shieldDuration;
    }

    public boolean isShielded() {
        return isShielded;
    }

    public void setShielded(boolean isShielded) {
        this.isShielded = isShielded;
    }
}
