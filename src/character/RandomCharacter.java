package character;

import java.util.Scanner;

/**
 * @Author: zhaoty
 * @Date: 2019/6/1 21:28
 * @Version 1.0
 */
public class RandomCharacter {
    /**
     * 产生随机字符串
     * @param length
     * @return
     */
    public static String randomChar(int length){
        char [] str=new char[length];
        int index=0;
        while(index<length){
            char temp=(char)(48+Math.random()*75);
            if(Character.isUpperCase(temp)||Character.isDigit(temp)||Character.isLowerCase(temp)){
                str[index]=temp;
                //满足条件才递增
                index++;

            }
        }
        return new String(str);
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please input length:");
        int length=input.nextInt();
        System.out.println(randomChar(length));
    }
}
