package lk.ijse.dep10.oop.exercise;

public class Exercise04 {
    public static void main(String[] args) {
        //Teacher t0; //Actually this is appeared in stack as Reference t0 ===> Reference t0 = new Teacher() <--- This is ok
        Teacher t1 = new Teacher("963601999V","Nuwan","0712951059");
        t1.printDetails();
    }
}
class Teacher{
    String nic;
    String name;
    String contact;

    public Teacher (String nic, String name, String contact){
        super();
        this.nic = nic;
        this.name = name;
        this.contact = contact;
    }
    void printDetails(){
        String name = "Pawan";
        System.out.printf("nic=%s, name=%s, contact=%s %n",nic, name, contact);
    }
}
