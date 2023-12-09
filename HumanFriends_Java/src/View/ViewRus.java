package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Animal;

public class ViewRus<T extends Animal> {

    private List<String> menu = new ArrayList<>();

    public ViewRus() {
        menu.add("Завести новое животное");
        menu.add("Показать список команд, которое выполняет животное");
        menu.add("Обучить животное новой команде");
        menu.add("Показать список животных по типу");
        menu.add("Показать общий список животных");
        menu.add("Выход");


    }

    public String lineSep() {
        return "\n═══════════════════════════════════════════════════════════";
    }

    /**
     * @return the number of items in the menu - for future checking of user's input
     * choice
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
     * @return the number of items in the menu - for future checking of user's input
     * choice
     * @apiNote printing main menu into console with consequent numbering of its
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
     * method to prompt Integer (in range) from user by invitation
     *
     * @param msg - message to print, invite user
     * @see ViewRus#prompt(String)
     */
    public String prompt(String msg) {
        Scanner iScan = new Scanner(System.in);
        System.out.print(msg);
        return iScan.nextLine();
    }

    /**
     * method to return Russian invitation message
     *
     * @see ViewRus#msgOnInvite()
     */
    public String msgOnInvite() {
        return "Введите номер пункта из меню для выбора: ";
    }

    /**
     * method to return Russian message on bad command
     *
     * @see ViewRus#msgOnBadCommand()
     */
    public String msgOnBadCommand() {
        return "Такого пункта в меню нет!";
    }

    /**
     * method to return Russian message on empty list
     *
     * @see ViewRus#msgOnEmptyListForType()
     */
    public String msgOnEmptyListForType() {
        return "\nСписок животных этого типа пуст!".toUpperCase();
    }

    /**
     * @apiNote method to return Russian message on adding new animal to selected type
     * @see ViewRus#msgOnAddingNewAnimal(String)
     */
    public String msgOnAddingNewAnimal(String type) {
        return "\nДобавление нового животного в тип: ".toUpperCase() + type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
    }

    /**
     * @apiNote method to return Russian messages for adding new toy to the list for
     * draws (request for ID, Name, Qty & probability wheight)
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
     * @apiNote method to return Russian message on the input that is not a number
     * @see ViewRus#msgOnNotANumber()
     */

    /**
     * @apiNote method to return Russian message on the empty input
     * @see ViewRus#msgOnEmptyInput()
     */
    public String msgOnEmptyInput() {
        return "\nЗначение не введено!";
    }

    /**
     * @apiNote method to return Russian message on the need positive number only
     * @see ViewRus#msgOnNeedPositiveNumber()
     */
    public String msgOnNeedPositiveNumber() {
        return "\nВведенное значение должно быть больше нуля!";
    }

    /**
     * @apiNote method to return Russian message on the need a number whithin the
     * range of input
     * @see ViewRus#msgOnNeedNumberInRange(int, int)
     */
    public String msgOnNeedNumberInRange(int min, int max) {
        return "\nВведенное значение должно быть в диапазоне от " + min + " до " + max + "!";
    }

    /**
     * @apiNote method to return Russian message on new toy added successfully
     * @see ViewRus#msgOnNeedPositiveNumber()
     */
    public String msgOnNewAnimalAdded(String toPrint) {
        return "\nДобавлено новое животное: ".toUpperCase() + "\n" + printFieldsWithTypeCommands() + "\n" + toPrint;
    }

    public String msgOnWrongDateFormat() {
        return "Неверный формат даты!";
    }

    public String msgOnNewCommand() {
        return "Введите новую команду или несколько (через запятую): ";
    }

    public String msgOnCommandChanged() {
        return "Список команд успешно обновлен, тип: ".toUpperCase();
    }

    public String msgOnShowCommands(String name) {
        return "\nКоманды, выполняемые животным '".toUpperCase() + name + "': ";
    }


    /**
     * @apiNote method to return Russian message on exit out of the program
     * @see ViewRus#msgOnExit()
     */
    public String msgOnExit() {
        return "\nВыход из приложения...";
    }

    public String msgOnPrintAnimalsByType() {
        return "Список животных, тип: ".toUpperCase();
    }

    public String msgOnPrintAllAnimals() {
        return "\nСписок всех животных в реестре: \n".toUpperCase();
    }

    public String printFields() {
        String flds = "id\t\tИмя  \t\tДата рождения";
        flds += lineSep();

        return flds;
    }

    public String printFieldsCommands() {
        String flds = "id\t\tИмя  \t\tДата рождения\tКоманды";
        flds += lineSep();

        return flds;
    }

    public String printFieldsWithTypeCommands() {
        String flds = "id\t\tИмя  \t\tТип  \t\tДата рождения\tКоманды";
        flds += lineSep();

        return flds;
    }

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
