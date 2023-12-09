package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;

/**
 * @param <T> type of animal, which can be included into Register
 * @apiNote class Controller to maintain the Register of animals
 * @see Controller#Controller
 */
public class Controller<T extends Animal> {
    private Model model;
    private ViewRus viewRus;

    public Controller(Model model, ViewRus viewRus) {
        this.model = model;
        this.viewRus = viewRus;

    }

    /**
     * @apiNote basic method to operate main menu and folded sub-menus
     * @see Controller#run()
     */
    public void run() {

        int chosenType = 0;
        int chosenAnimal = 0;
        boolean getNewIteration = true;
        String str = "";

        while (getNewIteration) {

            int chosen = getGoodCommand(viewRus.printMenu(model.counter.getCounter()));

            switch (chosen) {

                // add new animal
                case 1:
                    chosenType = getGoodCommand(viewRus.printTypeMenu());
                    if (chosenType <= viewRus.getAnimalTypeNames().size()) {
                        switch (chosenType) {
                            case 1:
                                model.addAnimal(addAnimalRoutine((T) new Dog(), model.getDogs().size()));
                                break;
                            case 2:
                                model.addAnimal(addAnimalRoutine((T) new Cat(), model.getCats().size()));
                                break;
                            case 3:
                                model.addAnimal(addAnimalRoutine((T) new Hamster(), model.getHamsters().size()));
                                break;
                            case 4:
                                model.addAnimal(addAnimalRoutine((T) new Horse(), model.getHorses().size()));
                                break;
                            case 5:
                                model.addAnimal(addAnimalRoutine((T) new Camel(), model.getCamels().size()));
                                break;
                            case 6:
                                model.addAnimal(addAnimalRoutine((T) new Donkey(), model.getDonkeys().size()));
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                // display a list of commands the animal can execute
                case 2:
                    chosenType = getGoodCommand(viewRus.printTypeMenu());

                    if (chosenType <= viewRus.getAnimalTypeNames().size()) {
                        switch (chosenType) {
                            case 1:
                                showCommands(model.getDogs(), chosenType);
                                break;
                            case 2:
                                showCommands(model.getCats(), chosenType);
                                break;
                            case 3:
                                showCommands(model.getHamsters(), chosenType);
                                break;
                            case 4:
                                showCommands(model.getHorses(), chosenType);
                                break;
                            case 5:
                                showCommands(model.getCamels(), chosenType);
                                break;
                            case 6:
                                showCommands(model.getDonkeys(), chosenType);
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                // train the animal for new command to execute
                case 3:
                    chosenType = getGoodCommand(viewRus.printTypeMenu());

                    if (chosenType <= viewRus.getAnimalTypeNames().size()) {
                        switch (chosenType) {
                            case 1:
                                modifyCommands(model.getDogs(), chosenType);
                                break;
                            case 2:
                                modifyCommands(model.getCats(), chosenType);
                                break;
                            case 3:
                                modifyCommands(model.getHamsters(), chosenType);
                                break;
                            case 4:
                                modifyCommands(model.getHorses(), chosenType);
                                break;
                            case 5:
                                modifyCommands(model.getCamels(), chosenType);
                                break;
                            case 6:
                                modifyCommands(model.getDonkeys(), chosenType);
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                // show animals by type
                case 4:
                    chosenType = getGoodCommand(viewRus.printTypeMenu());

                    if (chosenType <= viewRus.getAnimalTypeNames().size()) {
                        switch (chosenType) {
                            case 1:
                                model.printAnimalsByType(model.getDogs(), viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                                        viewRus.msgOnEmptyListForType(), false, true, 1000);
                                break;
                            case 2:
                                model.printAnimalsByType(model.getCats(), viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                                        viewRus.msgOnEmptyListForType(), false, true, 1000);
                                break;
                            case 3:
                                model.printAnimalsByType(model.getHamsters(), viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                                        viewRus.msgOnEmptyListForType(), false, true, 1000);
                                break;
                            case 4:
                                model.printAnimalsByType(model.getHorses(), viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                                        viewRus.msgOnEmptyListForType(), false, true, 1000);
                                break;
                            case 5:
                                model.printAnimalsByType(model.getCamels(), viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                                        viewRus.msgOnEmptyListForType(), false, true, 1000);
                                break;
                            case 6:
                                model.printAnimalsByType(model.getDonkeys(), viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                                        viewRus.msgOnEmptyListForType(), false, true, 1000);
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                // displaying full list of animals
                case 5:
                    model.printAllAnimals(viewRus.msgOnPrintAllAnimals(), viewRus.printFieldsWithTypeCommands(),
                            viewRus.getAnimalTypeNames().size(), true, true);
                    break;

                // exit
                case 6:
                    System.out.println(viewRus.msgOnExit().toUpperCase());
                    getNewIteration = false;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * @param animals    list of animals for type, which target animal belongs to
     * @param chosenType number of type in the types sub-menu
     * @apiNote routine for commands modification for particular animal
     * @see Controller#modifyCommands(ArrayList, int)
     */
    private void modifyCommands(ArrayList<T> animals, int chosenType) {

        if (animals.size() == 0) {
            System.out.println(viewRus.msgOnEmptyListForType());
            return;
        }

        int chosenAnimal;
        String str;

        String type = animals.get(0).getClass().getSimpleName();

        model.printAnimalsByType(animals, viewRus.msgOnPrintAnimalsByType(), viewRus.printFieldsCommands(),
                viewRus.msgOnEmptyListForType(), false, true, 1000);
        System.out.println(viewRus.lineSep());
        chosenAnimal = getGoodCommand(animals.size());

        str = "";
        while (str.length() < 1) {
            str = viewRus.prompt(viewRus.msgOnNewCommand());
        }

        while (str.contains("  ")) str = str.replace("  ", " ");

        model.updateCommands(str, type, chosenAnimal - 1);

        model.printAnimalsByType(animals, viewRus.msgOnCommandChanged(), viewRus.printFieldsCommands(),
                viewRus.msgOnEmptyListForType(), false, true, chosenAnimal);
    }

    /**
     * @param animals    list of animals for type, which target animal belongs to
     * @param chosenType number of type in the types sub-menu
     * @apiNote routine for displaying commands for particular animal
     * @see Controller#showCommands(ArrayList, int)
     */
    private void showCommands(ArrayList<T> animals, int chosenType) {

        if (animals.size() == 0) {
            System.out.println(viewRus.msgOnEmptyListForType());
            return;
        }

        int chosenAnimal;
        String str;

        String type = animals.get(0).getClass().getSimpleName();

        model.printAnimalsByType(animals, viewRus.msgOnPrintAnimalsByType(), viewRus.printFields(),
                viewRus.msgOnEmptyListForType(), false, false, 1000);
        System.out.println(viewRus.lineSep());
        chosenAnimal = getGoodCommand(animals.size());

        System.out.println(viewRus.msgOnShowCommands(animals.get(chosenAnimal - 1).getName())
                + animals.get(chosenAnimal - 1).getCommands());

    }

    /**
     * @param animal   empty animal of particular type
     * @param sizeType number of animals in this type (to adjust new index)
     * @return new animal of input type
     * @apiNote routine for adding new animal to particular animals type
     * @see Controller#addAnimalRoutine(T, int)
     */
    private T addAnimalRoutine(T animal, int sizeType) {

        String type = animal.getClass().getSimpleName();

        System.out.println(viewRus.msgOnAddingNewAnimal(type));

        // name, DOB and commands for new animal
        boolean newTry;
        for (int i = 0; i < 3; i++) {
            newTry = true;
            while (newTry) {
                String str = viewRus.prompt(viewRus.msgOnAddingNewAnimal(i));
                if (!str.isEmpty()) {
                    while (str.contains("  ")) str = str.replace("  ", " ");
                    newTry = false;
                    switch (i) {
                        case 0:
                            animal.setName(str);
                            break;
                        case 1:
                            if (model.isStandardDateFormat(str)) {
                                animal.setDateBirth(str);
                            } else {
                                newTry = true;
                                System.out.println(viewRus.msgOnWrongDateFormat());
                            }
                            break;
                        case 2:
                            animal.setCommands(str);
                            break;
                    }
                } else {
                    System.out.println(viewRus.msgOnEmptyInput());
                    return null;
                }
            }
        }
        animal.setType(type);
        model.counter.add();
        System.out.println(viewRus.msgOnNewAnimalAdded((sizeType + 1) + "\t\t" + animal.toStringSelect(true, true)));

        return animal;
    }

    /**
     * @param str - string to check
     * @return boolean if the string can be parsed into integer
     * @apiNote method to check if the input string can be parsed into integer
     */
    private boolean isInteger(String str) {
        boolean isInt;
        try {
            Integer.parseInt(str);
            isInt = true;
        } catch (Exception e) {
            isInt = false;
        }
        return isInt;
    }

    /**
     * @param menuSize - size of Main menu (to verify the input)
     * @return user's choice - command number within Main Menu
     * @apiNote getting from user a number of command until the input is within a
     * range of Main menu
     */
    private int getGoodCommand(int menuSize) {
        int chosen = 0;
        boolean goodCommand = false;
        while (!goodCommand) {
            String inStr = viewRus.prompt(viewRus.msgOnInvite());
            if (isInteger(inStr)) {
                int input = Integer.parseInt(inStr);
                if (input > 0 && input <= menuSize) {
                    chosen = input;
                    goodCommand = true;
                } else {
                    System.out.println(viewRus.msgOnBadCommand());
                }
            } else {
                System.out.println(viewRus.msgOnBadCommand());
            }
        }
        return chosen;
    }

}
