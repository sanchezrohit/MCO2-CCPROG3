/**
 * The JobClassSelectController class manages the selection of job classes during character creation.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class JobClassSelectController {

    private int selectedJobClass = -1;
    CharacterCreationController characterCreationController;
    JobClassModel jModel  = new JobClassModel();;

    /**
     * Constructs a JobClassSelectController with the provided CharacterCreationController.
     *
     * @param characterCreationController the CharacterCreationController instance
     */
    public JobClassSelectController (CharacterCreationController characterCreationController)
    {
        this.characterCreationController = characterCreationController;
    }

    /**
     * Initiates the job class selection process.
     */
    public void initiateJobClassSelection()
    {
        JobClassSelectView jobClassSelectView = new JobClassSelectView(jModel.returnJobClasses());

        for (int i = 0; i < 6; i++) {
            int jobIndex = i; // Required for accessing in inner class
            jobClassSelectView.addButtonActionListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedJobClass = jobIndex; // Update selectedJobClass with the clicked job index
                    characterCreationController.setIndexJobClass(selectedJobClass);
                    characterCreationController.enableCharacCreation();
                    jobClassSelectView.dispose();
                    System.out.println("chosen index is " + selectedJobClass);

                }
            });
        }
    }

    /**
     * Returns the index of the selected job class.
     *
     * @return the index of the selected job class
     */
    public int returnSelectedJobClass ()
    {
        return selectedJobClass;
    }

    /**
     * Returns the list of job classes.
     *
     * @return the list of job classes
     */
    public ArrayList<JobClass> returnJobClasses ()
    {
        return jModel.returnJobClasses();
    }


}
