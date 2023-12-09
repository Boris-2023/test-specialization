package Model;

import java.util.Date;

public class Pet extends Animal {

    private Integer needWalkPerDayNum;

    public Pet(String name, String type, String dateBirth, String commands, Integer needWalkPerDayNum) {
        super(name, type, dateBirth, commands);
        this.needWalkPerDayNum = needWalkPerDayNum;
    }
    public Pet() {
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

    public Integer getNeedWalkPerDayNum() {
        return needWalkPerDayNum;
    }

    public void setNeedWalkPerDayNum(Integer needWalkPerDayNum) {
        this.needWalkPerDayNum = needWalkPerDayNum;
    }
}

