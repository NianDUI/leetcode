package i01_数组;

import java.util.Arrays;

/**
 * @Title: I03_旋转数组.java
 * @description: TODO
 * @time: 2019/11/12 10:43
 * @author: liyongda
 * @version: 1.0
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class I03_旋转数组 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        // 1 我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
//        int[] numks = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            numks[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = numks[i];
//        }

        // 2 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
//        for (int i = 0; i < k; i++) {
//            int temp = nums[nums.length - 1];
//            for (int j = nums.length - 1; j > 0 ; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = temp;
//        }

        // 3 使用反转 我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
        //原始数组                  : 1 2 3 4 5 6 7
        //反转所有数字后             : 7 6 5 4 3 2 1
        //反转前 k 个数字后          : 5 6 7 4 3 2 1
        //反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);


    }

    public static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        for (; start < end; start++, end--) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
