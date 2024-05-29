import javax.swing.SwingUtilities;

public class BattleTest {
    public static void main(String[] args) {
        // Instancia os objetos necessários para a batalha
        Hero testHero = new Hero("heroi", "masculino");
        Enemy testEnemy = new Enemy("inimigo");
        Sword sword = new Sword();
        StatusChecker statusChecker = new StatusChecker(testEnemy, testHero);
        
        // Configura o herói com uma arma
        testHero.setWeapon(sword);
        
        // Instancia o sistema de batalha
        BattleSystem battleSystem = new BattleSystem(testHero, testEnemy, statusChecker);
        
        // Inicia a interface gráfica para controlar a batalha
        SwingUtilities.invokeLater(() -> {
            new BattleSystemGUI(battleSystem);
        });
    }
}
