package lk.ijse.dep10.io;

import java.util.Map;

public class EnvDemo {
    public static void main(String[] args) {
        String path = System.getenv("PATH");
        System.out.println(path);

        Map<String, String> osEnvVariables = System.getenv();  //Map<Data type of the key,Data type of the value> //related to the OS
        for (String key : osEnvVariables.keySet()) {
            System.out.printf("%s = %s\n",key,osEnvVariables.get(key));
        }
    }
}
