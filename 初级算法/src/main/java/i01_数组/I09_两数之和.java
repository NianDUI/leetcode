package i01_数组;

import java.util.Arrays;

/**
 * @Title: I09_两数之和.java
 * @description: TODO
 * @time: 2019/11/12 14:35
 * @author: liyongda
 * @version: 1.0
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * [-1,-2,-3,-4,-5] -8
 */
public class I09_两数之和 {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] rt = twoSum(nums, target);
        System.out.println(Arrays.toString(rt));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] rt = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    rt[0] = i;
                    rt[1] = j;
                    break;
                }
            }
        }
        return rt;
    }

}
