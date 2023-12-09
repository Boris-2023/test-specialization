package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Animal;

public class ViewRus<T extends Animal> {

    private List<String> menu = new ArrayList<>();


    /**
     * @apiNote View constructor - initializing main menu
     */
    public ViewRus() {
        menu.add("Завести новое животное");
        menu.add("Показать список команд, которое выполняет животное");
        menu.add("Обучить животное новой команде");
        menu.add("Показать список животных по типу");
        menu.add("Показать общий список животных");
        menu.add("Выход");
    }

    /**
     * @return String line of pseudo-graphic chars
     * @apiNote Standart solid line separator (doubled line)
     */
    public String lineSep() {
        return "\n═══════════════════════════════════════════════════════════";
    }

    /**
     * @return the number of items in the menu
     * @apiNote printing main menu into console with consequent numbering of its
     * items
     */
    public int printMenu(Integer totalNumberOfAnimals) {
        String res = "\nГЛАВНОЕ МЕНЮ:";
        int cnt = 0;
        if (menu != null) {
            for (String item : menu) {
                cnt++;
                res = res + "\n" + cnt + ". " + item;
                if (item.contains("общий список")) res += (" (всего " + totalNumberOfAnimals + " животных)");
            }
            res += lineSep();
            System.out.println(res);
        } else {
            System.out.println("Главное меню не загружено!");
        }

        return cnt;
    }

    /**
     * @return the number of items in Animal Types' menu
     * @apiNote printing Animal Types' menu into console with consequent numbering of its
     * items
     */
    public int printTypeMenu() {
        ArrayList<String> types = getAnimalTypeNames();
        types.add("Выход в главное меню");
        String res = "\nМЕНЮ ТИПОВ ЖИВОТНЫХ:";
        int cnt = 0;
        if (types != null) {
            for (String item : types) {
                cnt++;
                res = res + "\n" + cnt + ". " + item;
            }
            res += lineSep();
            System.out.println(res);
        } else {
            System.out.println("Меню типов животных не загружено!");
        }

        return cnt;
    }

    /**
     * method to prompt input from user by invitation
     *
     * @param msg message to print inviting user
     * @see ViewRus#prompt(String)
     */
    public String prompt(String msg) {
        Scanner iScan = new Scanner(System.in);
        System.out.print(msg);
        return iScan.nextLine();
    }

    /**
     * method to return invitation message on menu choice
     *
     * @see ViewRus#msgOnInvite()
     */
    public String msgOnInvite() {
        return "Введите номер пункта из меню для выбора: ";
    }

    /**
     * method to return a message on bad command (on the menu)
     *
     * @see ViewRus#msgOnBadCommand()
     */
    public String msgOnBadCommand() {
        return "Такого пункта в меню нет!";
    }

    /**
     * @apiNote method to return a message on empty list
     *
     * @see ViewRus#msgOnEmptyListForType()
     */
    public String msgOnEmptyListForType() {
        return "\nСписок животных этого типа пуст!".toUpperCase();
    }

    /**
     * @apiNote method to return a message on adding new animal to selected type
     * @see ViewRus#msgOnAddingNewAnimal(String)
     * @param type - animal's type
     */
    public String msgOnAddingNewAnimal(String type) {
        return "\nДобавление нового животного в тип: ".toUpperCase() + type.substring(0, 1).toUpperCase()
                + type.substring(1).toLowerCase();
    }

    /**
     * @apiNote method to return messages for adding new animal to the list
     * (requesting for Name, Birthdate and Commands)
     * @param field number of the field is being completed
     * @see ViewRus#msgOnAddingNewAnimal(int)
     */
    public String msgOnAddingNewAnimal(int field) {
        String res = "";
        switch (field) {
            case 0:
                res = "Укажите имя нового животного: ";
                break;
            case 1:
                res = "Укажите дату рождения животного (формат ГГГГ-ММ-ДД): ";
                break;
            case 2:
                res = "Перечислите команды, которые умеет выполнять животное (через запятую): ";
                break;
            default:
                return null;

        }
        return res;
    }

     /**
     * @apiNote method to return a message on an empty input
     * @see ViewRus#msgOnEmptyInput()
     */
    public String msgOnEmptyInput() {
        return "Значение не введено!";
    }

     /**
     * @apiNote method to return a message on new toy added successfully
      * @param toPrint add string - normally name of the animal type
     * @see ViewRus#msgOnNewAnimalAdded(String)
     */
    public String msgOnNewAnimalAdded(String toPrint) {
        return "\nДобавлено новое животное: ".toUpperCase() + "\n" + printFieldsWithTypeCommands() + "\n" + toPrint;
    }
    /**
     * @apiNote method to return a message on wrong Date format
     * @see ViewRus#msgOnWrongDateFormat()
     */
    public String msgOnWrongDateFormat() {
        return "Неверный формат даты!";
    }

    /**
     * @apiNote method to return an invitation on new command input
     * @see ViewRus#msgOnNewCommand()
     */
    public String msgOnNewCommand() {
        return "Введите новую команду или несколько (через запятую): ";
    }

    /**
     * @apiNote method to confirm a successful commands modification
     * @see ViewRus#msgOnCommandChanged()
     */
    public String msgOnCommandChanged() {
        return "Список команд успешно обновлен, тип: ".toUpperCase();
    }

    /**
     * @apiNote method to return a message on commands executing by an animal
     * @param name name of the animal related
     * @see ViewRus#msgOnCommandChanged()
     */
    public String msgOnShowCommands(String name) {
        return "\nКоманды, выполняемые животным '".toUpperCase() + name + "': ";
    }


    /**
     * @apiNote method to return a message on exit out of the program
     * @see ViewRus#msgOnExit()
     */
    public String msgOnExit() {
        return "\nВыход из приложения...";
    }

    /**
     * @apiNote method to return a message on listing the animals of type
     * @see ViewRus#msgOnPrintAnimalsByType()
     */
    public String msgOnPrintAnimalsByType() {
        return "Список животных, тип: ".toUpperCase();
    }

    /**
     * @apiNote method to return a message on listing all animals in the register
     * @see ViewRus#msgOnPrintAllAnimals()
     */
    public String msgOnPrintAllAnimals() {
        return "\nСписок всех животных в реестре: \n".toUpperCase();
    }

    /**
     * @apiNote method to print basic fields
     * @see ViewRus#printFields()
     */
    public String printFields() {
        String flds = "id\t\tИмя  \t\tДата рождения";
        flds += lineSep();

        return flds;
    }

    /**
     * @apiNote method to print basic fields + Commands
     * @see ViewRus#printFieldsCommands()
     */
    public String printFieldsCommands() {
        String flds = "id\t\tИмя  \t\tДата рождения\tКоманды";
        flds += lineSep();

        return flds;
    }

    /**
     * @apiNote method to print basic fields + Type + Commands
     * @see ViewRus#printFieldsWithTypeCommands()
     */
    public String printFieldsWithTypeCommands() {
        String flds = "id\t\tИмя  \t\tТип  \t\tДата рождения\tКоманды";
        flds += lineSep();

        return flds;
    }

    /**
     * @apiNote method to form a list of animal types in the Register
     * @see ViewRus#getAnimalTypeNames()
     */
    public ArrayList<String> getAnimalTypeNames() {
        ArrayList<String> types = new ArrayList<>();

        types.add("Собака (Dog)");
        types.add("Кошка (Cat)");
        types.add("Хомяк (Hamster)");
        types.add("Лошадь (Horse)");
        types.add("Верблюд (Camel)");
        types.add("Осёл (Donkey)");

        return types;
    }

}
