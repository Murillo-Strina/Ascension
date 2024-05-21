import java.util.Random;

public class Dendro implements Element {
    private Random random;
    private int accuracy;
    private int dendroDamage;
    private boolean enemySeeded;

    public Dendro()
    {
        this.random = new Random();
        this.accuracy = random.nextInt(101);
        this.dendroDamage = 10;
        this.enemySeeded = false;
    }

    public int ElementSkillA()
    {
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            return dendroDamage;
        }

        else
        {
            return 0;
        }
    }

    public int ElementSkillB()
    {
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            this.enemySeeded = true;
            return dendroDamage/2;
        }

        else
        {
            this.enemySeeded = false;
            return 0;
        }
    }

    public void setSeeded(boolean seedStatus)
    {
        this.enemySeeded = seedStatus;
    }

    public boolean isSeeded()
    {
        return this.enemySeeded;
    }

    public int getDendroDamage()
    {
        return this.dendroDamage;
    }

    public void setDendroDamage(int dendroDamage)
    {
        this.dendroDamage = dendroDamage;
    }
}
