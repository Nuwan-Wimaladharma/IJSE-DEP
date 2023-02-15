package lk.ijse.dep10.exercise.app.model;

import java.util.ArrayList;

public class Student {
    String id;
    String name;
    ArrayList contactNumbers = new ArrayList<>();
    ArrayList selectedModules = new ArrayList<>();

    public Student(String id, String name, ArrayList contactNumbers, ArrayList selectedModules) {
        this.id = id;
        this.name = name;
        this.contactNumbers = contactNumbers;
        this.selectedModules = selectedModules;
    }
}
