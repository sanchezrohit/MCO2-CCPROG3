/**
 * The CharacterCreationController class manages the character creation process in the game.
 * It interacts with the CharacterCreationView and CharacterCreationModel to facilitate
 * character customization and initialization.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCreationController {

    /**
     * The view component for character creation
     */
    private CharacterCreationView characterCreationView;
    /**
     * The model component for character creation
     */
    private CharacterCreationModel characterCreationModel;
    /**
     * Temporary storage for character name
     */
    private String tempName;
    /**
     * Index of the selected job class
     */
    private int indexJobClass = -1;
    /**
     * Controller for job class selection
     */
    private JobClassSelectController jobClass;
    /**
     * Controller for the title screen
     */
    private TitleScreenController titleScreenController;

    /**
     * Flag indicating if character creation has been initiated
     */
    private boolean initiated = false;

    /**
     * Retrieves the status of character creation initiation.
     *
     * @return true if character creation has been initiated, false otherwise
     */
    public boolean isInitiated ()
    {
        return initiated;
    }

    /**
     * Sets the status of character creation initiation.
     *
     * @param i the boolean value indicating if character creation has been initiated
     */
    public void setInitiated (boolean i)
    {
        initiated = i;
    }

    /**
     * Constructs a new CharacterCreationController object.
     *
     * @param titleScreenController the controller for the title screen
     * @param mainCharacter        the main character of the game
     * @param gameController       the controller for the game
     */
    public CharacterCreationController (TitleScreenController titleScreenController, MCharacter mainCharacter, GameController gameController)
    {
        // Initialize components
        this.characterCreationView = new CharacterCreationView();
        this.characterCreationModel = new CharacterCreationModel(mainCharacter);
        this.jobClass = new JobClassSelectController(this);
        this.titleScreenController = titleScreenController;

        // Action listener for character name input
        characterCreationView.addOption1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempName = characterCreationView.getCharacterName();
                if (tempName != null) {
                    tempName = tempName.trim();
                    if (!tempName.isEmpty()) {
                        if (tempName.length() > 25) {
                            tempName = tempName.substring(0, 25);
                            characterCreationModel.returnMC().setName(tempName);
                        }
                        else {
                            characterCreationModel.returnMC().setName(tempName);
                        }
                    }
                }
                System.out.println(characterCreationModel.returnMC().getName() + " : name");
            }
        });

        characterCreationView.addOption2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterCreationView.disableFrame();
                jobClass.initiateJobClassSelection();
            }
        });

        characterCreationView.addOption3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (characterCreationModel.returnMC().getName() == null || characterCreationModel.returnMC().getName().isEmpty() || indexJobClass == -1)
                {
                    JOptionPane.showMessageDialog(null,"Please enter your character's name and/or select a job class first.", "Note", JOptionPane.ERROR_MESSAGE);
                } else
                {
                    copyJobClass(jobClass.returnJobClasses().get(indexJobClass), characterCreationModel.returnMC());
                    setInitiated(true);
                    gameController.startGameLobby();
                }
                System.out.println(characterCreationModel.returnMC().getName() + " " + indexJobClass);
                System.out.println(characterCreationModel.returnMC().getJobClassName() + " job");
            }
        });

        characterCreationView.addOption4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterCreationView.disposeFrame(); // Dispose the Character Creation frame
                titleScreenController.showTitleScreen();
            }
        });


    }

    /**
     * Displays the title screen from the character creation screen.
     */
    public void showTitleScreenFromCharacCreation ()
    {
        this.titleScreenController.showTitleScreen();
    }

    /**
     * Enables character creation view.
     */
    public void enableCharacCreation ()
    {
        characterCreationView.enableFrame();
    }

    /**
     * Sets the index of the selected job class.
     *
     * @param index the index of the selected job class
     */
    public void setIndexJobClass(int index) {
        this.indexJobClass = index;
    }

    /**
     * Displays the character creation controller.
     */
    public void inititateCharCreateContoller ()
    {
        this.characterCreationView.inititaeCharCreateView();
    }

    /**
     * Disposes of the character creation frame.
     */
    public void disposeCharacCreationFrame ()
    {
        this.characterCreationView.disposeFrame();
    }

    /**
     * Copies attributes of the selected job class to the main character.
     *
     * @param job       the selected job class
     * @param character the main character
     */
    public void copyJobClass (JobClass job, MCharacter character)
    {

        this.characterCreationModel.returnMC().setHealthPoints(job.getHealthPoint());
        this.characterCreationModel.returnMC().setDexterity(job.getDexterity());
        this.characterCreationModel.returnMC().setIntelligence(job.getIntelligence());
        this.characterCreationModel.returnMC().setEndurance(job.getEndurance());
        this.characterCreationModel.returnMC().setStrength(job.getStrength());
        this.characterCreationModel.returnMC().setFaith(job.getFaith());

        this.characterCreationModel.returnMC().setCharacterLevel(job.getLevel());
        this.characterCreationModel.returnMC().setJobClassName(job.getName());
    }
}
