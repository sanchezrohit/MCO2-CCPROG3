import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCreationController {

    private CharacterCreationView characterCreationView;
    private CharacterCreationModel characterCreationModel;
    private String tempName;
    private int indexJobClass = -1;
    private JobClassSelectController jobClass;
    private TitleScreenController titleScreenController;

    private boolean initiated = false;

    public boolean isInitiated ()
    {
        return initiated;
    }

    public void setInitiated (boolean i)
    {
        initiated = i;
    }


    public CharacterCreationController (TitleScreenController titleScreenController, MCharacter mainCharacter, GameController gameController)
    {
        this.characterCreationView = new CharacterCreationView();
        this.characterCreationModel = new CharacterCreationModel(mainCharacter);
        this.jobClass = new JobClassSelectController(this);
        this.titleScreenController = titleScreenController;

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

    public void showTitleScreenFromCharacCreation ()
    {
        this.titleScreenController.showTitleScreen();
    }

    public void enableCharacCreation ()
    {
        characterCreationView.enableFrame();
    }

    public void setIndexJobClass(int index) {
        this.indexJobClass = index;
    }

    public void inititateCharCreateContoller ()
    {
        this.characterCreationView.inititaeCharCreateView();
    }

    public void disposeCharacCreationFrame ()
    {
        this.characterCreationView.disposeFrame();
    }

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
