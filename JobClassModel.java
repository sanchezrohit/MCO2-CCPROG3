/**
 * The JobClassModel class represents a model for storing and managing job classes in the game.
 */
import java.util.ArrayList;

public class JobClassModel {

    private ArrayList<JobClass> jobClasses = new ArrayList<>();

    /**
     * Constructs a new JobClassModel object and initializes job classes.
     */
    public JobClassModel ()
    {
         JobClass vagabond = new JobClass("Vagabond", 15, 13, 9, 11, 14,9, 9);
         JobClass samurai = new JobClass("Samurai", 12,15,9,13,12,8,9);
         JobClass warrior = new JobClass("Warrior",11,16,10,11,10,8,8);
         JobClass hero = new JobClass("Hero", 14,9,7,12,16,8,7);
         JobClass astrologer = new JobClass("Astrologer", 9,12,16,9,8,7,6);
         JobClass prophet = new JobClass("Prophet", 10,10,7,8,11,16,7);

        jobClasses.add(vagabond);
        jobClasses.add(samurai);
        jobClasses.add(warrior);
        jobClasses.add(hero);
        jobClasses.add(astrologer);
        jobClasses.add(prophet);

        /*
         * 0 Vagabond
         * 1 Samurai
         * 2 Warrior
         * 3 Hero
         * 4 Astrologer
         * 5 Prophet
         */
    }


    /**
     * Returns the list of job classes.
     *
     * @return the list of job classes
     */
    public ArrayList<JobClass> returnJobClasses ()
    {
        return this.jobClasses;
    }

}
