package lk.ijse.dep10.io;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File downloadDir = new File("/home/nuwan/Downloads");
        System.out.println(downloadDir.isFile());
        System.out.println(downloadDir.isDirectory());
        System.out.println("=================================");
        String[] list = downloadDir.list();
        for (String s : list) {
            System.out.println(s); //gives the file name only (list())
        }
        File[] files = downloadDir.listFiles();
        for (File file : files) {
            System.out.println(file);  //gives the pointer of the file(listFiles())
        }
    }
}
