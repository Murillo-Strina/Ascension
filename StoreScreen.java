import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class StoreScreen extends JFrame implements ActionListener {
    private JLabel storeTitle;
    private JTextArea showStore;
    private JButton detailPotion, detailArtifact, detailFood, selectItems;
    private Store store;
    private Artifacts artifact;
    private Potions potion;
    private Food food;
    private Hero hero;

    public StoreScreen() {
        super("Loja");
        store = new Store();
        hero = new Hero(null, null);

        for (Item item : store.getItems()) {
            if (item instanceof Artifacts) {
                artifact = (Artifacts) item;
            } else if (item instanceof Potions) {
                potion = (Potions) item;
            } else if (item instanceof Food) {
                food = (Food) item;
            }
        }

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
        JOptionPane.showMessageDialog(null, artifact.showStats());
    }

    public void showPotions() {
        JOptionPane.showMessageDialog(null, potion.showPotionDetails());
    }

    public void showFoods() {
        JOptionPane.showMessageDialog(null, food.showFoodDetails());
    }

    public void showItemsToBuy() {
        String itemsList = store.showStore();
        String[] itemsOptions = itemsList.split("\n");
        String chooseItem = (String) JOptionPane.showInputDialog(null, "Selecione 1 item para comprar: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, itemsOptions, itemsOptions[0]);
        if (chooseItem != null) {
            applyItemEffect(chooseItem);
            dispose();
        }
    }

    private void applyItemEffect(String chooseItem) {
        switch (chooseItem) {
            case "Artefato":
                artifact.applyEffect(hero);
                JOptionPane.showMessageDialog(null, "Artefato Equipado!");
                break;
            case "Poção":
                potion.applyEffect(hero);
                JOptionPane.showMessageDialog(null, "Efeito aplicado!");
                break;
            case "Comida":
                food.applyEffect(hero);
                JOptionPane.showMessageDialog(null, "Efeito aplicado!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                break;
        }
    }
}
