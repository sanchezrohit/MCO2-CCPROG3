/**
 * The JobClass class represents a job class in the game,
 * defining attributes such as name, health points, dexterity, intelligence, endurance, strength, faith, and level.
 */
public class JobClass {

    private String name;
    private int healthPoint;
    private int dexterity;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;
    private int level;

    /**
     * Constructs a new JobClass object with the specified attributes.
     *
     * @param name         the name of the job class
     * @param healthPoints the health points of the job class
     * @param dexterity    the dexterity of the job class
     * @param intelligence the intelligence of the job class
     * @param endurance    the endurance of the job class
     * @param strength     the strength of the job class
     * @param faith        the faith of the job class
     * @param level        the level of the job class
     */
    public JobClass (String name, int healthPoints, int dexterity, int intelligence, int endurance, int strength, int faith, int level)
    {
        this.name = name;
        this.healthPoint = healthPoints;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.strength = strength;
        this.faith = faith;
        this.level = level;
    }


    /**
     * Gets the name of the job class.
     *
     * @return the name of the job class
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the health points of the job class.
     *
     * @return the health points of the job class
     */
    public int getHealthPoint() {
        return healthPoint;
    }

    /**
     * Gets the dexterity of the job class.
     *
     * @return the dexterity of the job class
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Gets the intelligence of the job class.
     *
     * @return the intelligence of the job class
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Gets the endurance of the job class.
     *
     * @return the endurance of the job class
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Gets the strength of the job class.
     *
     * @return the strength of the job class
     */
    public int getStrength() {
        return strength;
    }


    /**
     * Gets the faith of the job class.
     *
     * @return the faith of the job class
     */
    public int getFaith() {
        return faith;
    }

    /**
     * Gets the level of the job class.
     *
     * @return the level of the job class
     */
    public int getLevel() {
        return level;
    }

}
