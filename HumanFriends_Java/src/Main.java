import Controller.*;
import Model.*;
import View.ViewRus;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        String animalsListFileName = "animals.csv";

        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Hamster> hamsters = new ArrayList<>();
        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Camel> camels = new ArrayList<>();
        ArrayList<Donkey> donkeys = new ArrayList<>();

        Model model = new Model(dogs, cats, hamsters, horses, camels, donkeys, animalsListFileName);
        ViewRus viewRus = new ViewRus();

        Controller control = new Controller(model, viewRus);

        control.run();
    }
}
