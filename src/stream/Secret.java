package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Author: zhaoty
 * @Date: 2019/6/18 20:21
 * @Version 1.0
 */
public class Secret {
    public static void main(String[] args) {
        File encodingFile = new File("D:/encoding.txt");
        File encodedFile = new File("D:/encoded.txt");
        encode(encodingFile, encodedFile);
    }

    public static void encode(File encodingFile, File encodedFile) {
        //用于存放加密后的数据
        char[] result = new char[(int) encodingFile.length()];

        char[] all = new char[(int) encodingFile.length()];
        int index = 0;
        //把文件的内容读入了all数组
        try (FileReader fileReader = new FileReader(encodingFile)) {
            fileReader.read(all);
            for (char temp : all) {
                if (Character.isDigit(temp)) {
                    if (temp != '9') {
                        temp += 1;
                        result[index++] = temp;
                    } else {
                        temp = '0';
                        result[index++] = temp;
                    }
                } else if (Character.isLowerCase(temp) || Character.isUpperCase(temp)) {
                    if (temp != 'z' && temp != 'Z') {
                        temp++;
                        result[index++] = temp;
                    } else {
                        if (temp == 'z') {
                            temp = 'a';
                            result[index++] = temp;
                        } else {
                            result[index++] = 'A';
                        }
                    }
                } else {
                    result[index++] = temp;
                }
            }
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将编码后的数据写入encodedFile
        try (FileWriter fileWriter = new FileWriter(encodedFile)) {
            fileWriter.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
