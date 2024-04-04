public class MCharacter {

    private String name;
    private double nRunes = 0.0;
    private int characterLevel;

    private String jobClassName;
    private int healthPoints;
    private int dexterity;
    private int intelligence;
    private int endurance;
    private int strength;
    private int faith;

    public MCharacter ()
    {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
//        if (name != null && !name.isEmpty()) {
//            this.name = name;
//        } else {
//            System.out.println("Invalid name! Name must not be null or empty.");
//        }
        this.name = name;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }
    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public double getnRunes() {
        return nRunes;
    }
    public void setnRunes(double nRunes) {
        this.nRunes = nRunes;
    }

    public int getHealthPoints() {
        return healthPoints;
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

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setFaith(int faith) {
        this.faith = faith;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }


    public String getJobClassName() {
        return jobClassName;
    }
    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String toString() {
        return String.format("%-10s: %s%n%-10s: %s%n%-10s: %d%n%-10s: %d",
                "Name", name,
                "Job Class", jobClassName,
                "Level", characterLevel,
                "Runes", nRunes);
    }



}
