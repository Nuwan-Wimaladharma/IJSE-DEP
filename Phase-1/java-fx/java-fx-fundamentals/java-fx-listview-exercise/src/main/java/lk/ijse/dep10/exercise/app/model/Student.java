package lk.ijse.dep10.exercise.app.model;

import java.util.ArrayList;

public class Student {
    public String id;
    public String name;
    public ArrayList contactNumbers = new ArrayList<>();
    public ArrayList selectedModules = new ArrayList<>();

    public Student(String id, String name, ArrayList contactNumbers, ArrayList selectedModules) {
        this.id = id;
        this.name = name;
        this.contactNumbers = contactNumbers;
        this.selectedModules = selectedModules;
    }

    @Override
    public String toString(){
        return id + "                  " + name;
    }
}
