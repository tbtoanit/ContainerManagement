package imic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StreamOutputExample {
    public static void main(String[] args) {
        // Nhập chuỗi từ màn hình sử dụng stream input
        System.out.println("Vui lòng nhập dữ liệu cần ghi vào file: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //path của file cần ghi
        String path = "D:\\Personal\\IMIC\\Java C2\\Practice\\buoi14\\Data\\Output.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
                fos.write(s.getBytes());// chuyển string sang byte và ghi vào file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
