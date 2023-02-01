package lk.ijse.dep10.oop.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        Student s001;
        System.out.println(s001 = new Student(1, "Kasun","077-2256458")); //new Student + Student(1, "Kasun","077-2256458");
        Student s002 = new Student();
        s002.name = s001.name;
        System.out.println(s002);
    }

}
class Student {
    int id;
    String name;
    String contactNumber;

    public Student(){
        this(5, "Ruwan","071-9699854");
        System.out.println("No arg constructor");
    }

    public Student(int sId, String sName, String sContact){
        id = sId;
        name = sName;
        contactNumber = sContact;
        System.out.println("All arg constructor");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
