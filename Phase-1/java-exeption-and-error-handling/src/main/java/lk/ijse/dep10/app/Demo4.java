package lk.ijse.dep10.app;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        try(MyResource1 myResource1 = new MyResource1(); MyResource2 myResource2 = new MyResource2(); MyResource3 myResource3 = new MyResource3()){
            System.out.println(myResource1);
            System.out.println(myResource2);
            System.out.println(myResource3);
        }
        //myResource.close();

        File file = new File("/home/nuwan/Desktop/mails");
        if (!file.exists()) return;
        try(FileInputStream fis = new FileInputStream(file)){
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = bis.readAllBytes();
            System.out.println("Length is: " + bytes.length);
        }
    }
}
class MyResource1 implements AutoCloseable{

    {
        System.out.println("MyResource1");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource1 is about to close");
    }
}
class MyResource2 implements AutoCloseable{

    {
        System.out.println("MyResource2");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource2 is about to close");
    }
}
class MyResource3 implements Closeable { //Closeable or AutoCloseable

    {
        System.out.println("MyResource3");
    }

    @Override
    public void close() {
        System.out.println("Resource3 is about to close");
    }
}
