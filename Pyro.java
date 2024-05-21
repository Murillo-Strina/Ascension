import java.util.Random;

public class Pyro implements Element
{
    private int burnDamage;
    private int buffValue;
    private int burnDuration;
    private boolean targetBurning;
    private Random random;
    private int accuracy;

    public Pyro()
    {
        this.random = new Random();
        this.burnDamage = 2;
        this.burnDuration = 2;
        this.buffValue = 2;
        this.targetBurning = false;
        this.accuracy = 30;
    }

    public int ElementSkillA()
    {
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            this.targetBurning = true;
            return this.burnDamage;
        }

        else
        {
            return 0;
        }

    }

    public int ElementSkillB()
    {
        return this.buffValue;
    }

    public void SetBurn(boolean setBurn)
    {
        this.targetBurning = setBurn;
    }

    public boolean GetBurn()
    {
        return this.targetBurning;
    }

    public int GetDuration()
    {
        return this.burnDuration;
    }
}
