import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StoreScreen extends JFrame implements ActionListener{
    private JLabel storeTitle;
    private JTextArea showStore;
    private JButton detailPotion,detailArtifact,detailFood,selectItems;
    Store store = new Store();
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == detailArtifact) showArtifacts();
       else if(e.getSource() == detailPotion) showPotions();
       else if(e.getSource() == detailFood) showFoods();
       else if(e.getSource() == selectItems) showItemsToBuy();
    }

    public StoreScreen(){
        super("Loja");
        store.sortSlot();
        storeTitle = new JLabel("Loja");
        storeTitle.setOpaque(true);
        storeTitle.setBackground(Color.GRAY);
        storeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        storeTitle.setFont(new Font("Algerian",Font.PLAIN,30));
        showStore = new JTextArea(store.showStore());
        showStore.setFont(new Font("Algerian", Font.PLAIN,10));
        showStore.setEditable(false);
        showStore.setLineWrap(true);
        showStore.setWrapStyleWord(true);
        detailArtifact = new JButton("Detalhes do artefato");
        detailPotion = new JButton("Detalhes da poção");
        detailFood = new JButton("Detalhe da comida");
        
        selectItems = new JButton("Selecionar");
        Dimension buttonSize = new Dimension(30,50);
        detailArtifact.setPreferredSize(buttonSize);
        detailPotion.setPreferredSize(buttonSize);
        detailFood.setPreferredSize(buttonSize);
        selectItems.setPreferredSize(buttonSize);
        Container box = getContentPane();
        box.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(showStore, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel(new GridLayout(4,1,10,10));
        box.add(storeTitle,BorderLayout.NORTH);
        box.add(centerPanel, BorderLayout.EAST);
        buttonsPanel.add(detailArtifact);
        buttonsPanel.add(detailPotion);
        buttonsPanel.add(detailFood);
        buttonsPanel.add(selectItems);
        box.add(buttonsPanel);
        detailArtifact.addActionListener(this);
        detailPotion.addActionListener(this);
        detailFood.addActionListener(this);
        selectItems.addActionListener(this);
        setSize(600,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StoreScreen());
    }

    public void showArtifacts(){
        Artifacts artifacts = new Artifacts();

        JOptionPane.showMessageDialog(null,artifacts.showStats());
    }

    public void showPotions(){
        Potions potions = new Potions();

        JOptionPane.showMessageDialog(null,potions.showPotionDetails());
    }

    public void showFoods(){
        Food food = new Food();

        JOptionPane.showMessageDialog(null,food.showFoodDetails());
    }

    public void showItemsToBuy(){
        String itemsList = store.showStore().toString();
        String [] itemsOptions = itemsList.split("\n");
        String chooseItem = (String) JOptionPane.showInputDialog(null, "Selecione 1 item para comprar: ", "Escolha" , JOptionPane.QUESTION_MESSAGE,null,itemsOptions,itemsOptions[0]);
        if(chooseItem != null) dispose();
    }
}
