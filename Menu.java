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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }

    public void startGame() {
        String inputName = JOptionPane.showInputDialog(null, "Nome do(a) aventureiro(a): ");
        String inputGender = JOptionPane.showInputDialog(null, "Gênero: ");
        if (inputName != null && inputGender != null)
            JOptionPane.showMessageDialog(null, "Aventureiro(a) criado!");
        String[] elementsList = { "Pyro", "Hydro", "Electro", "Dendro", "Cryo", "Geo" };
        String chooseElement = (String) JOptionPane.showInputDialog(null,
                "Escolha o tipo do elemento que " + inputName + " irá possuir: ", "Escolha",
                JOptionPane.QUESTION_MESSAGE, null, elementsList, elementsList[0]);

        element(chooseElement);
        selectWeapon(inputName);
       
    }

    public void selectWeapon(String adventureName){
        String[] weaponsList = { "Claymore", "Bow", "Catalysts", "Polearm", "Sword" };
        String chooseWeapon = (String) JOptionPane.showInputDialog(null, "Escolha a arma que " + adventureName + " irá usar", "Escolha", JOptionPane.QUESTION_MESSAGE, null, weaponsList, weaponsList[0]);
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
        int choice;
        switch (chooseWeapon) {
            case "Claymore":
                Claymore claymore = new Claymore();
                JOptionPane.showMessageDialog(null, claymore.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher Claymore?");
                if (choice == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                }
                else if (choice == JOptionPane.NO_OPTION){
                    selectWeapon("");
                }
                else break;
                break;
            case "Bow":
                Bow bow = new Bow();
                JOptionPane.showMessageDialog(null, bow.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher Bow?");
                if (choice == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                }
                else if (choice == JOptionPane.NO_OPTION){
                    selectWeapon("");
                }
                else break;
                break;
            case "Catalysts":
                Catalysts catalysts = new Catalysts();
                JOptionPane.showMessageDialog(null, catalysts.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher Catalysts?");
                if (choice == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                }
                else if (choice == JOptionPane.NO_OPTION){
                    selectWeapon("");
                }
                else break;
                break;
            case "Polearm":
                Polearm polearm = new Polearm();
                JOptionPane.showMessageDialog(null, polearm.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher Polearm?");
                if (choice == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                }
                else if (choice == JOptionPane.NO_OPTION){
                    selectWeapon("");
                }
                else break;
                break;
            case "Sword":
                Sword sword = new Sword();
                JOptionPane.showMessageDialog(null, sword.StatusWeapon());
                choice = JOptionPane.showConfirmDialog(null, "Deseja escolher Sword?");
                if (choice == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Arma escolhida!");
                }
                else if (choice == JOptionPane.NO_OPTION){
                    selectWeapon("");
                }
                else break;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                selectWeapon("");
        }
    }

}
