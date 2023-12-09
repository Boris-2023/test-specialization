package Model;

/**
 * Class Cat extending Pet; bears data on the animal as name, type, birthdate, commands
 * the animal can execute and number of times a day the animal must be walked
 */
public class Cat extends Pet {

    /**
     * @apiNote basic constructor for class Cat
     * @param name      name of the animal
     * @param type      type of the animal
     * @param dateBirth birthdate of the animal
     * @param commands  commands, which the animal can execute
     * @param needWalkPerDayNum number of times a day the animal must be walked
     */
    public Cat(String name, String type, String dateBirth, String commands, Integer needWalkPerDayNum) {
        super(name, type, dateBirth, commands, needWalkPerDayNum);
    }

    /**
     * Creating an empty instance
     */
    public Cat() {

    }

}