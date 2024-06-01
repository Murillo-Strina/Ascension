import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private JLabel gameTitle;
    private JButton newGame, generalScore, exit;
    private Hero hero;

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
        hero = new Hero("", "");

        gameTitle = new JLabel("Ascension");
        gameTitle.setOpaque(true);
        gameTitle.setBackground(Color.GRAY);
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        gameTitle.setFont(new Font("Algerian", Font.PLAIN, 30));

        newGame = new JButton("Iniciar Aventura");
        generalScore = new JButton("Pontuação");
        exit = new JButton("Sair");

        newGame.addActionListener(this);
        generalScore.addActionListener(this);
        exit.addActionListener(this);

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonsPanel.add(newGame);
        buttonsPanel.add(generalScore);
        buttonsPanel.add(exit);

        Container box = getContentPane();
        box.setLayout(new BorderLayout());
        box.add(gameTitle, BorderLayout.NORTH);
        box.add(buttonsPanel, BorderLayout.CENTER);

        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void startGame() {
        String inputName = JOptionPane.showInputDialog(null, "Nome do(a) aventureiro(a): ");
        String inputGender = JOptionPane.showInputDialog(null, "Gênero: ");
        if (inputName != null && !inputName.isEmpty() && inputGender != null && !inputGender.isEmpty()) {
            hero.setName(inputName);
            hero.setGender(inputGender);
            hero.setLevel(hero.getLevel());
            JOptionPane.showMessageDialog(null, "Aventureiro(a) criado!");

            String[] elementsList = { "Pyro", "Hydro", "Electro", "Dendro", "Cryo", "Geo" };
            String chooseElement = (String) JOptionPane.showInputDialog(null,
                    "Escolha o tipo do elemento que " + inputName + " irá possuir: ", "Escolha",
                    JOptionPane.QUESTION_MESSAGE, null, elementsList, elementsList[0]);
            element(chooseElement);
            selectWeapon(inputName);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário criar um nome válido!");
            startGame();
        }
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
        String [] options = {"Sim", "Não"};
        switch (chooseWeapon) {
            case "Espadão":
                Claymore claymore = new Claymore();
                JOptionPane.showMessageDialog(null, claymore.StatusWeapon());
                choice = JOptionPane.showOptionDialog(null, "Deseja escolher o arco?", "Escolha Arma",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(claymore);
                    hero.setWeaponInt(2);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon(hero.getName());
                }
                break;
            case "Arco":
                Bow bow = new Bow();
                JOptionPane.showMessageDialog(null, bow.StatusWeapon());
                choice = JOptionPane.showOptionDialog(null, "Deseja escolher o arco?", "Escolha Arma",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(bow);
                    hero.setWeaponInt(4);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon(hero.getName());
                }
                else if (choice == JOptionPane.CANCEL_OPTION){
                    
                }
                break;
            case "Catalisador":
                Catalysts catalysts = new Catalysts();
                JOptionPane.showMessageDialog(null, catalysts.StatusWeapon());
                choice = JOptionPane.showOptionDialog(null, "Deseja escolher o catalisador?", "Escolha Arma",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(catalysts);
                    hero.setWeaponInt(3);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon(hero.getName());
                }
                break;
            case "Lança":
                Polearm polearm = new Polearm();
                JOptionPane.showMessageDialog(null, polearm.StatusWeapon());
                choice = JOptionPane.showOptionDialog(null, "Deseja escolher a lança?", "Escolha Arma",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(polearm);
                    hero.setWeaponInt(5);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon(hero.getName());
                }
                break;
            case "Espada":
                Sword sword = new Sword();
                JOptionPane.showMessageDialog(null, sword.StatusWeapon());
                choice = JOptionPane.showOptionDialog(null, "Deseja escolher a espada?", "Escolha Arma",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == JOptionPane.YES_OPTION) {
                    hero.setWeapon(sword);
                    hero.setWeaponInt(1);
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                    this.dispose();
                } else if (choice == JOptionPane.NO_OPTION) {
                    selectWeapon(hero.getName());
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                selectWeapon(hero.getName());
        }
    }

    public Hero getHero() {
        return hero;
    }
}
