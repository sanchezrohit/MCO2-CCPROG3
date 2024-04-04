public class GameLobbyModel {
    MCharacter mCharacter;
    public GameLobbyModel (MCharacter mainCharacter)
    {
        this.mCharacter = mainCharacter;
    }

    public MCharacter returnMCharacter ()
    {
        return mCharacter;
    }

}
