package i01_数组;

import com.sun.org.apache.xpath.internal.operations.Plus;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Title: I07_加一.java
 * @description: TODO
 * @time: 2019/11/12 15:49
 * @author: liyongda
 * @version: 1.0
 *
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * [6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3]
 * 9,8,2,1,3,3,1,8,1,4,4,7,2,7,2,0,5,6,8,9,7,7,4,3
 */
public class I07_加一 {

    public static void main(String[] args) {
        int[] digits = {9,8,2,1,3,3,1,8,1,4,4,7,2,7,2,0,5,6,8,9,7,7,4,9};
        int[] rt = plusOne(digits);
        System.out.println(Arrays.toString(rt));
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            } else {
                break;
            }
        }
        if (digits[0] == 10) {
            int[] rt = new int[digits.length + 1];
            rt[0] = 1;
            digits[0] = 0;
            for (int i = 0; i < digits.length; i++) {
                rt[i + 1] = digits[i];
            }
            digits = rt;
        }
        return digits;
    }
}
