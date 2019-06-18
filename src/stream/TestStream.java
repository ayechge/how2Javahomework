package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author: zhaoty
 * @Date: 2019/6/18 10:09
 * @Version 1.0
 */
public class TestStream {
    public static void main(String[] args) {
        try {
            File file = new File("D:/testFile.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] all=new byte[(int)(file.length())];
            //把字节流中的数据读取到字节数组
            //Reads up to <code>b.length</code> bytes of data from this input stream into an array of bytes.
            fileInputStream.read(all);
            for(byte temp:all){
                System.out.println(temp);
            }
            //使用流之后，应该手动关闭
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
