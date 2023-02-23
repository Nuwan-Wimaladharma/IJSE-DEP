package lk.ijse.dep10.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/nuwan/Desktop/Commando 2 (2017) [X TECH].mkv");
        if (!file.exists()){
            System.out.println("No such file exists");
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        while (true) {
            byte[] buffer = new byte[1024 * 1024 * 10]; //10 MB
            int read = fis.read(buffer);
            if (read == -1) break;
        }
        fis.close();
    }
}
