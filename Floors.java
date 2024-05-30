import javax.swing.*;
import java.util.Random;

public class Floors {
    private Hero hero;
    private Enemy enemy;
    private int floor;
    private BattleSystem battleSystem;
    private Random r;

    public Floors() {
        this.hero = new Hero("Hero Name", "Hero Gender");
        this.r = new Random();
        this.floor = 1;
        startAdventure();
    }

    public void startAdventure() {
        while (hero.getHp() > 0) {
            enemy = generateEnemyForCurrentFloor();
            this.battleSystem = new BattleSystem(hero, enemy, new StatusChecker(enemy, hero));
            BattleSystemGUI battleGUI = new BattleSystemGUI(battleSystem, floor); // Passando o piso

            waitForBattleToEnd(battleGUI);

            if (hero.getHp() > 0) {
                floor++;
                hero.setExp(floor + 5);
                hero.increaseMoney(r.nextInt(501));
                showStoreScreen();
            }
        }
        showGameOverMessage();
    }

    private void waitForBattleToEnd(BattleSystemGUI battleGUI) {
        while (battleGUI.isVisible()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
        StoreScreen storeScreen = new StoreScreen(this.hero);
        storeScreen.setVisible(true);

        while (storeScreen.isVisible()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showGameOverMessage() {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, "Game Over! Você chegou no piso " + floor,
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }
}
