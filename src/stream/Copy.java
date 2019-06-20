package stream;

import java.io.*;


public class Copy {
    public static void main(String[] args) {
        File src = new File("D:/src.txt");
        File dest = new File("D:/dest.txt");
        copyFile(src, dest);
    }

    static void copyFile(File srcFile, File destFile) {
        try (FileReader fileReader = new FileReader(srcFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(destFile);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            while (true) {
                String line = bufferedReader.readLine();
                if(line==null){
                    return;
                }
                printWriter.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
