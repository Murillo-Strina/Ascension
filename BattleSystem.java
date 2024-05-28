import java.util.Random;
import java.util.Scanner;

public class BattleSystem {
    private Scanner scanner;
    private Random random;
    private Hero hero;
    private Enemy enemy;
    private StatusChecker statusChecker;
    private int heroBattleSpeed;
    private int enemyBattleSpeed;
    private int enemySkillChosen;
    private int heroSkillChosen;
    private int heroAction;
    private int enemyAction;

    public BattleSystem(Hero hero, Enemy enemy, StatusChecker statusChecker)
    {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.hero = hero;
        this.enemy = enemy;
        this.statusChecker = statusChecker;
        this.heroBattleSpeed = 0;
        this.enemyBattleSpeed = 0;
        this.enemySkillChosen = 0;
        this.heroSkillChosen = 0;
        this.heroAction = 0;
        this.enemyAction = 0;
    }

    public void Battle(Hero hero, Enemy enemy)
    {
        this.heroBattleSpeed = this.random.nextInt(21) + this.hero.getSpd();
        this.enemyBattleSpeed = this.random.nextInt(21) + this.enemy.getSpd();
        while(this.hero.getHp() > 0 && this.enemy.getHealth() > 0)
        {
            if(this.heroBattleSpeed >= this.enemyBattleSpeed)
            {
                statusChecker.normalizeStatus();
                System.out.print("\nEscolha uma skill: ");
                this.heroSkillChosen = this.scanner.nextInt();
                switch(this.heroSkillChosen)
                {
                    case 1:
                        this.heroAction = this.hero.ElementSkillA();
                        this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                        ShowEnemyHP();
                        break;
                    case 2:
                        this.heroAction = this.hero.ElementSkillB();
                        if(this.hero.getElementInt() == 4)
                        {
                            this.hero.setHp(this.hero.getHp() + this.heroAction);
                            System.out.println(this.hero.getName() + " ganhou " + this.heroAction + " de escudo");
                        }

                        else if(this.hero.getElementInt() == 5)
                        {
                            this.hero.increaseHp(this.heroAction);
                            System.out.println(this.hero.getName() + " se curou em " + this.heroAction + " de vida");
                        }

                        else
                        {
                            switch(this.hero.getElementInt())
                            {
                                case 1:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setSeeded(true);
                                    ShowEnemyHP();
                                    break;
                                case 2:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setBurning(true);
                                    ShowEnemyHP();
                                    break;
                                case 3:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setFrozen(true);
                                    ShowEnemyHP();
                                    break;
                                case 6:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setStunned(true);
                                    ShowEnemyHP();
                                    break;
                            }
                        }
                        break;
                }
                this.statusChecker.checkStatusConditions();
                if(this.enemy.getHealth() <= 0)
                {
                    break;
                }
                if(this.enemy.isStunned() == false)
                {
                    this.enemySkillChosen = this.random.nextInt(2)+1;
                    System.out.println("\n" + this.enemy.getName() + " usou a ação " + this.enemySkillChosen);
                    if(this.enemySkillChosen == 1)
                    {
                        this.enemyAction = this.enemy.basicAttack();
                        this.hero.setHp(this.hero.getHp() - this.enemyAction);
                        ShowHeroHP();
                    }
                    else
                    {
                        this.enemyAction = this.enemy.elementalSkill();
                        this.hero.setHp(this.hero.getHp() - this.enemyAction);
                        ShowHeroHP();
                    }
                }
                if(this.hero.getHp() <= 0)
                {
                    break;
                }
            }

            else
            {
                this.statusChecker.checkStatusConditions();
                if(this.enemy.getHealth() <= 0)
                {
                    break;
                }
                if(this.enemy.isStunned() == false)
                {
                    this.enemySkillChosen = this.random.nextInt(2)+1;
                    System.out.println("\n" + this.enemy.getName() + " usou a ação " + this.enemySkillChosen);
                    if(this.enemySkillChosen == 1)
                    {
                        this.enemyAction = this.enemy.basicAttack();
                        this.hero.setHp(this.hero.getHp() - this.enemyAction);
                        ShowHeroHP();
                    }
                    else
                    {
                        this.enemyAction = this.enemy.elementalSkill();
                        this.hero.setHp(this.hero.getHp() - this.enemyAction);
                        ShowHeroHP();
                    }
                }
                if(this.hero.getHp() <= 0)
                {
                    break;
                }
                statusChecker.normalizeStatus();
                System.out.print("\nEscolha uma skill: ");
                this.heroSkillChosen = this.scanner.nextInt();
                switch(this.heroSkillChosen)
                {
                    case 1:
                        this.heroAction = this.hero.ElementSkillA();
                        this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                        ShowEnemyHP();
                        break;
                    case 2:
                        this.heroAction = this.hero.ElementSkillB();
                        if(this.hero.getElementInt() == 4)
                        {
                            this.hero.setHp(this.hero.getHp() + this.heroAction);
                        }

                        else if(this.hero.getElementInt() == 5)
                        {
                            this.hero.increaseHp(this.heroAction);
                        }

                        else
                        {
                            switch(this.hero.getElementInt())
                            {
                                case 1:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setSeeded(true);
                                    ShowEnemyHP();
                                    break;
                                case 2:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setBurning(true);
                                    ShowEnemyHP();
                                    break;
                                case 3:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setFrozen(true);
                                    ShowEnemyHP();
                                    break;
                                case 6:
                                    this.enemy.setHealth(this.enemy.getHealth() - this.heroAction);
                                    this.enemy.setFrozen(true);
                                    ShowEnemyHP();
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }

    private void ShowEnemyHP()
    {
        if(this.enemy.getHealth() <= 0)
        {
            System.out.println(this.enemy.getName() + " tomou " + this.heroAction + " de dano! Vida atual: 0/" + this.enemy.getMaximumHP());
        }

        else
        {
            System.out.println(this.enemy.getName() + " tomou " + this.heroAction + " de dano! Vida atual: " + this.enemy.getHealth() + "/" + this.enemy.getMaximumHP());
        }
    }

    private void ShowHeroHP()
    {
        if(this.hero.getHp() <= 0)
        {
            System.out.println(this.hero.getName() + " tomou " + this.enemyAction + " de dano! Vida atual: 0/" + this.hero.getMaximumHP());
        }

        else
        {
            System.out.println(this.hero.getName() + " tomou " + this.enemyAction + " de dano! Vida atual: " + this.hero.getHp() + "/" + this.hero.getMaximumHP());
        }
    }
}
