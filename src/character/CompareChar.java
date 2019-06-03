package character;

/**
 * @Author: zhaoty
 * @Date: 2019/6/3 11:59
 * @Version 1.0
 */
public class CompareChar {
    public static void main(String[] args) {
        int times = 0;
        String sentence = "";
        while (times < 50) {
            String part = RandomCharacter.randomChar(2);
            sentence += part;
            sentence+=" ";
            times++;
        }
        System.out.println(sentence);
        String[] newsentence = sentence.split(" ");
        String result = "";
        int index=0;
        for (String temp : newsentence) {

            int time = 0;
            while (time < 50) {

                if (temp.equals(newsentence[time]) && time != index) {
                    if(result.contains(temp)){
                        continue;
                    }

                    result += temp;
                    result += " ";
                    break;
                }
                time++;

            }
            index++;
        }
        System.out.println(result);
    }
}
