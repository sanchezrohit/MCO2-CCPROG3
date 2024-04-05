/**
 * The JobClassSelectView class represents the GUI for selecting a job class during character creation.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class JobClassSelectView extends JFrame{

    private JPanel jobClassPanels;
    private JLabel[] statsLabels = new JLabel[6];
    private JPanel[] statsPanel = new JPanel[6];

    private JButton[] chosenJobClass = new JButton[6];

    /**
     * Constructs a JobClassSelectView with the provided list of job classes.
     *
     * @param jobClasses the list of job classes to display
     */public JobClassSelectView (ArrayList<JobClass> jobClasses)
    {
        jobClassPanels = new JPanel(new GridLayout(2,3,10,10));
        jobClassPanels.setBackground(Color.GRAY);
        jobClassPanels.setSize(200,200);

        String[] staticticsLabels = {
                "HealthPoints",
                "Dexterity",
                "Intelligence",
                "Endurance",
                "Strength",
                "Faith"
        };

        for (int i = 0; i < 6; i++) {
            // Initialize the buttons
            chosenJobClass[i] = new JButton("Select "+jobClasses.get(i).getName());
            chosenJobClass[i].setFocusPainted(false);
            chosenJobClass[i].setBorder(BorderFactory.createEtchedBorder());
            chosenJobClass[i].setSize(new Dimension(100,50));
            chosenJobClass[i].setFont(new Font("Garamond", Font.BOLD,14));

            // Initialize each statsPanel element
            statsPanel[i] = new JPanel(new GridLayout(3, 2,5,5));
            statsPanel[i].setBackground(Color.BLACK);
            jobClassPanels.add(createJobClassPanel(statsPanel[i], jobClasses.get(i).getName(), chosenJobClass[i] )); // Add each statsPanel to jobClassPanels


            // Initialize each statsLabels element
            for (int k = 0; k < 6; k++) {
                statsLabels[k] = new JLabel("", SwingConstants.CENTER);
                statsLabels[k].setForeground(Color.WHITE);
                statsLabels[k].setFont(new Font("Garamond", Font.BOLD,13));
                statsPanel[i].add(statsLabels[k]); // Add each label to statsPanel

                statsLabels[k].setText(staticticsLabels[k] + ": "); //Store

                switch (k) {
                    case 0:
                        statsLabels[k].setText(statsLabels[k].getText() + jobClasses.get(i).getHealthPoint());
                        break;
                    case 1:
                        statsLabels[k].setText(statsLabels[k].getText() + jobClasses.get(i).getDexterity());
                        break;
                    case 2:
                        statsLabels[k].setText(statsLabels[k].getText() + jobClasses.get(i).getIntelligence());
                        break;
                    case 3:
                        statsLabels[k].setText(statsLabels[k].getText() + jobClasses.get(i).getEndurance());
                        break;
                    case 4:
                        statsLabels[k].setText(statsLabels[k].getText() + jobClasses.get(i).getStrength());
                        break;
                    case 5:
                        statsLabels[k].setText(statsLabels[k].getText() + jobClasses.get(i).getFaith());
                        break;
                }
            }
        }


        this.setTitle("Job Class Selection");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //add
        this.add(jobClassPanels);

        this.setVisible(true);
    }


    /**
     * Creates a panel for displaying job class details.
     *
     * @param panel        the panel to display job class details
     * @param jobClassName the name of the job class
     * @param button       the button for selecting the job class
     * @return the created panel
     */
    private JPanel createJobClassPanel(JPanel panel, String jobClassName, JButton button) {
        JPanel jobClassPanel = new JPanel(new BorderLayout());
        JLabel headerLabel = new JLabel(jobClassName, SwingConstants.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        headerLabel.setFont(new Font("Garamond", Font.BOLD,14));
        jobClassPanel.add(headerLabel, BorderLayout.NORTH);
        jobClassPanel.add(panel, BorderLayout.CENTER);
        jobClassPanel.add(buttonPanel, BorderLayout.SOUTH);
        return jobClassPanel;
    }


    /**
     * Adds an action listener to the button associated with the specified index.
     *
     * @param index          the index of the button
     * @param actionListener the action listener to add
     */
    public void addButtonActionListener(int index, ActionListener actionListener) {
        if (index >= 0 && index < chosenJobClass.length) {
            chosenJobClass[index].addActionListener(actionListener);
        }
    }

    /**
     * Disposes of the job selection window.
     */
    public void disposeJobSelection ()
    {
        this.dispose();
    }

}
