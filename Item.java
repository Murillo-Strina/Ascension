public abstract class Item {
    private String name;
    private int cost;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    protected void setCost(int cost) {
        this.cost = cost;
    }

    public abstract void applyEffect(Hero hero);

    @Override
    public String toString() {
        return name + " (Custo: " + cost + ")";
    }
}
