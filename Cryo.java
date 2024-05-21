import java.util.Random;

public class Cryo implements Element {
    private Random random;
    private int accuracy;
    private int cryoDamage;
    private boolean enemyFrozen;

    public Cryo()
    {
        this.random = new Random();
        this.accuracy = random.nextInt(101);
        this.cryoDamage = 10;
        this.enemyFrozen = false;
    }

    public int ElementSkillA()
    {
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            return this.cryoDamage;
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
            this.enemyFrozen = true;
            return this.cryoDamage/2;
        }

        else
        {
            return 0;
        }
    }

    public boolean isFrozen()
    {
        return this.enemyFrozen;
    }

    public void setFrozen(boolean frozenStatus)
    {
        this.enemyFrozen = frozenStatus;
    }

    public int getCryoDamage()
    {
        return this.cryoDamage;
    }

    public void setCryoDamage(int cryoDamage)
    {
        this.cryoDamage = cryoDamage;
    }
}
