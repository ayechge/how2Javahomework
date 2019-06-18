package stream;

import java.io.*;

/**
 * @Author: zhaoty
 * @Date: 2019/6/18 16:14
 * @Version 1.0
 */
public class MergeFiles {
    public static void main(String[] args) {
        merge("D:/", "godfather.mkv");
    }

    private static void merge(String folder, String fileName) {
        File destFile = new File(folder, fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(destFile)) {


            int index = 0;
            while (true) {
                //子文件对象
                File eachFile = new File(folder, fileName + "-" + index++);
                //子文件不存在就结束
                if (!eachFile.exists()) {
                    break;
                }
                //读取子文件内容
                try (FileInputStream fileInputStream = new FileInputStream(eachFile)) {
                    byte[] each = new byte[(int) eachFile.length()];
                    fileInputStream.read(each);
                    fileInputStream.close();

                    //把子文件内容写出
                    fileOutputStream.write(each);
                    //迫使所有缓冲的输出数据被写出到底层输出流中
                    fileOutputStream.flush();
                }
                System.out.printf("把子文件 %s 写出到目标文件中%n", eachFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("最后目标文件的大小：%,d字节", destFile.length());
    }

}
