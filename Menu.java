import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private JLabel gameTitle;
    private JButton newGame, generalScore, exit;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }

    public void startGame() {
        String inputName = JOptionPane.showInputDialog(null, "Nome do(a) aventureiro(a): ");
        String inputGender = JOptionPane.showInputDialog(null, "Gênero: ");
        JOptionPane.showMessageDialog(null, "Aventureiro(a) criado!");
        String[] elementsList = { "Pyro", "Hydro", "Electro", "Dendro", "Cryo", "Geo" };
        String chooseElement = (String) JOptionPane.showInputDialog(null,
                "Escolha o tipo do elemento que " + inputName + " irá pertencer: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, elementsList, elementsList[0]);

        element(chooseElement);
        String[] weaponsList = { "Claymore", "Bow", "Catalysts", "Polearm", "Sword" };
        String chooseWeapon = (String) JOptionPane.showInputDialog(null,
                "Escolha a arma que " + inputName + " irá usar", "Escolha", JOptionPane.QUESTION_MESSAGE, null,
                weaponsList, weaponsList[0]);
        weapon(chooseWeapon);
    }

    public void viewScore() {

    }

    private void element(String chooseElement) {
        switch (chooseElement) {
            case "Pyro":
                break;
            case "Hydro":
                break;
            case "Electro":
                break;
            case "Dendro":
                break;
            case "Cryo":
                break;
            case "Geo":
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
        }
    }

    private void weapon(String chooseWeapon) {
        switch (chooseWeapon) {
            case "Claymore":
                break;
            case "Bow":
                break;
            case "Catalysts":
                break;
            case "Polearm":
                break;
            case "Sword":
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
        }
    }

}
