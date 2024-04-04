import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class JobClassSelectController {

    private int selectedJobClass = -1;
    CharacterCreationController characterCreationController;
    JobClassModel jModel  = new JobClassModel();;

    public JobClassSelectController (CharacterCreationController characterCreationController)
    {
        this.characterCreationController = characterCreationController;
    }

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

    public int returnSelectedJobClass ()
    {
        return selectedJobClass;
    }

    public ArrayList<JobClass> returnJobClasses ()
    {
        return jModel.returnJobClasses();
    }


}
