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
                // case 2:
                // rItems.add(new Food());
            }
        }
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String toString() {
        return rItems.toString();
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.sortSlot();
        System.out.println(store);
    }
}