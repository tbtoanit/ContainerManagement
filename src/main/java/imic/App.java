package imic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            FileInputStream in = new FileInputStream("abc.txt");
            int c, i;
            char[] a = new char[15];
            while ((c=in.read())!=-1){
                i=0;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
