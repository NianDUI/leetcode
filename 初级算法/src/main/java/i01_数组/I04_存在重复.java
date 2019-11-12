package i01_数组;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Title: I4_存在重复.java
 * @description: TODO
 * @time: 2019/11/12 15:36
 * @author: liyongda
 * @version: 1.0
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class I04_存在重复 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        boolean bl = false;
        java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                bl = true;
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return bl;
    }
}
