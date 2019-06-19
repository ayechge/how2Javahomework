package stream;


import java.io.*;

/**
 * @Author: zhaoty
 * @Date: 2019/6/19 10:00
 * @Version 1.0
 */
public class Deciphering {
    public static void main(String[] args) {
        File origin = new File("D:/encoded.txt");
        File wanted = new File("D:/encoding.txt");
        decipher(origin, wanted);
    }

    /**
     * 解密算法
     *
     * @param origin 待解密的文件
     * @param wanted 结果文件
     */
    public static void decipher(File origin, File wanted) {
        //分别存放待解密字符和解密后的字符
        char[] before = new char[(int) origin.length()];
        char[] after = new char[(int) origin.length()];
        try (FileReader fileReader = new FileReader(origin)) {
            //将origin中的内容读取到before
            fileReader.read(before);
            int index = 0;
            //依据规则进行解密，存入after数组
            for (char temp : before) {
                if (Character.isDigit(temp)) {
                    if (temp != '0') {
                        temp--;
                        after[index++] = temp;
                    } else {
                        after[index++] = '9';
                    }
                } else if (Character.isLowerCase(temp) || Character.isUpperCase(temp)) {
                    if (temp == 'a') {
                        after[index++] = 'z';
                    } else if (temp == 'A') {
                        after[index++] = 'Z';
                    } else {
                        temp--;
                        after[index++] = temp;
                    }
                }else{
                    after[index++] = temp;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将afte中的数据写入wanted
        try (FileWriter fileWriter = new FileWriter(wanted)) {
            fileWriter.write(after);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
