import javax.swing.*;

public class Floors {
    private Hero hero;
    private Enemy enemy;
    private int floor;
    private BattleSystem battleSystem;

    public Floors() {
        this.hero = new Hero(null, null);
        this.enemy = new Enemy();
        this.floor = 1;
        this.battleSystem = new BattleSystem(hero, enemy, new StatusChecker(null, hero));
        startAdventure();
    }

    public void startAdventure() {
        while (hero.getHp() > 0) {
            Enemy enemy = generateEnemyForCurrentFloor();
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
        return new Enemy();
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

        store.setStoreClosedListener(() -> {
            floor.startAdventure();
        });

        store.showStore();
    }
}