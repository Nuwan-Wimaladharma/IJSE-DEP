package lk.ijse.dep10.oop;

import java.util.ArrayList;

public class AggregationDemo {
    public static void main(String[] args) {
        ArrayList<Program2> prgramList = new ArrayList<>();
        prgramList.add(new Program2("DEP", "5 months"));
        prgramList.add(new Program2("CMJD", "6 months"));
        prgramList.add(new Program2("GDSE", "2 years"));

        Institute2 ijse = new Institute2(prgramList);
        System.out.println(ijse.programList.get(0).name);

        ijse = null;

        System.out.println(prgramList.get(0).name); //even if instance of Institute2 is null, can access to Program2, this is called aggregation
    }
}
class Institute2{
    ArrayList<Program2> programList;
    public Institute2(ArrayList<Program2> programList){
        this.programList = programList;
    }
}
class Program2{
    String name;
    String duration;

    public Program2(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
