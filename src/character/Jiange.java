package character;

/**
 * @Author: zhaoty
 * @Date: 2019/6/3 11:17
 * @Version 1.0
 */

/**
 * 设置间隔大小写
 */
public class Jiange {
    private static void change(String str){
        char[] sentence=str.toCharArray();
        int index=0;
        for(char x:sentence){

            if(index%2==0){
                sentence[index]=Character.toUpperCase(sentence[index]);
            }
            index++;
        }
        System.out.println(sentence);
    }

    public static void main(String[] args) {
        String str="lengendary";
        change(str);
    }
}
