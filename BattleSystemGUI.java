import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleSystemGUI extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel heroHPLabel;
    private JLabel enemyHPLabel;
    private JLabel floorLabel; // Novo rótulo para mostrar o andar
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
        panel.add(scrollPane, BorderLayout.NORTH);

        heroHPLabel = new JLabel(
                "Hero HP: " + battleSystem.getHero().getHp() + "/" + battleSystem.getHero().getMaximumHP());
        panel.add(heroHPLabel, BorderLayout.WEST);

        enemyHPLabel = new JLabel(
                "Enemy HP: " + battleSystem.getEnemy().getHealth() + "/" + battleSystem.getEnemy().getMaximumHP());
        panel.add(enemyHPLabel, BorderLayout.EAST);

        floorLabel = new JLabel("Floor: " + floor); // Configurando o rótulo do andar
        panel.add(floorLabel, BorderLayout.CENTER); // Adicionando o rótulo ao painel

        JPanel skillPanel = new JPanel();
        skillPanel.setLayout(new GridLayout(1, 4));
        skill1Button = new JButton("Skill 1");
        skill1Button.addActionListener(this);
        skillPanel.add(skill1Button);
        skill2Button = new JButton("Skill 2");
        skill2Button.addActionListener(this);
        skillPanel.add(skill2Button);
        skill3Button = new JButton("Skill 3");
        skill3Button.addActionListener(this);
        skillPanel.add(skill3Button);
        skill4Button = new JButton("Skill 4");
        skill4Button.addActionListener(this);
        skillPanel.add(skill4Button);
        panel.add(skillPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
        battleSystem.startBattle();
        updateGUI();
        reenableButtons();

        if (battleSystem.getHero().getHp() <= 0 || battleSystem.getEnemy().getHealth() <= 0) {
            synchronized (this) {
                this.setVisible(false);
                this.notify();
            }
        }
    }

    public void updateGUI() {
        heroHPLabel.setText("Hero HP: " + battleSystem.getHero().getHp() + "/" + battleSystem.getHero().getMaximumHP());
        enemyHPLabel.setText(
                "Enemy HP: " + battleSystem.getEnemy().getHealth() + "/" + battleSystem.getEnemy().getMaximumHP());
        messageArea.setText(battleSystem.getMessage());
        floorLabel.setText("Floor: " + floor); // Atualizando o rótulo do andar
    }

    private void reenableButtons() {
        skill1Button.setEnabled(true);
        skill2Button.setEnabled(true);
        skill3Button.setEnabled(true);
        skill4Button.setEnabled(true);
    }
}
