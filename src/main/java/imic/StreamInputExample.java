package imic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamInputExample {
    public static void main(String[] args) {
        String path = "abc.txt";
        try {
            FileInputStream fis = new FileInputStream(path);
            int i;
            while ((i = fis.read()) != -1){
                System.out.print((char)i);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
