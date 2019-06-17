package collection;

import java.util.LinkedHashSet;

/**
 * @Author: zhaoty
 * @Date: 2019/6/12 20:48
 * @Version 1.0
 */
public class TestCollection {
    public static void main(String[] args) {
        String pi = String.valueOf(Math.PI);
        char[] newpi = pi.toCharArray();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (char temp : newpi) {
            if (Character.isDigit(temp)) {
                linkedHashSet.add(temp);
            }
        }
        System.out.println(linkedHashSet);

    }
}
