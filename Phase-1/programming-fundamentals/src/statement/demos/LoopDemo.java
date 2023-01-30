package statement.demos;

public class LoopDemo {
    public static void main(String[] args) throws InterruptedException {
        String something = "Hello DEP_10, How are you?";

//        for (int i = 0; i < 5; i++) {
//            System.out.println("IJSE");
//            Thread.sleep(1000); //take a 1 s break after execution of one iteration
//        }
//        for (int a = 0; a < 5; a++){
//            for (int i = 0; i < something.length(); i++){
//                System.out.print(something.charAt(i));
//                Thread.sleep(200);
//            }
//            Thread.sleep(300);
//            for (int j = 0; j < something.length(); j++){
//                System.out.print("\b");
//                Thread.sleep(200);
//            }
//            Thread.sleep(300);
//        }



//        for (int x = 0; x < 5; x++){
//
//            String firstPart = "\u001b[";
//            int colorNumber = 30;
//
//            for (int i = 0; i < something.length(); i++){
//                String finalString = firstPart + colorNumber + "m";
//                System.out.printf(finalString + something.charAt(i));
//                Thread.sleep(200);
//                colorNumber++;
//                if (colorNumber > 39){
//                    colorNumber -= 10;
//                }
//            }
//            Thread.sleep(1000);
//            for (int j = 0; j < something.length(); j++){
//                System.out.print("\b");
//                Thread.sleep(200);
//            }
//            Thread.sleep(1000);
//        }

        String firstPart = "\u001b[";
        int colorNumber = 30;

        for (int i = 0; i < 30; i++){
            String finalString = firstPart + colorNumber + "m";
            if (i < something.length()){
                System.out.print(finalString + something.charAt(i));
            }
            if (i >= something.length()){
                System.out.print("\b");
            }
        }
    }
}
