package i01_数组;

import java.util.Arrays;

/**
 * @Title: I08_移动零.java
 * @description: TODO
 * @time: 2019/11/12 16:34
 * @author: liyongda
 * @version: 1.0
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * [0,0,1]
 */
public class I08_移动零 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
//        int num0 = 0;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] == 0) {
//                going(nums, i, nums.length - num0);
//                nums[nums.length - num0 - 1] = 0;
//                num0++;
//            }
//        }

        // 别人的
        int j = 0; // 非零元素的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) { // 如果挪动了位置则让，已挪位置为0
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void going(int[] nums, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
