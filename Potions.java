import java.util.Random;

public class Potions {
    private String name;
    private int cost;
    private String rarity;
    private int healingValue;
    private Random r = new Random();
    private int sorter;

    private String[] rarities = { "Comum", "Rara", "Épica", "Lendária" };
    private int[] healingValues = { 10, 50, 100, 99999 };

    public Potions() {
        this.sorter = r.nextInt(4);
        this.rarity = rarities[sorter];
        this.healingValue = healingValues[sorter];
        this.cost = costValue();
        this.name = "Poção " + this.rarity;
    }

    public int costValue() {
        switch (this.rarity) {
            case "Comum":
                return 50;
            case "Rara":
                return 100;
            case "Épica":
                return 200;
            case "Lendária":
                return 500;
            default:
                return 10;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getHealingValue() {
        return healingValue;
    }

    public void setHealingValue(int healingValue) {
        this.healingValue = healingValue;
    }

    public String showPotionDetails() {
        if (healingValue == 99999)
            return "Detalhes da Poção:\n" +
                    "----------------\n" +
                    "Nome: " + name + "\n" +
                    "Custo: " + cost + "\n" +
                    "Cura: Full Hp\n" +
                    "----------------";
        else
            return "Detalhes da Poção:\n" +
                    "----------------\n" +
                    "Nome: " + name + "\n" +
                    "Custo: " + cost + "\n" +
                    "Cura: " + healingValue + " Hp\n" +
                    "----------------";
    }

    public static void main(String[] args) {
        Potions potion = new Potions();
        System.out.println(potion.showPotionDetails());

    }

}
