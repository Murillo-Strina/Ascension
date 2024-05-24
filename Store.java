import java.util.ArrayList;
import java.util.List;

public class Store {
    private int slots;
    List<Item> rItems = new ArrayList<>();

    public Store() {
        this.slots = 3;
    }

    public void sortSlot() {
        rItems.clear();

        rItems.add(new Potions());
        rItems.add(new Artifacts());
        rItems.add(new Food());
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

    public static void main(String[] args) {
        Store store = new Store();
        store.sortSlot();
        System.out.println(store.showStore());
    }
}
