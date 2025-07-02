package org.hahadeng.algo.lc;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotate-array/description/
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author HaHaDeng
 * @since 2025/6/25 23:16
 */
public class Q189_RotateArray {

    public void arrayCopyToOtherTest(){
        // 复制数组到另外一个数组里面
        int[] nums = new int[]{1,2,3,4,5};
        int[] ans = new int[nums.length];
        // (source, start, target, start, len)
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.out.println(Arrays.toString(ans));
        // Arrays.stream(ans).forEach(System.out::println);

        // [from, to]
        int[] ans2 = Arrays.copyOfRange(nums, 0, nums.length);
        System.out.println(Arrays.toString(ans2));
    }

    /**
     * nums = A + B
     * ans = reverse(B) + reverse(A)
     * @param nums 待转数组
     * @param k k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 轮转 k 次等于轮转 k % n 次
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }


    /**
     * 通过空间换时间求解
     * @param nums 传入的待转数组
     * @param k k
     */
    public void rotateBySpace(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = (i + k) % n;
            ans[idx] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, n);
    }
}
