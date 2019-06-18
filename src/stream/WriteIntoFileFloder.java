package stream;

/**
 * @Author: zhaoty
 * @Date: 2019/6/18 11:24
 * @Version 1.0
 */

import java.io.File;
import java.io.FileOutputStream;

/**
 * 写入数据到文件
 */
public class WriteIntoFileFloder {
    public static void main(String[] args) {
        try{
            File file=new File("D:/xyz/zzz/test.txt");
            //父文件夹不存在，则创建
            file.getParentFile().mkdirs();
            byte[]all={69,70};
            //这一步结束之后，空文件就创建出来了
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(all);
            fileOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
