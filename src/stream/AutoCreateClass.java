package stream;

import java.io.*;
import java.util.Scanner;

public class AutoCreateClass {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("输入类名：");
        String className=input.nextLine();
        System.out.println("输入属性名：");
        String propertyName=input.nextLine();
        System.out.println("输入属性类型：");
        String propertyType=input.nextLine();

        File mode=new File("D:/mode.java");
        File result=new File("D:/result.java");
        try(FileReader fileReader=new FileReader(mode);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            FileWriter fileWriter=new FileWriter(result);
            PrintWriter printWriter=new PrintWriter(fileWriter)){
            while (true){
                String line=bufferedReader.readLine();
                if(line==null){
                    return;
                }
                char [] up=className.toCharArray();
                up[0]=Character.toUpperCase(up[0]);
                String temp=new String(up);
                line=line.replace("@class@",className);
                line=line.replace("@type@",propertyType);
                line=line.replace("@property@",propertyName);
                line=line.replace("@Uproperty@",temp);
                printWriter.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
