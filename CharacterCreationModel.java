import java.util.ArrayList;

public class CharacterCreationModel {
    private MCharacter mainCharacter;

    //JobClasses

    public CharacterCreationModel (MCharacter mc)
    {
        this.mainCharacter = mc;
    }

    public MCharacter returnMC ()
    {
        return this.mainCharacter;
    }

}
