public class StatusChecker {
    private Enemy enemy;
    private Hero hero;

    public StatusChecker(Enemy enemy, Hero hero) {
        this.enemy = enemy;
        this.hero = hero;
    }

    public void checkStatusConditions() {
        if (enemy.isPoisoned()) {
            handlePoisoned();
            poisonEnemy();
        }
        if (enemy.isFrozen()) {
            handleFrozen();
            freezeEnemy();
        }
        if (enemy.isSleeping()) {
            handleSleeping();
            putEnemyToSleep();
        }
        if (enemy.isBlind()) {
            handleBlind();
            blindEnemy();
        }
        if(enemy.isBurning())
        {
            handleBurning();
            burnEnemy();
        }
        if(enemy.isSeeded())
        {
            handleSeeded();
            growSeeds();
        }
        if(enemy.isStunned())
        {
            handleStunned();
            stun();
        }
    }

    private void handlePoisoned() {
        System.out.println(enemy.getName() + " ficou envenenado!");
        enemy.decreaseHealth(5);
    }

    private void handleFrozen() {
        System.out.println(enemy.getName() + " está congelado!");
    }

    private void handleSleeping() {
        System.out.println(enemy.getName() + " dormiu!");
    }

    private void handleBlind() {
        System.out.println(enemy.getName() + " ficou cego!");
    }

    private void handleBurning()
    {
        System.out.println(enemy.getName() + " está queimando!");
    }

    private void handleSeeded()
    {
        System.out.println("Cresceram sementes em " + enemy.getName() + "!");
    }

    private void handleStunned()
    {
        System.out.println(enemy.getName() + " está atordoado!");
    }

    public void poisonEnemy() {
        enemy.setPoisoned(true);
    }

    public void freezeEnemy() {
        enemy.setFrozen(true);
    }

    public void putEnemyToSleep() {
        enemy.setSleeping(true);
    }

    public void blindEnemy() {
        enemy.setBlind(true);
    }

    public void burnEnemy()
    {
        enemy.setBaseAttack(enemy.getBaseAttack()/2);
    }

    public void growSeeds()
    {
        enemy.setHealth(enemy.getHealth() - 1);
        hero.increaseHp(1);
    }

    public void stun()
    {
        enemy.setStunned(true);
    }

    public void normalizeStatus()
    {
        enemy.setPoisoned(false);
        enemy.setFrozen(false);
        enemy.setBlind(false);
        enemy.setSleeping(false);
        enemy.setBaseAttack(enemy.getNormalAtk());
        enemy.setStunned(false);
    }
}