package org.hahadeng.algo;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/">...</a>
 * 原地删除元素
 *
 * @author 邓聪
 * @since 2025/6/24 15:51
 */
public class Q26_RemoveDuplicatesFromSortedArray {

    /**
     * 快慢指针
     * 快指针所指向的值如果等于慢指针指向的值，表示元素重复，快指针向后移动。
     * 如果不想等，表示需要保留， 将快指针指向的值存放到low+1的位置。
     *
     * @param nums 入参
     */
    public int removeDuplicatesByFastLow(int[] nums) {
        // 快慢指针
        int fast = 0, low = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[low]) {
                fast++;
            } else {
                nums[++low] = nums[fast++];
            }
        }
        // 返回的是元素的个数，因为下标是从0开始的，所以需要加1
        return low + 1;
    }

    /**
     * 类似快慢指针的变形
     * i表示快指针，k表示慢指针
     *
     * @param nums 入参
     */
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            // 保留
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Q26_RemoveDuplicatesFromSortedArray q = new Q26_RemoveDuplicatesFromSortedArray();
        int ans = q.removeDuplicates(nums);
    }
}
