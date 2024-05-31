public class StatusChecker {
    private Enemy enemy;
    private Hero hero;
    private StringBuilder messageLog;

    public StatusChecker(Enemy enemy, Hero hero) {
        this.enemy = enemy;
        this.hero = hero;
        this.messageLog = new StringBuilder();
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
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
        if (enemy.isBurning()) {
            handleBurning();
            burnEnemy();
        }
        if (enemy.isSeeded()) {
            handleSeeded();
            growSeeds();
        }
        if (enemy.isStunned()) {
            handleStunned();
            stun();
        }
    }

    private void handlePoisoned() {
        messageLog.append(enemy.getName()).append(" ficou envenenado!\n");
        enemy.decreaseHealth(5);
    }

    private void handleFrozen() {
        messageLog.append(enemy.getName()).append(" está congelado!\n");
    }

    private void handleSleeping() {
        messageLog.append(enemy.getName()).append(" dormiu!\n");
    }

    private void handleBlind() {
        messageLog.append(enemy.getName()).append(" ficou cego!\n");
    }

    private void handleBurning() {
        messageLog.append(enemy.getName()).append(" está queimando!\n");
    }

    private void handleSeeded() {
        messageLog.append("\nCresceram sementes em ").append(enemy.getName()).append("!\n");
    }

    private void handleStunned() {
        messageLog.append(enemy.getName()).append(" está atordoado!\n");
    }

    public void poisonEnemy() {
        enemy.setPoisoned(true);
    }

    public void freezeEnemy() {
        enemy.setFrozen(true);
        enemy.setSpd(0);
    }

    public void putEnemyToSleep() {
        enemy.setSleeping(true);
    }

    public void blindEnemy() {
        enemy.setBlind(true);
    }

    public void burnEnemy() {
        enemy.setBaseAttack(enemy.getBaseAttack() / 2);
    }

    public void growSeeds() {
        enemy.setHealth(enemy.getHealth() - 1);
        hero.increaseHp(1);
    }

    public void stun() {
        enemy.setStunned(true);
    }

    public void normalizeStatus() {
        enemy.setPoisoned(false);
        enemy.setFrozen(false);
        enemy.setBlind(false);
        enemy.setSleeping(false);
        enemy.setBaseAttack(enemy.getNormalAtk());
        enemy.setStunned(false);
    }

    public String getMessageLog() {
        return messageLog.toString();
    }

    public void clearMessageLog() {
        messageLog.setLength(0);
    }
}
