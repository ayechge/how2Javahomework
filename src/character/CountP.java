package character;

import java.util.Scanner;

/**
 * @Author: zhaoty
 * @Date: 2019/6/3 11:07
 * @Version 1.0
 */
public class CountP {
    public static void count(String str){
        String[] sentence=str.split(" ");
        int num=0;
        for(String part:sentence){
            if(part.charAt(0)=='p'){
                num++;
            }
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        Scanner inStr=new Scanner(System.in);
        System.out.println("请输入：");
        String str=inStr.nextLine();
        count(str);
    }
}
