package statement.demos;

import java.util.Scanner;

public class ProgressBarDemo {
    public static void main(String[] args) throws InterruptedException {
        int inputOut;
        for (int i = 0; true; i++){
            var scanner = new Scanner(System.in);
            System.out.print("Enter a positive integer: ");
            String inputNumberString = scanner.next();
            int validationCount = 0;
            for (int x = 0; x < inputNumberString.length(); x++){
                int charNumber = inputNumberString.charAt(x);
                if (charNumber < 48 || charNumber > 57){
                    validationCount += 1;
                }
            }
            if (validationCount > 0){
                System.out.println("Invalid Input");
                continue;
            }
            int inputNumber = 0;

            if (validationCount == 0){
                inputNumber = Integer.parseInt(inputNumberString);
            }
            if (inputNumber >= 0){
                inputOut = inputNumber;
                break;
            }
            if (inputNumber < 0){
                System.out.println("Invalid Input");
                continue;
            }
        }
        System.out.println("Select Progress Speed");
        System.out.println("==============");
        System.out.println("(1) Fast");
        System.out.println("(2) Medium");
        System.out.println("(3) Slow");
        System.out.println("==============");

        int speedOut;
        for (int j = 0; true; j++){
            var scanner2 = new Scanner(System.in);
            System.out.print("Select the Speed: ");
            String speedNumberString = scanner2.next();
            int validationCount2 = 0;
            for (int y = 0; y < speedNumberString.length(); y++){
                int charNumber = speedNumberString.charAt(y);
                if (charNumber < 48 || charNumber > 57){
                    validationCount2 += 1;
                }
            }
            if (validationCount2 > 0){
                System.out.println("Invalid Input");
                continue;
            }
            int speedNumber = 0;

            if (validationCount2 == 0){
                speedNumber = Integer.parseInt(speedNumberString);
            }
            if (speedNumber == 1 || speedNumber == 2 || speedNumber == 3){
                speedOut = speedNumber;
                break;
            }
            if (speedNumber != 1 && speedNumber != 2 && speedNumber != 3) {
                System.out.println("Invalid Input");
                continue;
            }
        }
        for (int a = 1; a <= inputOut; a++){
            String finalOutPutString = "Progress: ";
            int percentage = (a * 100) / inputOut;
            String percentageOutput = percentage + " %";
            finalOutPutString += percentageOutput;
            finalOutPutString += " [";
            for (int b = 1; b <= (percentage / 5); b++){
                finalOutPutString += "\u001b[44m \u001b[0m";
            }
            for (int c = 1; c <= (20 - (percentage / 5)); c++){
                finalOutPutString += " ";
            }
            finalOutPutString += "] ";
            String printOutput = a + "/" + inputOut;
            finalOutPutString += printOutput;
            System.out.print(finalOutPutString);
            int threadSpeed = 0;
            if (speedOut == 1){
                threadSpeed = 100;
            }
            else if (speedOut == 2){
                threadSpeed = 200;
            }
            else if (speedOut == 3){
                threadSpeed = 300;
            }
            Thread.sleep(threadSpeed);
            for (int d = 0; d < finalOutPutString.length(); d++){
                System.out.print("\b");
            }
        }
        System.out.println("Completed..!");
    }
}
