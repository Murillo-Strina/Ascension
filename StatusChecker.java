public class StatusChecker
{
    private Hero hero;
    private Enemy enemy;
    private Dendro dendro;
    private Electro electro;
    private Cryo cryo;
    private Geo geo;
    private Hydro hydro;
    private Pyro pyro;
    private boolean heroStunned, enemyStunned, heroSeeded, enemySeeded, heroBuffed, enemyBuffed, heroShielded, enemyShielded, heroSlowed, enemySlowed;

    public StatusChecker()
    {
        this.hero = new Hero(null, null);
        this.enemy = new Enemy(null, 0, 0, 0, 0, null, 0);
        this.dendro = new Dendro();
        this.electro = new Electro();
        this.cryo = new Cryo();
        this.geo = new Geo();
        this.hydro = new Hydro();
        this.pyro = new Pyro();
        this.heroStunned = false;
        this.enemyStunned = false;
        this.heroSeeded = false;
        this.enemyStunned = false;
        this.heroBuffed = false;
        this.enemyBuffed = false;
        this.heroShielded = false;
        this.enemyShielded = false;
        this.heroSlowed = false;
        this.enemySlowed = false;
    }

    public void setHero(Hero hero)
    {
        this.hero = hero;
    }

    public void setEnemy(Enemy enemy)
    {
        this.enemy = enemy;
    }

    public void checkEnemy()
    {
        //stun electro
        if(this.electro.enemyStunned() == true)
        {
            this.enemyStunned = true;
        }

        //seed dendro
        if(this.dendro.isSeeded() == true)
        {
            this.enemySeeded = true;
        }
    }
}
