import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenController {

    private int startExitFlag = -1;
    private TitleScreenView titleScreen;
    private final GameController gameController;


    public TitleScreenController(GameController gameController) {
        this.gameController = gameController;
        titleScreen = new TitleScreenView();
        titleScreen.initiateTitleScreenView();
        titleScreen.addStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startExitFlag = 1; //start
                titleScreen.disposeFrame();
                gameController.handleStartExitFlag(startExitFlag);
            }
        });
        titleScreen.addExitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startExitFlag = 0; //exit
                gameController.handleStartExitFlag(startExitFlag);
            }
        });
    }

    public void showTitleScreen ()
    {
        titleScreen.initiateTitleScreenView();
    }

}
