import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    private int slots;
    private Random r = new Random();
    List<Item> rItems = new ArrayList<>();

    public Store() {
        this.slots = 4;
    }

    public void sortSlot() {
        for (int i = 0; i < slots; i++) {
            int j = r.nextInt(3);
            switch (j) {
                case 0:
                    rItems.add(new Potions());
                    break;
                case 1:
                    rItems.add(new Artifacts());
                    break;
                case 2:
                    rItems.add(new Food());
            }
        }
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String showStore() {
        StringBuilder sb = new StringBuilder();
        sb.append("Itens na loja:\n");
        for (Item item : rItems) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

  
}