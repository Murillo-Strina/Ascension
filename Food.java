import java.util.Random;

public class Food extends Item {
    private int cost;
    private String effect;
    private String type;
    private Random r = new Random();

    private String[] foodTypes = { "Frango", "Doce", "Fruta", "Vinho Dourado" };
    private String[] effects = {
            "Aumenta HP adicional em 10",
            "Aumenta velocidade em 5",
            "Aumenta ataque em 5",
            "Aumenta nível em 1"
    };
    private int[] costs = { 20, 15, 30, 200 };

    public Food() {
        super("Comida");
        sortFood();
        this.cost = costValue();
    }

    public void sortFood() {
        int index = r.nextInt(foodTypes.length);
        this.type = foodTypes[index];
        this.effect = effects[index];
    }

    public int costValue() {
        for (int i = 0; i < foodTypes.length; i++) {
            if (type.equals(foodTypes[i])) {
                return costs[i];
            }
        }
        return 0;
    }

    public void applyEffect(Hero hero) {
        switch (type) {
            case "Frango":
                hero.increaseMaximumHp(10);
                break;
            case "Doce":
                hero.increaseSpeed(5);
                break;
            case "Fruta":
                hero.increaseAttack(5);
                break;
            case "Vinho Dourado":
                int fullExp = hero.getMaximumEXP();
                hero.setExp(fullExp);
                hero.heroLevelUp();
                break;
        }
    }

    public String showFoodDetails() {
        return "Detalhes da Comida:\n" +
                "----------------\n" +
                "Tipo: " + type + "\n" +
                "Efeito: " + effect + "\n" +
                "Custo: " + cost + "\n" +
                "----------------";
    }

}
