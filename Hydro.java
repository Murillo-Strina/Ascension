public class Hydro implements Element
{
    private int damageValue;
    private int healValue;

    Public Hydro()
    {
        this.healValue = 10;
        this.damageValue = 10;
    }

    public int ElementSkillA()
    {
        //jato
        return this.damageValue;
    }

    public int ElementSkillB()
    {
        //cura
        return this.damageValue;
    }
}
