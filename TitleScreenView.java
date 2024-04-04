import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class TitleScreenView {
    private JFrame mainFrame = new JFrame("Title Screen");
    private JButton startButton;
    private JButton exitButton;
    private JLabel titleHeader;

    public TitleScreenView ()
    {

    }

    public void initiateTitleScreenView ()
    {
        ImageIcon image = new ImageIcon("icon.png"); // create an image icon


        startButton = new JButton("START");
        startButton.setFocusPainted(false);
        startButton.setBounds(185,100,100,40);
        startButton.setFont(new Font("Garamond", Font.BOLD,13));
        startButton.setBorder(BorderFactory.createEtchedBorder());

        exitButton = new JButton("EXIT");
        exitButton.setFocusPainted(false);
        exitButton.setBounds(185,145,100,40);
        exitButton.setFont(new Font("Garamond", Font.BOLD,13));
        exitButton.setBorder(BorderFactory.createEtchedBorder());

        titleHeader = new JLabel("Elden Rogue");
        titleHeader.setForeground(Color.ORANGE);
        titleHeader.setBounds(180,20,200,40);
        titleHeader.setFont(new Font("Garamond", Font.BOLD,20));

        // Get the content pane of the mainFrame
        Container contentPane = mainFrame.getContentPane();
        contentPane.setBackground(Color.BLACK); // Set background color

        mainFrame.setLayout(null);
        mainFrame.setSize(500,300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(image.getImage());

        mainFrame.add(titleHeader);
        mainFrame.add(startButton);
        mainFrame.add(exitButton);

        mainFrame.setVisible(true);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public void disposeFrame ()
    {
        this.mainFrame.dispose();
    }

}
