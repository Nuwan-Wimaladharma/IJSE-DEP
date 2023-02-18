package lk.ijse.dep10.exercise.app.model;

import java.util.ArrayList;

public class Student {
    public String id;
    public String name;
    public ArrayList contactNumbers;
    public ArrayList allModules;
    public ArrayList selectedModules;

    public Student(String id, String name, ArrayList contactNumbers, ArrayList allModules, ArrayList selectedModules) {
        this.id = id;
        this.name = name;
        this.contactNumbers = contactNumbers;
        this.allModules = allModules;
        this.selectedModules = selectedModules;
    }

    @Override
    public String toString(){
        return id + "   " + name + "    " + contactNumbers + "      " + selectedModules;
    }
}
