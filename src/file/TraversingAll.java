package file;

import java.io.File;

/**
 * @Author: zhaoty
 * @Date: 2019/6/17 21:28
 * @Version 1.0
 */

/**
 * 遍历文件中的每个文件及其子文件夹，找出最大和最小的文件
 */
public class TraversingAll {
    static long min=Integer.MAX_VALUE;
    static long max=0;
    static File maxFile=null;
    static File minFile=null;
    //使用递归遍历每一个文件
    public static void search(File file){
        //是文件
        if(file.isFile()){
            if(file.length()>max){
                max=file.length();
                maxFile=file;
            }
            if(file.length()<min&&file.length()!=0){
                min=file.length();
                minFile=file;
            }
        }
        //是文件夹
        if(file.isDirectory()){
            File[] files=file.listFiles();
            //有些文件没有访问权限,会出现空指针异常
            if(files==null){
                return;
            }
            for(File temp:files){
                search(temp);
            }
        }
    }

    public static void main(String[] args) {
        File file=new File("C:/WINDOWS");
        search(file);
        System.out.format("最大的文件是：%s,其大小是：%d 字节",maxFile.getName(),max);
        System.out.format("最小的文件是：%s,其大小是：%d 字节",minFile.getName(),min);

    }

}
