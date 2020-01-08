package i02_字符串;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Title: I03_字符串中的第一个唯一字符.java
 * @description: TODO
 * @time: 2020/1/2 17:25
 * @author: liyongda
 * @version: 1.0
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class I03_字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer integer = map.get(c);
            map.put(c, integer == null ? 1 : ++integer);
        }
        System.out.println(map);
        Iterator<Character> iterator = map.keySet().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            Character next = iterator.next();
            if (map.get(next) == 1) {
                return s.indexOf(next);
            }
        }
        return -1;
    }
}
