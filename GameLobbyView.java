/**
 * The GameLobbyView class represents the view component of the game lobby,
 * providing the graphical user interface for the game lobby.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameLobbyView  {

    private JFrame mainFrame = new JFrame("Game Lobby");

    private JLabel nameLabel;
    private JLabel jobClassLabel;
    private JLabel levelLabel;
    private JLabel runesLabel;

    //stats of the player
    private JLabel HP;
    private JLabel END;
    private JLabel DEX;
    private JLabel STR;
    private JLabel INT;
    private JLabel FTH;

    private JLabel frameHeader;
    private JPanel mainPanel;

    //buttons
    private JButton fastTravelButton;
    private JButton levelUpButton;
    private JButton inventoryButton;
    private JButton shopButton;
    private JButton quitButton;

    private GameLobbyModel Model;

    /**
     * Constructs a new GameLobbyView object.
     *
     * @param controller the game lobby controller
     * @param model      the game lobby model
     */
    public GameLobbyView (GameLobbyController controller, GameLobbyModel model)
    {
        this.Model = model;
        MCharacter character = model.returnMCharacter();

        frameHeader = new JLabel("Game Lobby", SwingConstants.CENTER);
        frameHeader.setForeground(Color.ORANGE);
        frameHeader.setFont(new Font("Garamond", Font.BOLD,20));

        mainFrame.setLayout(new BorderLayout()); //change new GridLayout(1, 2)
        mainFrame.setSize(600,400);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        nameLabel = new JLabel    ("<html><pre>Name      : " + character.getName() + "</pre></html>");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setFont(new Font("Garamond", Font.BOLD,15));

        jobClassLabel = new JLabel("<html><pre>Job Class : " + character. getJobClassName() + "</pre></html>");
        jobClassLabel.setForeground(Color.WHITE);
        jobClassLabel.setFont(new Font("Garamond", Font.BOLD,15));

        levelLabel = new JLabel   ("<html><pre>Level     : " + character.getCharacterLevel() + "</pre></html>");
        levelLabel.setForeground(Color.WHITE);
        levelLabel.setFont(new Font("Garamond", Font.BOLD,15));

        runesLabel = new JLabel   ("<html><pre>Runes     : "+character.getnRunes()+"</pre></html>");
        runesLabel.setForeground(Color.WHITE);
        runesLabel.setFont(new Font("Garamond", Font.BOLD,15));

        //stats
        HP  = new JLabel("<html><pre>Health Points : "+ character.getHealthPoints()+"</pre></html>");
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

        JPanel labelsPanel = new JPanel(new GridLayout(0,1,5,5));

        labelsPanel.setBackground(Color.BLACK);
        labelsPanel.setPreferredSize(new Dimension(300,400));
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        labelsPanel.add(nameLabel);
        labelsPanel.add(jobClassLabel);
        labelsPanel.add(levelLabel);
        labelsPanel.add(runesLabel);

        labelsPanel.add(HP);
        labelsPanel.add(END);
        labelsPanel.add(DEX);
        labelsPanel.add(STR);
        labelsPanel.add(INT);
        labelsPanel.add(FTH);

        //Buttons
        fastTravelButton = new JButton("Fast Travel");
        fastTravelButton.setFocusPainted(false);
        fastTravelButton.setBorder(BorderFactory.createEtchedBorder());
        fastTravelButton.setFont(new Font("Garamond", Font.BOLD, 15));

        levelUpButton = new JButton("Level Up");
        levelUpButton.setFocusPainted(false);
        levelUpButton.setBorder(BorderFactory.createEtchedBorder());
        levelUpButton.setFont(new Font("Garamond", Font.BOLD, 15));

        inventoryButton = new JButton("Inventory");
        inventoryButton.setFocusPainted(false);
        inventoryButton.setBorder(BorderFactory.createEtchedBorder());
        inventoryButton.setFont(new Font("Garamond", Font.BOLD, 15));

        shopButton = new JButton("Shop");
        shopButton.setFocusPainted(false);
        shopButton.setBorder(BorderFactory.createEtchedBorder());
        shopButton.setFont(new Font("Garamond", Font.BOLD, 15));

        quitButton = new JButton("Quit Game");
        quitButton.setFocusPainted(false);
        quitButton.setBorder(BorderFactory.createEtchedBorder());
        quitButton.setFont(new Font("Garamond", Font.BOLD, 15));

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1,5,5));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setPreferredSize(new Dimension(300,400));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        //button panel add
        buttonPanel.add(fastTravelButton);
        buttonPanel.add(levelUpButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(shopButton);
        buttonPanel.add(quitButton);

        //mainPanel add
        mainPanel.add(labelsPanel);
        mainPanel.add(buttonPanel);

        //add components onto the frame
        mainFrame.add(frameHeader, BorderLayout.NORTH);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Updates the view with the latest player information.
     */
    public void updateView ()
    {
        MCharacter character = Model.returnMCharacter();
        levelLabel.setText("<html><pre>Level     : " + character.getCharacterLevel() + "</pre></html>");
        runesLabel.setText("<html><pre>Runes     : "+character.getnRunes()+"</pre></html>");
        HP.setText ("<html><pre>Health Points : "+ character.getHealthPoints()+"</pre></html>");
        END.setText("<html><pre>Endurance     : "+character.getEndurance()+"</pre></html>");
        DEX.setText("<html><pre>Dexterity     : "+character.getDexterity()+"</pre></html>");
        STR.setText("<html><pre>Strength      : "+character.getStrength()+"</pre></html>");
        INT.setText("<html><pre>Intelligence  : "+character.getIntelligence()+"</pre></html>");
        FTH.setText("<html><pre>Faith         : "+character.getFaith()+"</pre></html>");
    }


    /**
     * Displays the game lobby view.
     */
    public void initiateGameLobbyView()
    {
        mainFrame.setVisible(true);
    }

    /**
     * Disposes of the game lobby view.
     */
    public void disposeGameLobbyView ()
    {
        this.mainFrame.dispose();
    }

    /**
     * Disables the frame of the game lobby view.
     */
    public void disableFrame ()
    {
        this.mainFrame.setEnabled(false);
    }

    /**
     * Enables the frame of the game lobby view.
     */
    public void enableFrame ()
    {
        this.mainFrame.setEnabled(true);
    }

    /**
     * Sets the action listener for the fast travel button.
     *
     * @param actionListener the action listener for the fast travel button
     */
    public void setFastTravelButtonListener(ActionListener actionListener)
    {
        this.fastTravelButton.addActionListener(actionListener);
    }

    /**
     * Sets the action listener for the level up button.
     *
     * @param actionListener the action listener for the level up button
     */
    public void setLevelUpButtonListener (ActionListener actionListener)
    {
        this.levelUpButton.addActionListener(actionListener);
    }


    /**
     * Sets the action listener for the inventory button.
     *
     * @param actionListener the action listener for the inventory button
     */
    public void setInventoryButtonListener (ActionListener actionListener)
    {
        this.inventoryButton.addActionListener(actionListener);
    }

    /**
     * Sets the action listener for the shop button.
     *
     * @param actionListener the action listener for the shop button
     */
    public void setShopButtonListener (ActionListener actionListener)
    {
        this.shopButton.addActionListener(actionListener);
    }

    /**
     * Sets the action listener for the quit button.
     *
     * @param actionListener the action listener for the quit button
     */
    public void setQuitButton (ActionListener actionListener)
    {
        this.quitButton.addActionListener(actionListener);
    }

}
