import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleSystemGUI extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel heroHPLabel;
    private JLabel enemyHPLabel;
    private JButton skill1Button;
    private JButton skill2Button;
    private JButton skill3Button;
    private JButton skill4Button;
    private JLabel messageLabel;

    private BattleSystem battleSystem;

    public BattleSystemGUI(BattleSystem battleSystem) {
        super("Batalha");
        this.battleSystem = battleSystem;
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create hero HP label
        heroHPLabel = new JLabel("Hero HP: " + battleSystem.getHero().getHp() + "/" + battleSystem.getHero().getMaximumHP());
        panel.add(heroHPLabel, BorderLayout.NORTH);

        // Create enemy HP label
        enemyHPLabel = new JLabel("Enemy HP: " + battleSystem.getEnemy().getHealth() + "/" + battleSystem.getEnemy().getMaximumHP());
        panel.add(enemyHPLabel, BorderLayout.SOUTH);

        // Create skill buttons
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
        panel.add(skillPanel, BorderLayout.CENTER);

        // Create message label
        messageLabel = new JLabel("");
        panel.add(messageLabel, BorderLayout.EAST);

        getContentPane().add(panel);
        pack();
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
    }

    public void updateGUI() {
        heroHPLabel.setText("Hero HP: " + battleSystem.getHero().getHp() + "/" + battleSystem.getHero().getMaximumHP());
        enemyHPLabel.setText("Enemy HP: " + battleSystem.getEnemy().getHealth() + "/" + battleSystem.getEnemy().getMaximumHP());
        messageLabel.setText(battleSystem.getMessage());
    }
}
