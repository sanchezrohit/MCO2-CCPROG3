import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLobbyController {

    private GameLobbyModel gameLobbyModel;
    private GameLobbyView gameLobbyView;
    private CharacterCreationController characterCreationController;
    private LevelUpController levelUpController;


    public GameLobbyController (MCharacter mainCharacter, CharacterCreationController characCreation)
    {
        this.characterCreationController = characCreation;
        gameLobbyModel = new GameLobbyModel(mainCharacter);
        gameLobbyView = new GameLobbyView(this, gameLobbyModel);
        levelUpController = new LevelUpController(gameLobbyModel, this);

        gameLobbyView.setQuitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLobbyView.disposeGameLobbyView();
                characterCreationController.showTitleScreenFromCharacCreation();
            }
        });
//        mainCharacter.setnRunes(1000); test this
        gameLobbyView.setLevelUpButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLobbyView.disposeGameLobbyView();
                levelUpController.updateLevelUpView();
                levelUpController.inititaeLevelUp();
            }
        });
    }

    public void updateGameLobby ()
    {
        this.gameLobbyView.updateView();
    }
    public void initiateGameLobby ()
    {
        gameLobbyView.initiateGameLobbyView();
    }

    public void disableGameLobby ()
    {
        this.gameLobbyView.disableFrame();
    }

    public void enableGameLobby ()
    {
        this.gameLobbyView.enableFrame();
    }

    public void diposeGameLobbyController ()
    {
        this.gameLobbyView.disposeGameLobbyView();
    }



}
