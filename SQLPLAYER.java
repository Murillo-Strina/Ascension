import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SQLPLAYER {

    public static void Score(Hero uDraft)
    {  
        ArrayList<Hero> aLista;
        CrudBD  cBD     = new CrudBD();
        
        clearObject();
       
            cBD.incluirReg(uDraft);    
            aLista = cBD.buscarTodos();
            for (int i = 0; i < aLista.size(); i++)
            {   uDraft = aLista.get(i);
                System.out.println(uDraft.getName() + "-" + uDraft.getLevel());
            }
            System.out.println("------------------------------");
            System.exit(0);
                    

            JOptionPane.showMessageDialog(null, "Herói: " +uDraft.getName()+ "Level: " +  uDraft.getLevel() + "\n");
           
        }

    public static  void  clearObject()
    {   
        JOptionPane.showMessageDialog(null, "Não há herói registrado");
    }
}