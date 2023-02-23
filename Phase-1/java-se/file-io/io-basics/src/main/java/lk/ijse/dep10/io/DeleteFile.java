package lk.ijse.dep10.io;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("/home/nuwan/Desktop/dep10.ijse");
        file.delete();
    }
}
