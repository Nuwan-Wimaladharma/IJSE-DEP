package lk.ijse.dep10.app;

import java.sql.SQLException;

public class Demo3 {
    public static void main(String[] args) {
        try {
            myMethod1();
        } catch (ClassNotFoundException e) {
            System.out.println("ClaasNotFoundExeption ekak aawaa");
        } catch (InterruptedException e) {
            System.out.println("InterruptedExeption ekak aawaa");
        } catch (SQLException e) {
            System.out.println("SQLExeption ekak aawaa");
        }
        System.out.println("End");
    }
    public static void myMethod1() throws ClassNotFoundException,InterruptedException, SQLException {
        System.out.println("Entering myMethod1");
        myMethod2();
        //throw new ClassNotFoundException(); //execution doesn't occured after this line
        throw new InterruptedException();
        //throw new SQLException();
//        myMethod2();
//        System.out.println("Leaving myMethod1");
    }
    public static void myMethod2() throws ClassNotFoundException{
        System.out.println("Entering myMethod2");
        myMethod3();
        System.out.println("Leaving myMethod2");
    }
    public static void myMethod3() throws ClassNotFoundException{
        System.out.println("Entering myMethod3");
        System.out.println("Leaving myMethod3");
    }

}
