package lk.ijse.dep10.app.model;

import javafx.scene.control.SingleSelectionModel;
import lk.ijse.dep10.app.util.Gender;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private Gender gender;
    private ArrayList contacts;
    private String degree;
    private ArrayList allModules;
    private ArrayList modules;
    private String partTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList contacts) {
        this.contacts = contacts;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ArrayList getAllModules() {
        return allModules;
    }

    public void setAllModules(ArrayList allModules) {
        this.allModules = allModules;
    }

    public ArrayList getModules() {
        return modules;
    }

    public void setModules(ArrayList modules) {
        this.modules = modules;
    }

    public String getPartTime() {
        return partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public Student() {
    }

    public Student(String id, String name, Gender gender, ArrayList contacts, String degree, ArrayList allModules, ArrayList modules, String partTime) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contacts = contacts;
        this.degree = degree;
        this.allModules = allModules;
        this.modules = modules;
        this.partTime = partTime;
    }
}
