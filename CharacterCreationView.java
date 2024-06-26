/**
 * The CharacterCreationView class represents the view component for character creation.
 * It provides graphical user interface elements and methods for user interaction.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CharacterCreationView {

    /**
     * Main frame for character creation
     */
    private JFrame mainFrame = new JFrame("Character Creation");
    /**
     *  Button to enter character name
     */
    private JButton enterCharacterName;
    /**
     * Button to select job class
     */
    private JButton selectJobClass;
    /**
     *  Button to confirm and proceed
     */
    private JButton confirmProceed;
    /**
     *  Button to go back
     */
    private JButton goBack;
    /**
     *  Label for step 1
     */
    private JLabel _1;
    /**
     * Label for step 2
     */
    private JLabel _2;
    /**
     * Label for step 3
     */
    private JLabel _3;
    /**
     *  Label for step 4
     */
    private JLabel _4;
    /**
     *  Header label
     */
    private JLabel frameHeader;
    /**
     *  Variable to store character name
     */
    private String charName;

    /**
     * Constructs a new CharacterCreationView object.
     */
    public CharacterCreationView ()
    {
        frameHeader = new JLabel("Character Creation");
        frameHeader.setForeground(Color.ORANGE);
        frameHeader.setBounds(170,20,200,40);
        frameHeader.setFont(new Font("Garamond", Font.BOLD,20));

        enterCharacterName = new JButton("1");
        enterCharacterName.setFocusPainted(false);
        enterCharacterName.setFont(new Font("Garamond", Font.BOLD,15));
        enterCharacterName.setBorder(BorderFactory.createEtchedBorder());
        enterCharacterName.setBounds(155,100,40,25);

        _1 = new JLabel("Enter Character Name");
        _1.setForeground(Color.WHITE);
        _1.setFont(new Font("Garamond", Font.BOLD,15));
        _1.setBounds(200,100,200,25);

        selectJobClass = new JButton("2");
        selectJobClass.setFocusPainted(false);
        selectJobClass.setFont(new Font("Garamond", Font.BOLD, 15));
        selectJobClass.setBorder(BorderFactory.createEtchedBorder());
        selectJobClass.setBounds(155,130,40,25);

        _2 = new JLabel("Select Job Class");
        _2.setForeground(Color.WHITE);
        _2.setFont(new Font("Garamond", Font.BOLD,15));
        _2.setBounds(200,130,200,25);

        confirmProceed = new JButton("3");
        confirmProceed.setFocusPainted(false);
        confirmProceed.setFont(new Font("Garamond", Font.BOLD, 15));
        confirmProceed.setBorder(BorderFactory.createEtchedBorder());
        confirmProceed.setBounds(155,160,40,25);

        _3 = new JLabel("Confirm and Proceed");
        _3.setForeground(Color.WHITE);
        _3.setFont(new Font("Garamond", Font.BOLD,15));
        _3.setBounds(200,160,200,25);

        goBack = new JButton("4");
        goBack.setFocusPainted(false);
        goBack.setFont(new Font("Garamond", Font.BOLD, 15));
        goBack.setBorder(BorderFactory.createEtchedBorder());
        goBack.setBounds(155,190,40,25);

        _4 = new JLabel("Go Back");
        _4.setForeground(Color.WHITE);
        _4.setFont(new Font("Garamond", Font.BOLD,15));
        _4.setBounds(200,190,200,25);

        // Get the content pane of the mainFrame
        Container contentPane = mainFrame.getContentPane();
        contentPane.setBackground(Color.BLACK); // Set background color

        mainFrame.setLayout(null);
        mainFrame.setSize(500,300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        // Add components to the main frame
        mainFrame.add(frameHeader);
        mainFrame.add(enterCharacterName);
        mainFrame.add(_1);
        mainFrame.add(selectJobClass);
        mainFrame.add(_2);
        mainFrame.add(confirmProceed);
        mainFrame.add(_3);
        mainFrame.add(goBack);
        mainFrame.add(_4);

    }

    /**
     * Adds an action listener to the enter character name button.
     *
     * @param actionListener the action listener to be added
     */
    public void addOption1Listener (ActionListener actionListener)
    {
        enterCharacterName.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the enter character name button.
     *
     * @param actionListener the action listener to be added
     */
    public void addOption2Listener(ActionListener actionListener)
    {
        selectJobClass.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the confirm and proceed button.
     *
     * @param actionListener the action listener to be added
     */
    public void addOption3Listener (ActionListener actionListener)
    {
        confirmProceed.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the go back button.
     *
     * @param actionListener the action listener to be added
     */
    public void addOption4Listener (ActionListener actionListener)
    {
        goBack.addActionListener(actionListener);
    }

    /**
     * Disposes of the main frame.
     */
    public void disposeFrame ()
    {
        this.mainFrame.setVisible(false);
    }

    /**
     * Disables the main frame.
     */
    public void disableFrame ()
    {
        this.mainFrame.setEnabled(false);
    }

    /**
     * Enables the main frame.
     */
    public void enableFrame ()
    {
        this.mainFrame.setEnabled(true);
    }

    /**
     * Retrieves the character name from user input.
     *
     * @return the character name entered by the user
     */
    public String getCharacterName ()
    {
        return charName = JOptionPane.showInputDialog("Enter your desired name:");
    }

    /**
     * Displays the character creation view.
     */
    public void inititaeCharCreateView ()
    {
        this.mainFrame.setVisible(true);
    }

}
