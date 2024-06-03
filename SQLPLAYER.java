import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SQLPLAYER {
    public void Score(Hero uDraft) {
        ArrayList<Hero> aLista;
        CrudBD cBD = new CrudBD();

        aLista = cBD.buscarTodos();
        if (aLista.isEmpty()) {
            clearObject();
        } else {
            sortListByLevel(aLista);

            StringBuilder sb = new StringBuilder();
            for (Hero hero : aLista) {
                sb.append("Herói: ").append(hero.getName())
                        .append(" / Level: ").append(hero.getLevel()).append("\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private void sortListByLevel(ArrayList<Hero> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getLevel() < list.get(j + 1).getLevel()) {
                    Hero temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void clearObject() {
        JOptionPane.showMessageDialog(null, "Não há herói registrado");
    }
}
