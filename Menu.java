import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private JLabel gameTitle;
    private JButton newGame, generalScore, exit;
    Hero hero = new Hero("", "");

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame)
            startGame();
        else if (e.getSource() == generalScore)
            viewScore();
        else if (e.getSource() == exit)
            System.exit(0);
    }

    public Menu() {
        super("Ascension");
        gameTitle = new JLabel("Ascension");
        gameTitle.setOpaque(true);
        gameTitle.setBackground(Color.GRAY);
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        gameTitle.setFont(new Font("Algerian", Font.PLAIN, 30));
        newGame = new JButton("Iniciar Aventura");
        generalScore = new JButton("Pontuação");
        exit = new JButton("Sair");
        Dimension buttonSize = new Dimension(30, 40);
        newGame.setPreferredSize(buttonSize);
        generalScore.setPreferredSize(buttonSize);
        exit.setPreferredSize(buttonSize);
        Container box = getContentPane();
        box.setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        box.add(gameTitle, BorderLayout.NORTH);

        buttonsPanel.add(newGame);
        buttonsPanel.add(generalScore);
        buttonsPanel.add(exit);
        box.add(buttonsPanel);
        newGame.addActionListener(this);
        generalScore.addActionListener(this);
        exit.addActionListener(this);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startGame() {
        String inputName = JOptionPane.showInputDialog(null, "Nome do(a) aventureiro(a): ");
        String inputGender = JOptionPane.showInputDialog(null, "Gênero: ");
        if (inputName != null && !inputName.isEmpty() && inputGender != null && !inputGender.isEmpty()) {
            hero.setName(inputName);
            hero.setGender(inputGender);
            hero.setLevel(hero.getLevel());
            JOptionPane.showMessageDialog(null, "Aventureiro(a) criado!");
        } else {
            JOptionPane.showMessageDialog(null, "É necessário criar um nome válido!");
            startGame();
            return;
        }
        String[] elementsList = { "Pyro", "Hydro", "Electro", "Dendro", "Cryo", "Geo" };
        String chooseElement = (String) JOptionPane.showInputDialog(null,
                "Escolha o tipo do elemento que " + inputName + " irá possuir: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, elementsList, elementsList[0]);
        element(chooseElement);
        selectWeapon(inputName);
    }

    public void selectWeapon(String adventureName) {
        String[] weaponsList = { "Espadão", "Arco", "Catalisador", "Lança", "Espada" };
        String chooseWeapon = (String) JOptionPane.showInputDialog(null,
                "Escolha a arma que " + adventureName + " irá usar", "Escolha", JOptionPane.QUESTION_MESSAGE, null,
                weaponsList, weaponsList[0]);
        weapon(chooseWeapon);
    }

    public void viewScore() {
        SQLPLAYER sql = new SQLPLAYER();
        sql.Score(hero);
    }

    private void element(String chooseElement) {
        switch (chooseElement) {
            case "Pyro":
                hero.setElementInt(2);
                break;
            case "Hydro":
                hero.setElementInt(5);
                break;
            case "Electro":
                hero.setElementInt(6);
                break;
            case "Dendro":
                hero.setElementInt(1);
                break;
            case "Cryo":
                hero.setElementInt(3);
                break;
            case "Geo":
                hero.setElementInt(4);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                return;
        }
    }

    private void weapon(String chooseWeapon) {
        int choice;
        switch (chooseWeapon) {
            case "Espadão":
                Claymore claymore = new Claymore();
                JOptionPane.showMessageDialog(null, claymore.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher o espadão?");
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(claymore);
                    hero.setWeaponInt(2);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    new Floors(hero);
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon("");
                }
                break;
            case "Arco":
                Bow bow = new Bow();
                JOptionPane.showMessageDialog(null, bow.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher o arco?");
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(bow);
                    hero.setWeaponInt(4);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    new Floors(hero);
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon("");
                }
                break;
            case "Catalisador":
                Catalysts catalysts = new Catalysts();
                JOptionPane.showMessageDialog(null, catalysts.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher o catalisador?");
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(catalysts);
                    hero.setWeaponInt(3);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    new Floors(hero);
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon("");
                }
                break;
            case "Lança":
                Polearm polearm = new Polearm();
                JOptionPane.showMessageDialog(null, polearm.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher a lança?");
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(polearm);
                    hero.setWeaponInt(5);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    new Floors(hero);
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon("");
                }
                break;
            case "Espada":
                Sword sword = new Sword();
                JOptionPane.showMessageDialog(null, sword.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher a Espada?");
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(sword);
                    hero.setWeaponInt(1);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    new Floors(hero);
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon("");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                selectWeapon("");
        }
    }
}
