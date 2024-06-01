import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SQLPLAYER {
    public void Score(Hero uDraft) {
        ArrayList<Hero> aLista;
        CrudBD cBD = new CrudBD();

        aLista = cBD.buscarTodos();
        if (aLista.isEmpty())
            clearObject();
        else {
            StringBuilder sb = new StringBuilder();
            for (Hero hero : aLista) {
                sb.append("Herói: ").append(hero.getName())
                        .append(", Level: ").append(hero.getLevel()).append("\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        }

    }

    public static void clearObject() {
        JOptionPane.showMessageDialog(null, "Não há herói registrado");
    }
}