package i02_字符串;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: I04_有效的字母异位词.java
 * @description: TODO
 * @time: 2020/1/2 17:41
 * @author: liyongda
 * @version: 1.0
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class I04_有效的字母异位词 {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer integer = mapS.get(c);
            mapS.put(c, integer == null ? 1 : ++integer);
        }
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer integer = mapT.get(c);
            mapT.put(c, integer == null ? 1 : ++integer);
        }
        return mapS.equals(mapT);
    }
}
