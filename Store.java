import java.util.Random;

public class Store {
    private int slots;
    Potions potions = new Potions();
    Random r = new Random();

    private String[] itens = { "Potions", "Artifacts", "Épica", "Lendária" };

    public Store() {
        this.slots = 4;
    }

    public String sortSlots() {

    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

}
