import javax.swing.*;

public class Floors {
    private Hero hero;
    private Enemy enemy;
    private int floor;
    private BattleSystem battleSystem;

    public Floors() {
        this.hero = new Hero("Hero Name", "Hero Gender");
        this.enemy = generateEnemyForCurrentFloor();
        this.floor = 1;
        this.battleSystem = new BattleSystem(hero, enemy, new StatusChecker(null, hero));
        startAdventure();
    }

    public void startAdventure() {
        while (hero.getHp() > 0) {
            enemy = generateEnemyForCurrentFloor();
            this.battleSystem.setEnemy(enemy);
            battleSystem.Battle(hero, enemy);
            if (hero.getHp() > 0) {
                floor++;
                hero.setExp(floor + 5);
                System.out.println(hero.showStats());
                showStoreScreen();
            }
        }
        showGameOverMessage();
    }

    private Enemy generateEnemyForCurrentFloor() {
        Enemy enemy = new Enemy();
        enemy.setLevel(floor);
        enemy.setHealth(30 + (floor * 5));
        enemy.setBaseAttack(5 + (floor * 2));
        enemy.setMaximumHP(enemy.getHealth());
        return enemy;
    }

    private void showStoreScreen() {
        SwingUtilities.invokeLater(() -> new StoreScreen());
    }

    private void showGameOverMessage() {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Game Over! Você chegou no piso " + floor,
                "Game Over", JOptionPane.INFORMATION_MESSAGE));
    }

    public static void main(String[] args) {
        Floors floor = new Floors();
        Store store = new Store();
        store.showStore();
    }
}
