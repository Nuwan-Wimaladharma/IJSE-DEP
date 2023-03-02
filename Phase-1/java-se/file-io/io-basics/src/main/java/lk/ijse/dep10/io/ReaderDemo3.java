package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("something3.dep10");

        FileReader fr = new FileReader(file);
//        char[] buffer = null;
//        int read = 0;
//        String someText = "";
//
//        while (true){
//            buffer = new char[5];
//            read = fr.read(buffer);
//            if (read == -1) break;
//            someText += new String(buffer,0,read);
//        }
//        fr.close();

        char[] chars = new char[(int) file.length()];
        int read = fr.read(chars);
        fr.close();

        System.out.println(new String(chars,0,read));
    }
}
