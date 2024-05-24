import java.util.ArrayList;
import java.util.List;

public class Store {
    private int slots;
    private List<Item> rItems;

    public Store() {
        this.slots = 3;
        this.rItems = new ArrayList<>();
        sortSlot();
    }

    public void sortSlot() {
        rItems.clear();

        rItems.add(new Potions());
        rItems.add(new Artifacts());
        rItems.add(new Food());
    }

    public List<Item> getItems() {
        return rItems;
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