import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Artifacts extends Item {
    private int cost;
    private Random r = new Random();

    private String[] stats = { "Ataque", "Velocidade", "Vida" };
    private int[] statsValues = { 200, 100, 150 };
    private Map<String, Integer> artifactStats = new HashMap<>();

    public Artifacts() {
        super("Artefato");
        sortSlot();
        this.cost = costValue();
    }

    public void sortSlot() {
        for (String stat : stats) {
            artifactStats.put(stat, 0);
        }
        for (int i = 0; i < 3; i++) {
            int j = r.nextInt(stats.length);
            int value = getRandomValueForStat(stats[j]);
            artifactStats.put(stats[j], artifactStats.get(stats[j]) + value);
        }
    }

    private int getRandomValueForStat(String stat) {
        switch (stat) {
            case "Ataque":
                return r.nextInt(11);
            case "Velocidade":
                return r.nextInt(6);
            case "Vida":
                return r.nextInt(21);
            default:
                return 0;
        }
    }

    public void applyEffect(Hero hero) {
        for (Map.Entry<String, Integer> entry : artifactStats.entrySet()) {
            String stat = entry.getKey();
            int value = entry.getValue();
            switch (stat) {
                case "Ataque":
                    hero.increaseAttack(value);
                    break;
                case "Velocidade":
                    hero.increaseSpeed(value);
                    break;
                case "Vida":
                    hero.increaseMaximumHp(value);
                    break;
            }
        }
    }

    public int costValue() {
        int totalCost = 0;
        for (Map.Entry<String, Integer> entry : artifactStats.entrySet()) {
            String stat = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < stats.length; i++) {
                if (stat.equals(stats[i])) {
                    totalCost += value * statsValues[i];
                    break;
                }
            }
        }
        return totalCost;
    }

    public String showStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalhes do artefato:\n");
        sb.append("----------------\n");
        for (Map.Entry<String, Integer> entry : artifactStats.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("Custo do artefato: ").append(cost).append("\n");
        sb.append("----------------");
        return sb.toString();
    }
}