package i02_字符串;

import org.junit.Test;

/**
 * @Title: I08_外观数列.java
 * @description: TODO
 * @time: 2020/1/7 10:09
 * @author: liyongda
 * @version: 1.0
 * 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 */
public class I08_外观数列 {
    @Test
    public void main() {
        System.out.println(countAndSay(4));
    }

    public String countAndSay(int n) {
        String rv = "1";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.delete(0, sb.length());
            byte[] bytes = rv.getBytes();
            byte pre = bytes[0];
            int l = 1;
            for (int j = 1; j < bytes.length; j++) {
                if (pre == bytes[j]) {
                    l++;
                    continue;
                } else {
                    sb.append(l).append((char) pre);
                    l = 1;
                    pre = bytes[j];
                }
            }
            sb.append(l).append((char) bytes[bytes.length - 1]);
            rv = sb.toString();
        }
        return rv;
    }
}
