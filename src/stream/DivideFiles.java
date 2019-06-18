package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * 拆分文件
 */
public class DivideFiles {
    public static void main(String[] args) {
        //新建文件对象
        File file = new File("D:/godfather.mkv");
        //将文件读入字节数组
        byte[] all = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(all);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将每份设置成10MB大小
        int eachSize = 10 * 1024 * 1024;
        //确定文件要拆分的份数
        long fileNum;
        if (file.length() % eachSize == 0) {
            fileNum = file.length() / eachSize;
        } else {
            fileNum = file.length() / eachSize + 1;
        }
        for (int i = 0; i < fileNum; i++) {
            //文件名
            String fileName = file.getName() + "-" + i;
            //字节数组，用于接收filePart
            byte[] part;
            //创建拆分的文件对象
            File filePart = new File(file.getParent(), fileName);
            //将文件拆分后放入part
            if (i != fileNum - 1) {
                part = Arrays.copyOfRange(all,i*eachSize,(i+1)*eachSize);
            }
            else{
                part=Arrays.copyOfRange(all,i*eachSize,(int)(file.length()));
            }
            try{
                //进行文件输出流操作
                FileOutputStream fileOutputStream=new FileOutputStream(filePart);
                fileOutputStream.write(part);
                fileOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("输出子文件"+filePart.getParent()+filePart.getName()+",其大小是"+filePart.length()+"字节");
        }

    }
}