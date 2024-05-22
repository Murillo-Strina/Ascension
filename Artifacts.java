import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Artifacts extends Item {
    private int cost;
    private Random r = new Random();
    private int sorter;

    private String[] stats = { "Taxa Crítica", "Ataque", "Velocidade", "Vida" };
    List<String> artifact = new ArrayList<>();

    public Artifacts() {
        super("Artefato");
        this.sorter = r.nextInt(4);
        this.cost = costValue();
    }

    public void sortSlot() {
        for (int i = 0; i <= 4; i++) {
            int j = r.nextInt(stats.length);
            artifact.add(stats[j]);
        }
    }

    public int costValue() {
        return 1;
    }

    public static void main(String[] args) {
        Artifacts artifacts = new Artifacts();
        artifacts.sortSlot();
        System.out.println(artifacts.artifact);
    }

}
