package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        //creating pointer
        File file = new File("/home/nuwan/Desktop/pom.xml");  //absolute path
        if (!file.exists()){
            System.out.println("Invalid file path");
            return;
        }
        FileInputStream fis = new FileInputStream(file);
//        byte[] bytes = new byte[fis.available()];
//        fis.read(bytes);
        byte[] bytes = fis.readAllBytes();  //instead of above two lines
        fis.close();
        //System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes)); //this method is valid for any plain file (.xml, .html, .txt, .css .......etc)
    }
}
