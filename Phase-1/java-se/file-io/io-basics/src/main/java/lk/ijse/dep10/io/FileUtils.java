package lk.ijse.dep10.io;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/nuwan/Desktop");
        File file1 = new File(file, "abc.mp4");
        System.out.println(file1); //prints /home/nuwan/Desktop/abc.mp4

        file1.createNewFile();


    }
}
