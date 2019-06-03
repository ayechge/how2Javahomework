package character;

/**
 * @Author: zhaoty
 * @Date: 2019/6/3 14:18
 * @Version 1.0
 */
public class CompStringAndStringBuffer {
    public static String randomChar(int length) {
        char[] str = new char[length];
        int index = 0;
        while (index < length) {
            char temp = (char) (48 + Math.random() * 75);
            if (Character.isUpperCase(temp) || Character.isDigit(temp) || Character.isLowerCase(temp)) {
                str[index] = temp;
                index++;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        int i = 10000;
        String str1 = "";
        long time1 = System.currentTimeMillis();
        while (i > 0) {
            str1 += randomChar(10);
            i--;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("字符串+耗时：" + (time2 - time1));
        int j = 10000;
        StringBuffer str2 = new StringBuffer();
        long time3 = System.currentTimeMillis();
        while (j > 0) {
            str2.append(randomChar(10));
            j--;
        }
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuffer耗时：" + (time4 - time3));

    }
}
