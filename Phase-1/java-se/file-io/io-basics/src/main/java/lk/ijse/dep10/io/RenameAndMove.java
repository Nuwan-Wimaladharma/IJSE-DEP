package lk.ijse.dep10.io;

import java.io.File;

public class RenameAndMove {
    public static void main(String[] args) {
        //copying file
//        File file = new File("/home/nuwan/Desktop/abc.xml");   //file needed to rename
//        File newFile = new File(file.getParentFile(), "pom.xml");
//        file.renameTo(newFile);

        //moving file
//        File src = new File("/home/nuwan/Desktop/pom.xml");   //file needed to move
//        File target = new File("/home/nuwan/Desktop/Paste", src.getName());
//        src.renameTo(target);

        //moving file with creating a single directory (mkdir())
//        File src = new File("/home/nuwan/Desktop/pom.xml");   //file needed to move
//        File parentFolder = src.getParentFile();
//        File test = new File(parentFolder, "test");
//        test.mkdir();
//        File target = new File("/home/nuwan/Desktop/test", src.getName());
//        src.renameTo(target);

        //moving a file by creating multiple directories (mkdirs())
        File src = new File("/home/nuwan/Desktop/dep10.ijse");   //file needed to move
        File parentFolder = src.getParentFile();
        File test = new File(parentFolder, "test/test1/test2");
        test.mkdirs();
        File target = new File("/home/nuwan/Desktop/test/test1/test2", src.getName());
        src.renameTo(target);
    }
}
