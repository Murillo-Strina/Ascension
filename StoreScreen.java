import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreScreen extends JFrame implements ActionListener {
    private JLabel storeTitle;
    private JTextArea showStore;
    private JButton detailPotion, detailArtifact, detailFood, selectItems, showHeroStats;
    private Store store;
    private Artifacts artifact;
    private Potions potion;
    private Food food;
    private Hero hero;

    public StoreScreen() {
        super("Loja");
        store = new Store();
        hero = new Hero("Name", "Gender");

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

        showHeroStats = new JButton("Mostrar Status do Herói");
        showHeroStats.addActionListener(this);

        showStore = new JTextArea(store.showStore());
        showStore.setFont(new Font("Algerian", Font.PLAIN, 20)); // Increase font size here
        showStore.setEditable(false);
        showStore.setLineWrap(true);
        showStore.setWrapStyleWord(true);

        detailArtifact = new JButton("Detalhes do artefato");
        detailPotion = new JButton("Detalhes da poção");
        detailFood = new JButton("Detalhe da comida");
        selectItems = new JButton("Selecionar");

        detailArtifact.addActionListener(this);
        detailPotion.addActionListener(this);
        detailFood.addActionListener(this);
        selectItems.addActionListener(this);

        Container box = getContentPane();
        box.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(storeTitle, BorderLayout.NORTH);
        northPanel.add(showHeroStats, BorderLayout.SOUTH);
        box.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        JScrollPane scrollPane = new JScrollPane(showStore);
        centerPanel.add(scrollPane);

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonsPanel.add(detailArtifact);
        buttonsPanel.add(detailPotion);
        buttonsPanel.add(detailFood);
        buttonsPanel.add(selectItems);
        centerPanel.add(buttonsPanel);

        box.add(centerPanel, BorderLayout.CENTER);

        setSize(800, 400);
        setLocationRelativeTo(null);
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
        else if (e.getSource() == showHeroStats)
            showHeroStats();
    }

    public void showArtifacts() {
        JOptionPane.showMessageDialog(this, artifact.showStats());
    }

    public void showPotions() {
        JOptionPane.showMessageDialog(this, potion.showPotionDetails());
    }

    public void showFoods() {
        JOptionPane.showMessageDialog(this, food.showFoodDetails());
    }

    public void showItemsToBuy() {
        String itemsList = store.showStore();
        String[] itemsOptions = itemsList.split("\n");
        String chooseItem = (String) JOptionPane.showInputDialog(this, "Selecione 1 item para comprar: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, itemsOptions, itemsOptions[0]);
        if (chooseItem != null) {
            applyItemEffect(chooseItem);
        }
    }

    private void applyItemEffect(String chooseItem) {
        int itemCost = 0;
        boolean purchaseSuccessful = false;

        switch (chooseItem) {
            case "Artefato":
                itemCost = artifact.getCost();
                if (hero.getCoins() >= itemCost) {
                    artifact.applyEffect(hero);
                    hero.decreaseCoins(itemCost);
                    JOptionPane.showMessageDialog(this, "Artefato Equipado!");
                    purchaseSuccessful = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Moedas insuficientes!");
                }
                break;
            case "Poção":
                itemCost = potion.getCost();
                if (hero.getCoins() >= itemCost) {
                    potion.applyEffect(hero);
                    hero.decreaseCoins(itemCost);
                    JOptionPane.showMessageDialog(this, "Efeito aplicado!");
                    purchaseSuccessful = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Moedas insuficientes!");
                }
                break;
            case "Comida":
                itemCost = food.getCost();
                if (hero.getCoins() >= itemCost) {
                    food.applyEffect(hero);
                    hero.decreaseCoins(itemCost);
                    JOptionPane.showMessageDialog(this, "Efeito aplicado!");
                    purchaseSuccessful = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Moedas insuficientes!");
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Escolha uma opção válida!");
                break;
        }
    }

    private void showHeroStats() {
        JOptionPane.showMessageDialog(this, hero.showStats());
    }
}
