package character;

/**
 * @Author: zhaoty
 * @Date: 2019/6/3 11:30
 * @Version 1.0
 */

import java.sql.SQLOutput;

/**
 * 将最后一个two的首字母改成大写
 */
public class LastTwo {


    public static void main(String[] args) {
        String str="Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        int index=str.lastIndexOf("two");
        char[] temp=str.toCharArray();
        temp[index]='T';
        System.out.println(temp);

    }
}
