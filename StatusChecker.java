public class StatusChecker {
    private Enemy enemy;

    public StatusChecker(Enemy enemy) {
        this.enemy = enemy;
    }

    public void checkStatusConditions() {
        if (enemy.isPoisoned()) {
            handlePoisoned();
        }
        if (enemy.isFrozen()) {
            handleFrozen();
        }
        if (enemy.isSleeping()) {
            handleSleeping();
        }
        if (enemy.isBlind()) {
            handleBlind();
        }
    }

    private void handlePoisoned() {
        System.out.println(enemy.getName() + " ficou envenenado!");
        enemy.decreaseHealth(5);
    }

    private void handleFrozen() {
        System.out.println(enemy.getName() + " esta congelado!");
    }

    private void handleSleeping() {
        System.out.println(enemy.getName() + " dormiu!");
    }

    private void handleBlind() {
        System.out.println(enemy.getName() + " ficou cego!");
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
}
