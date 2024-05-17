import java.util.Random;

public class Hydro implements Element
{
    private int damageValue;
    private int healValue;
    private Random random;
    private int accuracy;

    public Hydro()
    {
        this.healValue = 10;
        this.damageValue = 10;
        this.accuracy = random.nextInt(101);
    }

    public int ElementSkillA()
    {
        //jato
        this.accuracy = random.nextInt(101);
        if(this.accuracy >= 30)
        {
            return this.damageValue;
        }

        else
        {
            return 0;
        }
    }

    public int ElementSkillB()
    {
        //cura
        return this.healValue;
    }
}
