import java.util.Random;

public class Food extends Item {
    private int cost;
    private String effect;
    private String type;
    private Random r = new Random();

    private String[] foodTypes = { "Chicken", "Candy", "Fruit", "Golden Wine" };
    private String[] effects = {
            "Aumenta HP adicional em 10",
            "Aumenta velocidade em 5",
            "Aumenta ataque em 5",
            "Aumenta nível em 1"
    };
    private int[] costs = { 20, 15, 30, 100 };

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

    public String showFoodDetails() {
        return "Detalhes da Comida:\n" +
                "----------------\n" +
                "Tipo: " + type + "\n" +
                "Efeito: " + effect + "\n" +
                "Custo: " + cost + "\n" +
                "----------------";
    }

    public static void main(String[] args) {
        Food food = new Food();
        System.out.println(food.showFoodDetails());
    }
}
