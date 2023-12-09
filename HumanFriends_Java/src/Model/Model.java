package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @param <T> type of animal, which can be included into Register
 * @apiNote class Model to maintain the Register of animals
 * @see Model#Model
 */
public class Model<T extends Animal> {
    private ArrayList<Dog> dogs = new ArrayList<Dog>();
    private ArrayList<Cat> cats = new ArrayList<Cat>();
    private ArrayList<Hamster> hamsters = new ArrayList<Hamster>();
    private ArrayList<Horse> horses = new ArrayList<Horse>();
    private ArrayList<Camel> camels = new ArrayList<Camel>();
    private ArrayList<Donkey> donkeys = new ArrayList<Donkey>();
    private ArrayList<String> animalTypes = new ArrayList<>();

    public Counter counter;


    /**
     * @param dogs     list of dogs in the Register
     * @param cats     list of cats in the Register
     * @param hamsters list of hamsters in the Register
     * @param horses   list of horses in the Register
     * @param camels   list of camels in the Register
     * @param donkeys  list of donkeys in the Register
     * @apiNote constructor of the Model implying the data are input manually
     */
    public Model(ArrayList<Dog> dogs, ArrayList<Cat> cats, ArrayList<Hamster> hamsters,
                 ArrayList<Horse> horses, ArrayList<Camel> camels, ArrayList<Donkey> donkeys) {
        this.dogs = dogs;
        this.cats = cats;
        this.hamsters = hamsters;
        this.horses = horses;
        this.camels = camels;
        this.donkeys = donkeys;

        counter = new Counter(countAllAnimals());

    }

    // load animals from file

    /**
     * @param dogs     list of dogs in the Register
     * @param cats     list of cats in the Register
     * @param hamsters list of hamsters in the Register
     * @param horses   list of horses in the Register
     * @param camels   list of camels in the Register
     * @param donkeys  list of donkeys in the Register
     * @param fileName name of the file with initial Register (list of animals)
     * @apiNote constructor of the Model implying the data are loaded from a file
     */
    public Model(ArrayList<Dog> dogs, ArrayList<Cat> cats, ArrayList<Hamster> hamsters, ArrayList<Horse> horses,
                 ArrayList<Camel> camels, ArrayList<Donkey> donkeys, String fileName) {

        this.dogs = dogs;
        this.cats = cats;
        this.hamsters = hamsters;
        this.horses = horses;
        this.camels = camels;
        this.donkeys = donkeys;

        counter = new Counter(countAllAnimals());

        inputAnimalsFromFile(fileName);
    }

    /**
     * @param toPrint          list of the animals to print
     * @param message          message to display before the list printed
     * @param fields           string of data fields to output
     * @param emptyListMessage message to print in case of empty list
     * @param isAddType        flag if animal type must be printed
     * @param isAddCommands    flag if animal commands must be printed
     * @param itemToPrint      consequent listing number of animal to print, if the value exceeds the list size => print all
     * @return true if the routine has been performed as intended
     * @apiNote method to print animal(s) of particular type
     * @see Model#printAnimalsByType(ArrayList, String, String, String, boolean, boolean, int)
     */
    public boolean printAnimalsByType(ArrayList<T> toPrint, String message, String fields, String emptyListMessage, boolean isAddType, boolean isAddCommands, int itemToPrint) {

        if (toPrint.size() == 0) {
            System.out.println(emptyListMessage.toUpperCase());
            return false;
        } else {
            boolean isPrintOneItem = false;

            if (itemToPrint > 0 && itemToPrint <= toPrint.size()) isPrintOneItem = true;

            String animalType = toPrint.get(0).getClass().getSimpleName();
            animalType = animalType.substring(0, 1).toUpperCase() + animalType.substring(1).toLowerCase();
            if (message.length() > 0) System.out.println("\n" + message + animalType);
            if (fields.length() > 0) System.out.println(fields);
            int cnt = 0;
            for (T item : toPrint) {
                cnt++;
                if (!isPrintOneItem || cnt == itemToPrint)
                    System.out.println(cnt + ".\t\t" + item.toStringSelect(isAddType, isAddCommands));
            }
            return true;
        }
    }

    /**
     * @param message       message to print before the main output
     * @param cap           header of the list
     * @param numberOfTypes number of types in the Register
     * @param isAddType     flag to print animal type too
     * @param isAddCommands flag to print commands for every animal
     * @return true if the routine has been performed as intended
     * @apiNote method to print all animals of the Register
     * @see Model#printAllAnimals(String, String, Integer, boolean, boolean)
     */
    public boolean printAllAnimals(String message, String cap, Integer numberOfTypes, boolean isAddType, boolean isAddCommands) {
        String res = "\n";
        int cnt = 0;
        for (int i = 0; i < numberOfTypes; i++) {
            switch (i) {
                case 0:
                    if (dogs.size() == 0) {
                        break;
                    } else {
                        for (Dog item : dogs) {
                            cnt++;
                            res += (cnt + "\t\t" + item.toStringSelect(isAddType, isAddCommands) + "\n");
                        }
                    }
                    break;
                case 1:
                    if (cats.size() == 0) {
                        break;
                    } else {
                        for (Cat item : cats) {
                            cnt++;
                            res += (cnt + "\t\t" + item.toStringSelect(isAddType, isAddCommands) + "\n");
                        }
                    }

                    break;
                case 2:
                    if (hamsters.size() == 0) {
                        break;
                    } else {
                        for (Hamster item : hamsters) {
                            cnt++;
                            res += (cnt + "\t\t" + item.toStringSelect(isAddType, isAddCommands) + "\n");
                        }
                    }
                    break;
                case 3:
                    if (horses.size() == 0) {
                        break;
                    } else {
                        for (Horse item : horses) {
                            cnt++;
                            res += (cnt + "\t\t" + item.toStringSelect(isAddType, isAddCommands) + "\n");
                        }
                    }
                    break;
                case 4:
                    if (camels.size() == 0) {
                        break;
                    } else {
                        for (Camel item : camels) {
                            cnt++;
                            res += (cnt + "\t\t" + item.toStringSelect(isAddType, isAddCommands) + "\n");
                        }
                    }
                    break;
                case 5:
                    if (donkeys.size() == 0) {
                        break;
                    } else {
                        for (Donkey item : donkeys) {
                            cnt++;
                            res += (cnt + "\t\t" + item.toStringSelect(isAddType, isAddCommands) + "\n");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (res.length() < 10) return false;
        System.out.println(message + cap + res);
        return true;
    }


    /**
     * @param newAnimal animal of generic type
     * @apiNote method to add new animal to corresponding type list
     * @see Model#addAnimal(T)
     */
    public void addAnimal(T newAnimal) {

        if (newAnimal == null) return;

        String tp = newAnimal.getClass().getSimpleName().toLowerCase();
        switch (tp) {
            case "dog":
                dogs.add((Dog) newAnimal);
                break;
            case "cat":
                cats.add((Cat) newAnimal);
                break;
            case "hamster":
                hamsters.add((Hamster) newAnimal);
                break;
            case "horse":
                horses.add((Horse) newAnimal);
                break;
            case "camel":
                camels.add((Camel) newAnimal);
                break;
            case "donkey":
                donkeys.add((Donkey) newAnimal);
                break;
            default:
                break;
        }
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public ArrayList<Hamster> getHamsters() {
        return hamsters;
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public ArrayList<Camel> getCamels() {
        return camels;
    }

    public ArrayList<Donkey> getDonkeys() {
        return donkeys;
    }

    /**
     * @return total number of animals of all types in the Register
     * @apiNote method to count all animals in the Register
     * @see Model#countAllAnimals()
     */
    public Integer countAllAnimals() {
        return dogs.size() + cats.size() + hamsters.size() + horses.size() + camels.size() + donkeys.size();
    }

    /**
     * @param str string to check
     * @return boolean if the date format is correct
     * @apiNote method to check if input string complies with required date YYYY-MM-DD format
     * (including value ranges for year, month and date)
     * @see Model#isStandardDateFormat(String)
     */
    public boolean isStandardDateFormat(String str) {

        if (str.length() != 10) return false;
        if (!str.contains("-")) return false;

        int yr = parseIntegerFromString(str.substring(0, 4), 0);
        if (yr < 1900 || yr > 2021) return false;
        int mth = parseIntegerFromString(str.substring(5, 7), 0);
        if (mth < 1 || mth > 12) return false;
        int day = parseIntegerFromString(str.substring(8, 10), 0);
        if (day < 1 || day > 31) return false;

        if (str.charAt(4) != '-' || str.charAt(7) != '-') return false;

        return true;
    }

    /**
     * @param newCommand the command to add
     * @param className  name of the animal's type (class)
     * @param index      index for the animal in its type list (normally, next to the size of the list)
     * @return true if the routine has been performed as intended
     * @apiNote routine to update commands for particular animal
     * @see Model#updateCommands(String, String, int)
     */
    public boolean updateCommands(String newCommand, String className, int index) {

        String tp = className.toLowerCase();
        String commands = "";
        boolean res = false;
        switch (tp) {
            case "dog":
                commands = dogs.get(index).getCommands();
                if (commands.length() < 1) {
                    dogs.get(index).setCommands(newCommand);
                    return true;
                } else {
                    if (!commands.toLowerCase().contains(newCommand.toLowerCase())) {
                        dogs.get(index).setCommands(commands + ", " + newCommand);
                        return true;
                    }
                }
                break;
            case "cat":
                commands = cats.get(index).getCommands();
                if (commands.length() < 1) {
                    cats.get(index).setCommands(newCommand);
                    return true;
                } else {
                    if (!commands.toLowerCase().contains(newCommand.toLowerCase())) {
                        cats.get(index).setCommands(commands + ", " + newCommand);
                        return true;
                    }
                }
                break;
            case "hamster":
                commands = hamsters.get(index).getCommands();
                if (commands.length() < 1) {
                    hamsters.get(index).setCommands(newCommand);
                    return true;
                } else {
                    if (!commands.toLowerCase().contains(newCommand.toLowerCase())) {
                        hamsters.get(index).setCommands(commands + ", " + newCommand);
                        return true;
                    }
                }
                break;
            case "horse":
                commands = horses.get(index).getCommands();
                if (commands.length() < 1) {
                    horses.get(index).setCommands(newCommand);
                    return true;
                } else {
                    if (!commands.toLowerCase().contains(newCommand.toLowerCase())) {
                        horses.get(index).setCommands(commands + ", " + newCommand);
                        return true;
                    }
                }
                break;
            case "camel":
                commands = camels.get(index).getCommands();
                if (commands.length() < 1) {
                    camels.get(index).setCommands(newCommand);
                    return true;
                } else {
                    if (!commands.toLowerCase().contains(newCommand.toLowerCase())) {
                        camels.get(index).setCommands(commands + ", " + newCommand);
                        return true;
                    }
                }
                break;
            case "donkey":
                commands = donkeys.get(index).getCommands();
                if (commands.length() < 1) {
                    donkeys.get(index).setCommands(newCommand);
                    return true;
                } else {
                    if (!commands.toLowerCase().contains(newCommand.toLowerCase())) {
                        donkeys.get(index).setCommands(commands + ", " + newCommand);
                        return true;
                    }
                }
                break;
            default:
                break;
        }
        return false;
    }


    /**
     * @param fileName name of the file to load
     * @apiNote method to load initial animals data from file and allocate it into corresponding types lists
     * @see Model#inputAnimalsFromFile(String)
     */
    public void inputAnimalsFromFile(String fileName) {

        boolean isNewAnimal;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] animal = line.replace("\"", "").split(";");
                isNewAnimal = true;
                switch (animal[1].toLowerCase()) {
                    case "dog":
                        dogs.add(new Dog(animal[0], animal[1], animal[2], animal[3], parseIntegerFromString(animal[4], 0)));
                        break;
                    case "cat":
                        cats.add(new Cat(animal[0], animal[1], animal[2], animal[3], parseIntegerFromString(animal[4], 0)));
                        break;
                    case "hamster":
                        hamsters.add(new Hamster(animal[0], animal[1], animal[2], animal[3], parseIntegerFromString(animal[4], 0)));
                        break;
                    case "horse":
                        horses.add(new Horse(animal[0], animal[1], animal[2], animal[3], parseIntegerFromString(animal[4], 0)));
                        break;
                    case "camel":
                        camels.add(new Camel(animal[0], animal[1], animal[2], animal[3], parseIntegerFromString(animal[4], 0)));
                        break;
                    case "donkey":
                        donkeys.add(new Donkey(animal[0], animal[1], animal[2], animal[3], parseIntegerFromString(animal[4], 0)));
                        break;
                    default:
                        isNewAnimal = false;
                        break;

                }
                counter.add();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param text      string to parse
     * @param byDefault a value that should be returned if parsing had failed
     * @return int value (by input string or by default)
     * @apiNote method to parse String into integer value, if failed - by default value is used instead
     * @see Model#parseIntegerFromString(String, int)
     */
    private Integer parseIntegerFromString(String text, int byDefault) {
        try {
            return Integer.parseInt(text);

        } catch (Exception e) {
            return byDefault;
        }
    }


}
