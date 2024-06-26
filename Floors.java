import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Floors {
    private Hero hero;
    private Enemy enemy;
    private int floor;
    private BattleSystem battleSystem;
    private Random random;

    public Floors(Hero hero) {
        this.hero = hero;
        this.floor = 1;
        startAdventure();
        this.random = new Random();
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
                public void windowClosed(WindowEvent e) {
                    if (hero.getHp() > 0) {
                        JOptionPane.showMessageDialog(null, "K.O! "+hero.getName()+" venceu!");
                        floor++;
                        hero.increaseEXP(floor + 5);
                        hero.increaseMoney(random.nextInt(201, 501));
                        if (hero.getExp() >= hero.getMaximumEXP()) {
                            hero.heroLevelUp();
                        }
                        showStoreScreen();
                    } else {
                        CrudBD cBD = new CrudBD();
                        cBD.incluirReg(hero);
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
        Random r = new Random();
        Enemy enemy = new Enemy();
        enemy.setLevel(floor);
        enemy.setBaseAttack(hero.getBaseAttack() + floor * 2);
        enemy.setMaximumHP(enemy.getHealth() + floor * 3);
        enemy.setHealth(enemy.getMaximumHP());
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