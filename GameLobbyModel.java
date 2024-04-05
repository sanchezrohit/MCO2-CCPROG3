/**
 * The GameLobbyModel class represents the model component of the game lobby,
 * providing data and functionality related to weapons and the main character's inventory.
 */
import java.util.ArrayList;

public class GameLobbyModel {
    /**
     *  The main character object
     */
    private MCharacter mCharacter;

    /**
     * The inventory of the main character
     */
    private Inventory inventory;

    /**
     *  List of available weapons
     */
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    /**
     * Constructs a new GameLobbyModel object.
     *
     * @param mainCharacter the main character object
     */
    public GameLobbyModel (MCharacter mainCharacter)
    {
        // Initialize weapons

        //Swords
        Weapon shortSword = new Weapon("Short Sword", 1000, 13, 0,15,15,15,15);
        Weapon rogiersRapier = new Weapon("Rogier's Rapier", 2000, 18,10,25,35,35,35);
        Weapon codedSword = new Weapon("Coded Sword", 4000,21,20,35,40,40,40);
        Weapon swordOfNightAndFlame = new Weapon("Sword of Night and Flame",8000,25,30,45,55,55,55);
        weapons.add(shortSword);
        weapons.add(rogiersRapier);
        weapons.add(codedSword);
        weapons.add(swordOfNightAndFlame);

        //Katanas
        Weapon uchigatana = new Weapon("Uchigatana",1875,15,20,35,30,0,0);
        Weapon moonVeil = new Weapon("Moonveil", 3750,20,30,40,45,0,0);
        Weapon riversOfBlood = new Weapon("Rivers of Blood",7500,25,40,45,60,0,0);
        Weapon handOfMalenia = new Weapon("Hand of Malenia",15000,30,50,50,75,0,0);
        weapons.add(uchigatana);
        weapons.add(moonVeil);
        weapons.add(riversOfBlood);
        weapons.add(handOfMalenia);

        //Whips
        Weapon whip = new Weapon("Whip",1500,20,15,60,20,0,0);
        Weapon urumi = new Weapon("Urumi",3000,25,20,70,40,10,0);
        Weapon thornedWhip = new Weapon("Thorned Whip",5000,30,30,80,50,0,40);
        Weapon hoslowsPetalWhip = new Weapon("Hoslow's Petal Whip",10000,35,35,90,55,20,20);
        weapons.add(whip);
        weapons.add(urumi);
        weapons.add(thornedWhip);
        weapons.add(hoslowsPetalWhip);

        //GreatSwords
        Weapon claymore = new Weapon("Claymore",3000,9,15,10,20,0,0);
        Weapon starscourgeGreatsword = new Weapon("Starscourge Greatsword",6000,14,20,15,40,0,20);
        Weapon inseparableSword = new Weapon("Inseperable Sword",12000,19,25,20,70,60,60);
        Weapon malikethsBlackBlade = new Weapon ("Maliketh's Black Blade",24000,24,30,25,80,40,60);
        weapons.add(claymore);
        weapons.add(starscourgeGreatsword);
        weapons.add(inseparableSword);
        weapons.add(malikethsBlackBlade);

        //Staves
        Weapon astrologersStaff = new Weapon("Astrologer's Staff",2000,12,5,20,5,25,15);
        Weapon albinauricSatff = new Weapon("Albinauric Staff",4000,14,10,30,10,45,35);
        Weapon staffOfTheGuilty = new Weapon("Staff of the Guilty",8000,16,15,40,15,65,60);
        Weapon carianRegalSceprter = new Weapon("Carian Regal Scepter", 16000,18,25,50,20,85,75);
        weapons.add(astrologersStaff);
        weapons.add(albinauricSatff);
        weapons.add(staffOfTheGuilty);
        weapons.add(carianRegalSceprter);

        //Seals
        Weapon fingerSeal = new Weapon("Finger Seal",2500,10,10,45,0,15,20);
        Weapon godslayersSeal = new Weapon("Godslayer's Seal",5000,12,15,50,0,35,40);
        Weapon goldenOrderSeal = new Weapon("Golden Order Seal",10000,14,20,55,0,65,65);
        Weapon dragonCommunionSeal = new Weapon("Dragon Communion Seal",15000,18,25,60,0,75,80);
        weapons.add(fingerSeal);
        weapons.add(godslayersSeal);
        weapons.add(goldenOrderSeal);
        weapons.add(dragonCommunionSeal);

        this.mCharacter = mainCharacter;
    }

    /**
     * Returns the list of available weapons.
     *
     * @return the list of weapons
     */
    public ArrayList<Weapon> returnWeapons ()
    {
        return weapons;
    }

    /**
     * Returns the main character object.
     *
     * @return the main character object
     */
    public MCharacter returnMCharacter ()
    {
        return mCharacter;
    }

}
