import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelUpView {

    private JFrame mainFrame;
    private JPanel statsPanel;
    private JPanel optionsPanel;
    private JPanel mainPanel;

    private JLabel headerLabel;

    //Labels
    private JLabel runeUpCost;
    private JLabel runesAmount;

    //stats of the player
    private JLabel HP;
    private JLabel END;
    private JLabel DEX;
    private JLabel STR;
    private JLabel INT;
    private JLabel FTH;

    //Buttons
    private JButton LevHP;
    private JButton LevEND;
    private JButton LevDEX;
    private JButton LevSTR;
    private JButton LevINT;
    private JButton LevFTH;
    private JButton Back;

    private GameLobbyModel Model;
    private LevelUpController levelUpController;

    public LevelUpView (GameLobbyModel model, LevelUpController levelUpController)
    {
        this.Model = model;
        this.levelUpController = levelUpController;
        MCharacter character = model.returnMCharacter();
        //statsPanel
        this.statsPanel = new JPanel(new GridLayout(0,1));
        statsPanel.setBackground(Color.BLACK);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        runeUpCost = new JLabel("<html><pre>Rune Up Cost  : "+levelUpController.upCost()+"</pre></html>");
        runeUpCost.setForeground(Color.WHITE);
        runeUpCost.setFont(new Font("Garamond", Font.BOLD,15));

        runesAmount = new JLabel("<html><pre>Runes         : "+character.getnRunes()+"</pre></html>");
        runesAmount.setForeground(Color.WHITE);
        runesAmount.setFont(new Font("Garamond", Font.BOLD,15));

        HP  = new JLabel("<html><pre>Health Points : "+ character.getHealthPoints() +" </pre></html>");
        HP.setForeground(Color.WHITE);
        HP.setFont(new Font("Garamond", Font.BOLD,15));

        END = new JLabel("<html><pre>Endurance     : "+character.getEndurance()+"</pre></html>");
        END.setForeground(Color.WHITE);
        END.setFont(new Font("Garamond", Font.BOLD,15));

        DEX = new JLabel("<html><pre>Dexterity     : "+character.getDexterity()+"</pre></html>");
        DEX.setForeground(Color.WHITE);
        DEX.setFont(new Font("Garamond", Font.BOLD,15));

        STR = new JLabel("<html><pre>Strength      : "+character.getStrength()+"</pre></html>");
        STR.setForeground(Color.WHITE);
        STR.setFont(new Font("Garamond", Font.BOLD,15));

        INT = new JLabel("<html><pre>Intelligence  : "+character.getIntelligence()+"</pre></html>");
        INT.setForeground(Color.WHITE);
        INT.setFont(new Font("Garamond", Font.BOLD,15));

        FTH = new JLabel("<html><pre>Faith         : "+character.getFaith()+"</pre></html>");
        FTH.setForeground(Color.WHITE);
        FTH.setFont(new Font("Garamond", Font.BOLD,15));

        statsPanel.add(runeUpCost);
        statsPanel.add(runesAmount);
        statsPanel.add(HP);
        statsPanel.add(END);
        statsPanel.add(DEX);
        statsPanel.add(STR);
        statsPanel.add(INT);
        statsPanel.add(FTH);

        //optionsPanel
        this.optionsPanel = new JPanel(new GridLayout(0,1,5,5));
        optionsPanel.setBackground(Color.GRAY);
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        LevHP = new JButton("Level Health");
        LevHP.setFocusPainted(false);
        LevHP.setBorder(BorderFactory.createEtchedBorder());
        LevHP.setFont(new Font("Garamond", Font.BOLD, 15));

        LevEND = new JButton("Level Endurance");
        LevEND.setFocusPainted(false);
        LevEND.setBorder(BorderFactory.createEtchedBorder());
        LevEND.setFont(new Font("Garamond", Font.BOLD, 15));

        LevDEX = new JButton("Level Dexterity");
        LevDEX.setFocusPainted(false);
        LevDEX.setBorder(BorderFactory.createEtchedBorder());
        LevDEX.setFont(new Font("Garamond", Font.BOLD, 15));

        LevSTR = new JButton("Level Strength");
        LevSTR.setFocusPainted(false);
        LevSTR.setBorder(BorderFactory.createEtchedBorder());
        LevSTR.setFont(new Font("Garamond", Font.BOLD, 15));

        LevINT = new JButton("Level Intelligence");
        LevINT.setFocusPainted(false);
        LevINT.setBorder(BorderFactory.createEtchedBorder());
        LevINT.setFont(new Font("Garamond", Font.BOLD, 15));

        LevFTH = new JButton("Level Faith");
        LevFTH.setFocusPainted(false);
        LevFTH.setBorder(BorderFactory.createEtchedBorder());
        LevFTH.setFont(new Font("Garamond", Font.BOLD, 15));

        Back = new JButton("Back");
        Back.setFocusPainted(false);
        Back.setBorder(BorderFactory.createEtchedBorder());
        Back.setFont(new Font("Garamond", Font.BOLD, 15));

        optionsPanel.add(LevHP);
        optionsPanel.add(LevEND);
        optionsPanel.add(LevDEX);
        optionsPanel.add(LevSTR);
        optionsPanel.add(LevINT);
        optionsPanel.add(LevFTH);
        optionsPanel.add(Back);

        //mainPanel
        mainPanel = new JPanel(new GridLayout(1,2));
        mainPanel.add(statsPanel);
        mainPanel.add(optionsPanel);

        //headerLabel
        headerLabel = new JLabel("Level Up", SwingConstants.CENTER);
        headerLabel.setForeground(Color.ORANGE);
        headerLabel.setFont(new Font("Garamond", Font.BOLD, 20));

        mainFrame = new JFrame("Level Up");
        mainFrame.setSize(500,400);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setLayout(new BorderLayout());

        //add to mainFrame
        mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(mainPanel,BorderLayout.CENTER);
    }

    public void updateView ()
    {
        MCharacter character = Model.returnMCharacter();

        runeUpCost.setText("<html><pre>Rune Up Cost  : "+levelUpController.upCost()+"</pre></html>");
        runesAmount.setText("<html><pre>Runes         : "+character.getnRunes()+"</pre></html>");
        HP.setText ("<html><pre>Health Points : "+ character.getHealthPoints() +" </pre></html>");
        END.setText("<html><pre>Endurance     : "+character.getEndurance()+"</pre></html>");
        DEX.setText("<html><pre>Dexterity     : "+character.getDexterity()+"</pre></html>");
        STR.setText("<html><pre>Strength      : "+character.getStrength()+"</pre></html>");
        INT.setText("<html><pre>Intelligence  : "+character.getIntelligence()+"</pre></html>");
        FTH.setText("<html><pre>Faith         : "+character.getFaith()+"</pre></html>");
    }

    public void addLevHpListener (ActionListener actionListener)
    {
        this.LevHP.addActionListener(actionListener);
    }
    public void addLevEndListener (ActionListener actionListener)
    {
        this.LevEND.addActionListener(actionListener);
    }
    public void addLevDexListener (ActionListener actionListener)
    {
        this.LevDEX.addActionListener(actionListener);
    }
    public void addLevStrListener (ActionListener actionListener)
    {
        this.LevSTR.addActionListener(actionListener);
    }
    public void addLevIntListener (ActionListener actionListener)
    {
        this.LevINT.addActionListener(actionListener);
    }
    public void addLevFthListener (ActionListener actionListener)
    {
        this.LevFTH.addActionListener(actionListener);
    }
    public void addBackListener (ActionListener actionListener)
    {
        this.Back.addActionListener(actionListener);
    }


    public void initiateLevelView ()
    {
        mainFrame.setVisible(true);
    }

    public void disposeLevelUpView ()
    {
        this.mainFrame.dispose();
    }

}
