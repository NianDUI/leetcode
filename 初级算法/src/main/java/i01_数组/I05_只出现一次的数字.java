package i01_数组;


/**
 * @Title: I05_只出现一次的数字.java
 * @description: TODO
 * @time: 2019/11/12 10:28
 * @author: liyongda
 * @version: 1.0
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class I05_只出现一次的数字 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int rt = singleNumber(nums);
        System.out.println(rt);
    }

    public static int singleNumber(int[] nums) {
        for (int i : nums) {
            boolean bl = true;
            int num = 0;
            for (int j : nums) {
                if (i == j) {
                    if (++num == 2) {
                        bl = false;
                        continue;
                    }
                }
            }
            if (bl) {
                return i;
            }
        }
        return -1;
    }
}
