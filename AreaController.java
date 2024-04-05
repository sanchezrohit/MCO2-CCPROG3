/**
 * The AreaController class controls the selection of game areas and the initiation of specific areas.
 * It allows the player to choose an area and initializes the corresponding view.
 */
import javax.swing.*;

public class AreaController {

    private int areaOption;

    AreaView areaView;
    /**
     * Constructs an AreaController object.
     */
    public AreaController ()
    {
        areaView = new AreaView();
    }

    /**
     * Allows the player to choose an area.
     *
     * @return The index of the selected area.
     */
    public int chooseArea()
    {
        String[] Area = {"Stromveil Castle", "Raya Lucaria Academy", "The Elden Throne"};
        areaOption = JOptionPane.showOptionDialog(null,
                "Which area do you want to go?",
                "Areas",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Area,
                0);
        System.out.println(areaOption);

        return areaOption;
    }

    /**
     * Initiates the Stormveil Castle area.
     */
    public void InitiateStormVeil () {

        this.areaView.stormVeilCastle();
    }

    public void rayaLucaria ()
    {
        this.areaView.rayaLucariaAcademy();
    }

}
