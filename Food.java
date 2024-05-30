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

    public Food() {
        super("Comida", generateCost());
        this.setCost(cost);
        sortFood();
    }

    public void sortFood() {
        int index = r.nextInt(foodTypes.length);
        this.type = foodTypes[index];
        this.effect = effects[index];
    }

    private static int generateCost() {
        return (int) (Math.random() * 50 + 50);
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }

    public String[] getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(String[] foodTypes) {
        this.foodTypes = foodTypes;
    }

    public String[] getEffects() {
        return effects;
    }

    public void setEffects(String[] effects) {
        this.effects = effects;
    }

    public String showFoodDetails() {
        return "Detalhes da Comida:\n" +
                "----------------\n" +
                "Tipo: " + type + "\n" +
                "Efeito: " + effect + "\n" +
                "----------------";
    }

}
