import java.util.Scanner;

public class BattleTest {
    public static void main(String[] args) {
        Hero testHero = new Hero("heroi", "masculino");
        Enemy testEnemy = new Enemy("inimigo");
        Sword sword = new Sword();
        StatusChecker statusChecker = new StatusChecker(testEnemy, testHero);
        BattleSystem battleSystem = new BattleSystem(testHero, testEnemy, statusChecker);
        int element;
        Scanner sc = new Scanner(System.in);
        System.out.print("Escolha o elemento: ");
        element = sc.nextInt();
        testHero.setElementInt(element);
        testHero.setWeapon(sword);
        battleSystem.Battle(testHero, testEnemy);
        sc.close();
    }
}
