package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author: zhaoty
 * @Date: 2019/6/18 10:52
 * @Version 1.0
 */
public class TestOutStream {
    public static void main(String[] args) {
        try{
            File file=new File("D:/testFile.txt");
            //基于文件对象创建输出流
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            byte [] all={88,89};
            //把数据写入到输出流
            fileOutputStream.write(all);
            fileOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
