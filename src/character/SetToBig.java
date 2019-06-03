package character;

/**
 * @Author: zhaoty
 * @Date: 2019/6/3 10:30
 * @Version 1.0
 */

import java.util.Scanner;

/**
 * 将单词首字母设置为大写
 */
public class SetToBig {
    private static void change(String str) {
        String[] temp = str.split(" ");
        String newsentence="";
        for (String temp1 : temp) {
            char[] cs = temp1.toCharArray();
            cs[0] = Character.toUpperCase(cs[0]);
            temp1=new String(cs);
            temp1+=" ";
            newsentence+=temp1;
        }
        System.out.println(newsentence);
    }

    public static void main(String[] args) {
        Scanner inStr=new Scanner(System.in);
        System.out.println("请输入：");
        String str=inStr.nextLine();
        change(str);
    }
}
