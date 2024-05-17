import java.util.Random;

public class Electro implements Element{
    private Random random;
    private int accuracy;
    private int electroDamage;
    private boolean stunSuccessful;
    private int stunDuration;

    public Electro()
    {
        this.accuracy = random.nextInt(101);
        this.electroDamage = 10;
        this.stunDuration = 2;
        this.stunSuccessful = false;
    }

    public int ElementSkillA()
    {
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            this.stunSuccessful = true;
            return this.electroDamage/2;
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
            return this.electroDamage;
        }

        else
        {
            return this.electroDamage;
        }
    }

    public boolean enemyStunned()
    {
        return this.stunSuccessful;
    }

    public void setStunStatus(boolean stunStatus)
    {
        this.stunSuccessful = stunStatus;
    }

    public int getStunDuration()
    {
        return this.stunDuration;
    }

    public void setStunDuration(int stunDuration)
    {
        this.stunDuration = stunDuration;
    }

    public int getElectroDamage()
    {
        return this.electroDamage;
    }

    public void setElectroDamage(int electroDamage)
    {
        this.electroDamage = electroDamage;
    }
}
