/**
 * The CharacterCreationModel class represents the model component of character creation,
 * encapsulating the main character's attributes and job classes.
 */
public class CharacterCreationModel {
    /**
     *  The main character object
     */
    private MCharacter mainCharacter;

    /**
     * Constructs a new CharacterCreationModel object.
     *
     * @param mc the main character object
     */
    public CharacterCreationModel (MCharacter mc)
    {
        this.mainCharacter = mc;
    }

    /**
     * Retrieves the main character object.
     *
     * @return the main character object
     */
    public MCharacter returnMC ()
    {
        return this.mainCharacter;
    }

}
