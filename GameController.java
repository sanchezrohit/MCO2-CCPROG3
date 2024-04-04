public class GameController { //Main game control

    private TitleScreenController titleScreenController;
    private MCharacter mainCharacter = new MCharacter();
    private CharacterCreationController characCreation;
    private GameLobbyController gameLobbyController;

    public GameController () {
        this.titleScreenController = new TitleScreenController(this);
        this.characCreation = new CharacterCreationController(titleScreenController, mainCharacter, this);
    }

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

    public void startGameLobby ()
    {
        this.characCreation.disposeCharacCreationFrame();
        this.gameLobbyController = new GameLobbyController(mainCharacter, characCreation);
        this.gameLobbyController.initiateGameLobby();
    }
}
