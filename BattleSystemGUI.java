import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BattleSystemGUI extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel heroHPLabel;
    private JLabel enemyHPLabel;
    private JLabel floorLabel;
    private JButton skill1Button;
    private JButton skill2Button;
    private JButton skill3Button;
    private JButton skill4Button;
    private JTextArea messageArea;

    private BattleSystem battleSystem;
    private int floor;

    public BattleSystemGUI(BattleSystem battleSystem, int floor) {
        super("Batalha");
        this.battleSystem = battleSystem;
        this.floor = floor;
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        messageArea = new JTextArea(30, 40);
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(1, 3));
        heroHPLabel = new JLabel(
                "Hero HP: " + battleSystem.getHero().getHp() + "/" + battleSystem.getHero().getMaximumHP());
        enemyHPLabel = new JLabel(
                "Enemy HP: " + battleSystem.getEnemy().getHealth() + "/" + battleSystem.getEnemy().getMaximumHP());
        floorLabel = new JLabel("Floor: " + floor);
        statusPanel.add(heroHPLabel);
        statusPanel.add(floorLabel);
        statusPanel.add(enemyHPLabel);
        panel.add(statusPanel, BorderLayout.NORTH);

        JPanel skillPanel = new JPanel();
        skillPanel.setLayout(new GridLayout(1, 4));
        skill1Button = new JButton("Elemental 1");
        skill1Button.addActionListener(this);
        skillPanel.add(skill1Button);
        skill2Button = new JButton("Elemental 2");
        skill2Button.addActionListener(this);
        skillPanel.add(skill2Button);
        skill3Button = new JButton("Arma 1");
        skill3Button.addActionListener(this);
        skillPanel.add(skill3Button);
        skill4Button = new JButton("Arma 2");
        skill4Button.addActionListener(this);
        skillPanel.add(skill4Button);
        panel.add(skillPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        System.out.println("GUI criada com sucesso!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == skill1Button) {
            battleSystem.setHeroSkill(1);
        } else if (e.getSource() == skill2Button) {
            battleSystem.setHeroSkill(2);
        } else if (e.getSource() == skill3Button) {
            battleSystem.setHeroSkill(3);
        } else if (e.getSource() == skill4Button) {
            battleSystem.setHeroSkill(4);
        }
        new Thread(() -> {
            battleSystem.startBattle();
            SwingUtilities.invokeLater(() -> {
                updateGUI();
                reenableButtons();

                if (battleSystem.getHero().getHp() <= 0 || battleSystem.getEnemy().getHealth() <= 0) {
                    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            });
        }).start();
    }

    public void updateGUI() {
        heroHPLabel.setText("Hero HP: " + battleSystem.getHero().getHp() + "/" + battleSystem.getHero().getMaximumHP());
        enemyHPLabel.setText(
                "Enemy HP: " + battleSystem.getEnemy().getHealth() + "/" + battleSystem.getEnemy().getMaximumHP());
        messageArea.setText(battleSystem.getMessage());
        floorLabel.setText("Floor: " + floor);
    }

    private void reenableButtons() {
        skill1Button.setEnabled(true);
        skill2Button.setEnabled(true);
        skill3Button.setEnabled(true);
        skill4Button.setEnabled(true);
    }
}
