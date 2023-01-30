package method;

public class VarArgs {
    public static void main(String[] args) { //public static void main(String ...args)  //both are ok
//        String[] myArgs = {"abc", "bnh", "jhu"};
//        //myMethod(myArgs);
//        myMethod2("abc", "gugj", "hgdu");
//        myMethod3(10,"nuwan", "wimaladharma");

        String[] myArgs = {"abc", "ghk", "gwdud"};
        System.out.printf("%s-%s \n" ,"abc","ghk", "gwdud"); //same output
        System.out.printf("%s-%s \n", myArgs); //same output
    }
//    public static void myMethod(String[] args){ //upto Java 7
//        for (String arg : args){
//            System.out.println(arg);
//        }
//    }

    public static void myMethod2(String... args){ //var args
        for (String arg : args){
            System.out.println(arg);
        }
    }

    public static void myMethod3(int x,String... args){ //legal
        for (String arg : args){
            System.out.println(arg);
        }
    }

//    public static void myMethod4(String... args, int x){ //illegal
//        for (String arg : args){
//            System.out.println(arg);
//        }
//    }
}
