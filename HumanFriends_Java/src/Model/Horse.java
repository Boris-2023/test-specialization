package Model;

/**
 * Class Horse extending PackAnimal; bears data on the animal as name, type, birthdate, commands
 * the animal can execute and max load available to the animal
 */
public class Horse extends PackAnimal{

    /**
     * @apiNote basic constructor for class Horse
     * @param name      name of the animal
     * @param type      type of the animal
     * @param dateBirth birthdate of the animal
     * @param commands  commands, which the animal can execute
     * @param maxLoad max load the animal can bear
     */
    public Horse(String name, String type, String dateBirth, String commands, Integer maxLoad) {
        super(name, type, dateBirth, commands, maxLoad);
    }

    /**
     * Creating an empty instance
     */
    public Horse() {

    }

}
