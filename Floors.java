import javax.swing.*;
import java.awt.event.*;

public class Floors {
    private Hero hero;
    private Enemy enemy;
    private int floor;
    private BattleSystem battleSystem;

    public Floors(Hero hero) {
        this.hero = hero;
        this.floor = 1;
        startAdventure();
    }

    public void startAdventure() {
        processNextBattle();
    }

    private void processNextBattle() {
        if (hero.getHp() <= 0) {
            showGameOverMessage();
            return;
        }

        enemy = generateEnemyForCurrentFloor();
        this.battleSystem = new BattleSystem(hero, enemy, new StatusChecker(enemy, hero));

        SwingUtilities.invokeLater(() -> {
            BattleSystemGUI battleGUI = new BattleSystemGUI(battleSystem, floor);
            battleGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (hero.getHp() > 0) {
                        floor++;
                        hero.increaseEXP(floor + 5);
                        hero.increaseMoney(floor * 100);
                        if (hero.getExp() >= hero.getMaximumEXP()) {
                            hero.heroLevelUp();
                        }
                        showStoreScreen();
                    } else {
                        showGameOverMessage();
                    }
                }
            });
        });
    }

    private void showStoreScreen() {
        SwingUtilities.invokeLater(() -> {
            StoreScreen storeScreen = new StoreScreen(this.hero);
            storeScreen.setVisible(true);
            storeScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    processNextBattle();
                }
            });
        });
    }

    private Enemy generateEnemyForCurrentFloor() {
        Enemy enemy = new Enemy();
        enemy.setLevel(floor);
        enemy.setHealth(30 + (floor * 5));
        enemy.setBaseAttack(5 + (floor * 2));
        enemy.setMaximumHP(enemy.getHealth());
        return enemy;
    }

    private void showGameOverMessage() {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, "Game Over! Você chegou no piso " + floor,
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
    }
}
