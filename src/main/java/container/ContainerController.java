package container;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContainerController {
    Container c = new Container();
    ArrayList<Container> lst = new ArrayList<>();

    ArrayList<Container> lstFull = new ArrayList<>();
    ArrayList<Container> lstEmpty = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void themContainer() {
        boolean f = true;
        while (f) {
            System.out.println("1. Them 1 container: ");
            System.out.println("2. Ghi File: ");
            int i = sc.nextInt();
            sc.nextLine();
            switch (i) {
                case 1: {
                    System.out.println("Vui long nhap so container: ");
                    c.setContainerNo(sc.nextLine());
                    System.out.println("Vui long nhap chieu cao container: ");
                    c.setHeight(sc.nextLine());
                    System.out.println("Vui long nhap chieu dai container: ");
                    c.setWidth(sc.nextLine());
                    System.out.println("Vui long nhap status container: ");
                    c.setStatus(sc.nextLine());
                    lst.add(c);
                    break;
                }
                case 2:{
                    f = false;
                    break;
                }

            }
        }

    }

    public void ghiFile() {
        try {
            FileOutputStream out = new FileOutputStream("container.txt");
            StringBuffer sb = new StringBuffer();
            for (Container c1 : lst) {
                String x = "NUMBER: " + c1.getContainerNo() + "\n"
                        + "HEIGHT: " + c1.getHeight() + "\n"
                        + "WIDTH: " + c1.getWidth() + "\n"
                        + "STATUS: " + c1.getStatus() + "\n";
                sb.append(x);
            }
            out.write(sb.toString().getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docFile(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("container.txt"));

            // Đọc từng dòng dữ liệu
            String line = bufferedReader.readLine();

            //Tạo đối tượng container để lưu lại dữ liệu đã đọc
            Container c1 = new Container();

            //Lặp từng dòng dữ liệu
            while (line!=null){
                //Tạo mảng string để chứa các chuỗi con sau khi cắt 1 dòng thành 2 chuỗi con bởi dấu hai chấm
                String[] arrayLine = new String[2];
                arrayLine = line.split(":");
                // lặp từng chuỗi con để kiểm tra ID và set giá trị cho từng thuộc tính của container
                //for (int i = 0; i < arrayLine.length; i++) {
                    if(arrayLine[0].equals("NUMBER")){
                        c1.setContainerNo(arrayLine[1]);
                    }else if (arrayLine[0].equals("HEIGHT")){
                        c1.setHeight(arrayLine[1]);
                    }else if (arrayLine[0].equals("WIDTH")){
                        c1.setWidth(arrayLine[1]);
                    }else {
                        c1.setStatus(arrayLine[1]);
                        // Sau khi set xong status thì add đối tượng c1 vào list full hoặc list empty
                        if (c1.getStatus().equals("Full")){
                            lstFull.add(c1);
                            c1 =new Container(); // làm mới lại container trước khi thêm 1 container mới vào đối tượng c1
                        }else {
                            lstEmpty.add(c1);
                            c1 =new Container();// làm mới lại container trước khi thêm 1 container mới vào đối tượng c1
                        }
                    }
                //}
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
