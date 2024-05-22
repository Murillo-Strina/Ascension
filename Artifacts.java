import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Artifacts extends Item {
    private int cost;
    private Random r = new Random();

    private String[] stats = { "Taxa Crítica", "Ataque", "Velocidade", "Vida" };
    private int[] statsValues = { 200, 100, 100, 150 };
    private List<String> artifact = new ArrayList<>();

    public Artifacts() {
        super("Artefato");
        sortSlot();
        this.cost = costValue();
    }

    public void sortSlot() {
        for (int i = 0; i < 4; i++) {
            int j = r.nextInt(stats.length);
            artifact.add(stats[j]);
        }
    }

    public int costValue() {
        int totalCost = 0;
        for (String stat : artifact) {
            for (int i = 0; i < stats.length; i++) {
                if (stat.equals(stats[i])) {
                    totalCost += statsValues[i];
                    break;
                }
            }
        }
        return totalCost;
    }

    public String showStats() {
        return "Detalhes do artefato:\n" + "----------------\n" + "Atributos do artefato: \n" + artifact + "\n"
                + "Custo do artefato: " + cost + "\n----------------";
    }

    public static void main(String[] args) {
        Artifacts artifacts = new Artifacts();
        System.out.println(artifacts.showStats());
    }
}
