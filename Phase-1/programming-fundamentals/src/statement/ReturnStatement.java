package statement;

public class ReturnStatement {
//    {
//        if (true) return; //cannot be use outside of methods
//    }
//    block1:
//    {
//            //cannot be done. because block is outside from a method
//    }
    public static void main(String[] args) {
        //main(null); //to overflow the stack
        System.out.println("Start");
//        if (true) return; //execution is jumped out from the method
        System.out.println(add(20,30));
        System.out.println("End");
    }
    public static int add(int num1, int num2){
        int result = num1 + num2;
        return result;
    }
}
