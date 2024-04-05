/**
 * The AreaView class represents the graphical user interface for different game areas.
 * It initializes and displays the main frame for each area.
 */
import javax.swing.*;
import java.awt.*;

public class AreaView {

    private JFrame mainFrame;

    /**
     * Constructs an AreaView object.
     */
    public AreaView ()
    {
        mainFrame = new JFrame("");
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);

    }

    /**
     * Displays the Stormveil Castle area.
     */
    public void stormVeilCastle ()
    {
        SwingUtilities.invokeLater(() -> {
            mainFrame.setTitle("Stormveil Castle");
            this.mainFrame.setVisible(true);

            new FloorManager(mainFrame); // Manages floor transitions
        });
    }

    public void rayaLucariaAcademy ()
    {
        SwingUtilities.invokeLater(() -> {
            mainFrame.setTitle("Raya Lucaria Academy");
            mainFrame.setVisible(true);

            new FloorManagerRaya(mainFrame); // Manages floor transitions
        });
    }
}
