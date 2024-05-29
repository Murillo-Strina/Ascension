import java.util.Random;

public class Potions extends Item {
    private String rarity;
    private int healingValue;
    private Random r = new Random();
    private int sorter;

    private String[] rarities = { "Comum", "Rara", "Épica", "Lendária" };
    private int[] healingValues = { 10, 50, 100, 99999 };

    public Potions() {
        super("Poção", generateCost());
        this.sorter = r.nextInt(4);
        this.rarity = rarities[sorter];
        this.healingValue = healingValues[sorter];
        this.setCost(generateCost());
    }

    private static int generateCost() {
        return (int) (Math.random() * 100 + 50);
    }

    @Override
    public void applyEffect(Hero hero) {
        hero.increaseHp(this.healingValue);
    }

    public String showPotionDetails() {
        return "Detalhes da Poção:\n" +
                "----------------\n" +
                "Nome: " + getName() + "\n" +
                "Custo: " + getCost() + "\n" +
                "Cura: " + (healingValue == 99999 ? "Full Hp" : healingValue + " Hp") + "\n" +
                "----------------";
    }
}
