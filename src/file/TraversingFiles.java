package file;

import java.io.File;

/**
 * @Author: zhaoty
 * @Date: 2019/6/17 17:39
 * @Version 1.0
 */
public class TraversingFiles {

    public static void main(String[] args) {
        File f=new File("C:/Windows");
        File[] files=f.listFiles();
        long max=0;
        long min=9223372036854775807L;
        String nameMax="";
        String nameMin="";
        for(File temp:files){
            if(temp.isDirectory()){

            }
            long length=temp.length();

            if(length>max){
                max=length;
                nameMax=temp.getName();

            }
            if(length<min&&length>0){
                min=length;
                nameMin=temp.getName();
            }

        }
        System.out.println("最大的文件是"+nameMax+","+"其大小是"+max+"字节");
        System.out.println("最小的文件是"+nameMin+","+"其大小是"+min+"字节");
    }
}
