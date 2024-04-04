public class JobClass {

    private String name;
    private int healthPoint;
    private int dexterity;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;
    private int level;

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


    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStrength() {
        return strength;
    }

    public int getFaith() {
        return faith;
    }

    public int getLevel() {
        return level;
    }

}
