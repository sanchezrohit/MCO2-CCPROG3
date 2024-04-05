/**
 * The GameLobbyController class manages the game lobby interface and interactions within the game.
 * It coordinates between the model (GameLobbyModel) and the view (GameLobbyView), as well as
 * various sub-controllers such as LevelUpController and ShopController.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLobbyController {

    /**
     *   Model component for the game lobby
     */
    private GameLobbyModel gameLobbyModel;

    /**
     *  View component for the game lobby
     */
    private GameLobbyView gameLobbyView;

    /**
     * Controller for character creation
     */
    private CharacterCreationController characterCreationController;

    /**
     * Controller for level-up functionality
     */
    private LevelUpController levelUpController;

    /**
     * Controller for shop functionality
     */
    private ShopController shopController;

    /**
     * Constructs a new GameLobbyController object.
     *
     * @param mainCharacter         the main character object
     * @param characCreation        the character creation controller
     */
    public GameLobbyController (MCharacter mainCharacter, CharacterCreationController characCreation)
    {
        this.characterCreationController = characCreation;
        gameLobbyModel = new GameLobbyModel(mainCharacter);
        gameLobbyView = new GameLobbyView(this, gameLobbyModel);
        levelUpController = new LevelUpController(gameLobbyModel, this);
        shopController = new ShopController(gameLobbyModel);

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

        gameLobbyView.setShopButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopController.initiateShop();
            }
        });

        gameLobbyView.setFastTravelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaController areaController = new AreaController();
                int option = areaController.chooseArea();
                if (option == 0)
                {
                    areaController.InitiateStormVeil();
                } else if (option == 1) {
                    areaController.rayaLucaria();
                } else if (option == 2) {
                    // Handle other area options
                } else {
                    // Handle other area options
                }
            }
        });
    }

    /**
     * Updates the game lobby view.
     */
    public void updateGameLobby ()
    {
        this.gameLobbyView.updateView();
    }
    /**
     * Initiates the game lobby.
     */
    public void initiateGameLobby ()
    {
        gameLobbyView.initiateGameLobbyView();
    }

    /**
     * Disables the game lobby.
     */
    public void disableGameLobby ()
    {
        this.gameLobbyView.disableFrame();
    }


    /**
     * Enables the game lobby.
     */
    public void enableGameLobby ()
    {
        this.gameLobbyView.enableFrame();
    }


    /**
     * Disposes of the game lobby controller.
     */
    public void diposeGameLobbyController ()
    {
        this.gameLobbyView.disposeGameLobbyView();
    }



}
