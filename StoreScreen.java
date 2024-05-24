import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class StoreScreen extends JFrame implements ActionListener {
    private JLabel storeTitle;
    private JTextArea showStore;
    private JButton detailPotion, detailArtifact, detailFood, selectItems;
    private Store store;

    public StoreScreen() {
        super("Loja");
        store = new Store();
        storeTitle = new JLabel("Loja");
        storeTitle.setOpaque(true);
        storeTitle.setBackground(Color.GRAY);
        storeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        storeTitle.setFont(new Font("Algerian", Font.PLAIN, 30));
        showStore = new JTextArea(store.showStore());
        showStore.setFont(new Font("Algerian", Font.PLAIN, 10));
        showStore.setEditable(false);
        showStore.setLineWrap(true);
        showStore.setWrapStyleWord(true);
        detailArtifact = new JButton("Detalhes do artefato");
        detailPotion = new JButton("Detalhes da poção");
        detailFood = new JButton("Detalhe da comida");
        selectItems = new JButton("Selecionar");
        Dimension buttonSize = new Dimension(30, 50);
        detailArtifact.setPreferredSize(buttonSize);
        detailPotion.setPreferredSize(buttonSize);
        detailFood.setPreferredSize(buttonSize);
        selectItems.setPreferredSize(buttonSize);
        Container box = getContentPane();
        box.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(showStore, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        box.add(storeTitle, BorderLayout.NORTH);
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
        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StoreScreen());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == detailArtifact)
            showArtifacts();
        else if (e.getSource() == detailPotion)
            showPotions();
        else if (e.getSource() == detailFood)
            showFoods();
        else if (e.getSource() == selectItems)
            showItemsToBuy();
    }

    public void showArtifacts() {
        List<Item> items = store.getItems();
        for (Item item : items) {
            if (item instanceof Artifacts) {
                JOptionPane.showMessageDialog(null, ((Artifacts) item).showStats());
                break;
            }
        }
    }

    public void showPotions() {
        List<Item> items = store.getItems();
        for (Item item : items) {
            if (item instanceof Potions) {
                JOptionPane.showMessageDialog(null, ((Potions) item).showPotionDetails());
                break;
            }
        }
    }

    public void showFoods() {
        List<Item> items = store.getItems();
        for (Item item : items) {
            if (item instanceof Food) {
                JOptionPane.showMessageDialog(null, ((Food) item).showFoodDetails());
                break;
            }
        }
    }

    public void showItemsToBuy() {
        String itemsList = store.showStore();
        String[] itemsOptions = itemsList.split("\n");
        String chooseItem = (String) JOptionPane.showInputDialog(null, "Selecione 1 item para comprar: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, itemsOptions, itemsOptions[0]);
        if (chooseItem != null)
            dispose();
    }
}