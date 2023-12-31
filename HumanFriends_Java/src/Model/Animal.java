package Model;

public abstract class Animal {

    protected String name;
    protected String type;
    protected String dateBirth;
    protected String commands;

    /**
     * @param name      name of the animal
     * @param type      type of the animal
     * @param dateBirth birthdate of the animal
     * @param commands  commands, which the animal can execute
     * @apiNote full constructor for abstract basic class
     */
    public Animal(String name, String type, String dateBirth, String commands) {
        this.name = name;
        this.type = type;
        this.dateBirth = dateBirth;
        this.commands = commands;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public void addCommand(String newCommand) {
        newCommand = newCommand.substring(0, 1).toUpperCase() + newCommand.substring(1).toLowerCase();
        if (commands.length() < 1) {
            commands = newCommand;
        } else {
            commands += ", " + newCommand;
        }
    }

    public String toString() {
        return "Animal [name = " + name + ", Date of birth = " + dateBirth + ", Commands = " + commands + "]";
    }

    public String toStringWithType() {
        return "Animal [name = " + name + ", Type = " + type + ", Date of birth = " + dateBirth + ", Commands = " + commands + "]";
    }

    /**
     * animal data string formation with options to include Type and Commands by flags
     * @param isAddType if adding type of the animal
     * @param isAddCommands if adding commands for the animal
     * @return string ready to be printed
     * @see Animal#toStringSelect(boolean, boolean) 
     */
    public String toStringSelect(boolean isAddType, boolean isAddCommands) {
        String res = "";
        res += name + "\t\t";
        if (name.length() < 4) res += "\t";
        if (isAddType) {
            res += type + "\t\t";
            if (type.length() < 4) res += "\t";
        }
        res += dateBirth;
        if (isAddCommands) {
            res += "\t\t" + commands;
        }
        return res;
    }
}
