public class Pyro implements Element
{
    private int burnDamage;
    private int buffValue;
    private int burnDuration;
    private boolean targetBurning;

    public Pyro()
    {
        this.burnDamage = 2;
        this.burnDuration = 2;
        this.buffValue = 2;
        this.targetBurning = false;
    }

    public int ElementSkillA()
    {
        return this.burnDamage;
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