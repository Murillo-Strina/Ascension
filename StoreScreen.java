import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreScreen extends JFrame implements ActionListener {
    private JLabel storeTitle;
    private JTextArea showStore;
    private JButton detailPotion, detailArtifact, detailFood, selectItems, showHeroStats;
    private Store store;
    private Hero hero;

    public StoreScreen(Hero hero) {
        super("Loja");
        this.hero = hero;
        this.store = new Store(hero);
        createGUI();
    }

    private void createGUI() {
        storeTitle = new JLabel("Loja");
        storeTitle.setOpaque(true);
        storeTitle.setBackground(Color.GRAY);
        storeTitle.setHorizontalAlignment(SwingConstants.CENTER);
        storeTitle.setFont(new Font("Algerian", Font.PLAIN, 30));

        showStore = new JTextArea(store.showStore());
        showStore.setFont(new Font("Algerian", Font.PLAIN, 20));
        showStore.setEditable(false);
        showStore.setLineWrap(true);
        showStore.setWrapStyleWord(true);

        showHeroStats = new JButton("Mostrar Status do Herói");
        detailArtifact = new JButton("Detalhes do artefato");
        detailPotion = new JButton("Detalhes da poção");
        detailFood = new JButton("Detalhe da comida");
        selectItems = new JButton("Selecionar");

        showHeroStats.addActionListener(this);
        detailArtifact.addActionListener(this);
        detailPotion.addActionListener(this);
        detailFood.addActionListener(this);
        selectItems.addActionListener(this);

        Container box = getContentPane();
        box.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(storeTitle, BorderLayout.NORTH);
        box.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        JScrollPane scrollPane = new JScrollPane(showStore);
        centerPanel.add(scrollPane);

        JPanel buttonsPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonsPanel.add(showHeroStats);
        buttonsPanel.add(detailArtifact);
        buttonsPanel.add(detailPotion);
        buttonsPanel.add(detailFood);
        buttonsPanel.add(selectItems);
        centerPanel.add(buttonsPanel);

        box.add(centerPanel, BorderLayout.CENTER);

        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        for (Item item : store.getItems()) {
            if (item instanceof Artifacts) {
                JOptionPane.showMessageDialog(this, ((Artifacts) item).showArtifactDetails());
                break;
            }
        }
    }

    public void showPotions() {
        for (Item item : store.getItems()) {
            if (item instanceof Potions) {
                JOptionPane.showMessageDialog(this, ((Potions) item).showPotionDetails());
                break;
            }
        }
    }

    public void showFoods() {
        for (Item item : store.getItems()) {
            if (item instanceof Food) {
                JOptionPane.showMessageDialog(this, ((Food) item).showFoodDetails());
                break;
            }
        }
    }

    public void showItemsToBuy() {
        String itemsList = store.showStore();
        String[] itemsOptions = itemsList.split("\n");
        String chooseItem = (String) JOptionPane.showInputDialog(this, "Selecione 1 item para comprar: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, itemsOptions, itemsOptions[0]);
        if (chooseItem != null) {
            String itemName = chooseItem.split(" ")[0];
            applyItemEffect(itemName);
        }
    }

    private void applyItemEffect(String chooseItem) {
        boolean purchaseSuccessful = store.buyItem(chooseItem);
        if (purchaseSuccessful) {
            JOptionPane.showMessageDialog(this, "Item comprado!");
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } else {
            JOptionPane.showMessageDialog(this, "Moedas insuficientes ou item inválido.");
        }
    }

    private void showHeroStats() {
        JOptionPane.showMessageDialog(this, hero.showStats());
    }
}