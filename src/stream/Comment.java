package stream;

import java.io.*;

/**
 * @Author: zhaoty
 * @Date: 2019/6/19 15:20
 * @Version 1.0
 */
public class Comment {
    public static void main(String[] args) {
        File file = new File("D:/Test.java");
        removeComments(file);
    }

    public static void removeComments(File javaFile) {
        File file = new File("D:/new.java");
        try (FileReader fr = new FileReader(javaFile);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(file);
             PrintWriter pw = new PrintWriter(fw)) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                //trim 把头尾的空格去掉
                if (line.trim().startsWith("//")) {
                    pw.println(line);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
