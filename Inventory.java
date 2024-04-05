/**
 * The Inventory class represents the inventory system in the game,
 * storing a list of weapons that the player possesses.
 */
import java.util.ArrayList;

public class Inventory {

    /**
     *  List to store weapons
     */
    private ArrayList<Weapon> weaponList = new ArrayList<>();

    /**
     * Constructs a new Inventory object.
     */
    public Inventory ()
    {
        // Constructor is intentionally left empty
    }

    /**
     * Adds a weapon to the inventory.
     *
     * @param weapon the weapon to be added
     */
    public void addWeaponToInvetory (Weapon weapon)
    {
        weaponList.add(weapon);
    }

    /**
     * Returns the list of weapons in the inventory.
     *
     * @return the list of weapons
     */
    public ArrayList<Weapon> returnList ()
    {
        return weaponList;
    }

    /**
     * Displays the contents of the inventory.
     */
    public void displayInventoryContents ()
    {
        // Implementation of displaying inventory contents is pending
    }
}
