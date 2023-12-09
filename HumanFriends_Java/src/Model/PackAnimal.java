package Model;

import java.util.Date;

public class PackAnimal extends Animal {

    private Integer maxLoad;

    public PackAnimal(String name, String type, String dateBirth, String commands, Integer maxLoad) {
        super(name, type, dateBirth, commands);
        this.maxLoad = maxLoad;
    }

    public PackAnimal() {
    }

    @Override
    public String toString() {
//        return "Pack Animal [name = " + name + ", Type = " + type + ", Date of birth = " + dateBirth + ", Commands = " + commands + "]";
        return "" + name + "\t\t" + dateBirth + "\t\t" + commands;

    }

    @Override
    public String toStringWithType() {
        String res = "";
        res += "" + name + "\t\t";
        if (name.length() < 5) res += "\t";
        res += type + "\t\t";
        if (type.length() < 5) res += "\t";
        res += dateBirth + "\t\t" + commands;

        return res;
    }

    public Integer getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(Integer needWalkPerDayNum) {
        this.maxLoad = needWalkPerDayNum;
    }
}