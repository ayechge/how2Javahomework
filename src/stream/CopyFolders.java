package stream;

import java.io.*;

/**
 * 复制文件夹及其下的文件
 */
public class CopyFolders {
    public static void main(String[] args) {
        File src = new File("D:/testcopy1");
        File dest = new File("D:/testcopy2");
        copy(src, dest);
    }
    private static void copy(File srcFloder, File destFloder) {
        if (!srcFloder.exists()) {
            System.out.println("源文件不存在");
            return;
        }
        if (srcFloder.equals(destFloder)) {
            System.out.println("无效操作");
        }
        File[] files = srcFloder.listFiles();
        //目标文件不存在 创建目录
        if (!destFloder.exists()) {
            destFloder.mkdirs();
        }
        if (null == files) {
            return;
        }
        for (File temp : files) {
            //如果是文件夹 进行递归
            if (temp.isDirectory()) {
                File newSrc = new File(temp.getAbsolutePath());
                File newDest = new File(destFloder.getAbsolutePath() + "/" + temp.getName());
                copy(newSrc, newDest);
            } else {
                //如果是文件，利用字节流进行复制操作
                try (FileInputStream fileInputStream = new FileInputStream(temp);
                     FileOutputStream fileOutputStream = new FileOutputStream(destFloder + "/" + temp.getName())) {
                    //缓存字节流
                    byte[] all = new byte[(int) temp.length()];
                    fileInputStream.read(all);
                    fileOutputStream.write(all);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}