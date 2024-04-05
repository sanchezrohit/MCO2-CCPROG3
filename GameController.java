/**
 * The GameController class serves as the main control for the game,
 * orchestrating interactions between different components and managing game flow.
 */
public class GameController { //Main game control

    /**
     * Controller for the title screen
     */
    private TitleScreenController titleScreenController;

    /**
     * Main character object
     */
    private MCharacter mainCharacter = new MCharacter();

    /**
     * Controller for character creation
     */
    private CharacterCreationController characCreation;

    /**
     * Controller for the game lobby
     */
    private GameLobbyController gameLobbyController;

    /**
     * Constructs a new GameController object.
     */
    public GameController () {
        this.titleScreenController = new TitleScreenController(this);
        this.characCreation = new CharacterCreationController(titleScreenController, mainCharacter, this);
    }

    /**
     * Handles the start or exit flag received from the title screen.
     *
     * @param flag the flag indicating whether to start or exit the game
     */
    public void handleStartExitFlag(int flag) {  // TitleScreen
        if (flag == 1) {
            System.out.println("We are starting");
            if (!this.characCreation.isInitiated()) {
                this.characCreation.inititateCharCreateContoller();
            } else
            {
                gameLobbyController.initiateGameLobby();
            }
        } else if (flag == 0) {
            System.out.println("We are exiting");
            System.exit(0); // Exit the application
        } else {
            System.out.println("Invalid flag value");
        }
    }

    /**
     * Starts the game lobby.
     */
    public void startGameLobby ()
    {
        this.characCreation.disposeCharacCreationFrame();
        this.gameLobbyController = new GameLobbyController(mainCharacter, characCreation);
        this.gameLobbyController.initiateGameLobby();
    }
}
