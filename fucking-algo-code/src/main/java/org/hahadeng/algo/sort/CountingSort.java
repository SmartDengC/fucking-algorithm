package org.hahadeng.algo.sort;

/**
 * 计数排序
 *
 * @author 邓聪
 */
public class CountingSort {

    public static int[] countingSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int j : arr) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        // 先用最大值+1，后面优化count数组， count的长度是max-min+1
        // 0 ~ max-min+1, 0-67 偏移量23（min）
        int len = max - min + 1;
        int[] count = new int[len];

        // 计数
        for (int j : arr) {
            // 查询出来的arr[i]的值有一个min的偏移量
            count[j - min]++;
        }
        // 统计
        for(int i = 1;i<len;i++){
            count[i] += count[i-1];
        }

        // 最终结果
        int[] output = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int valToIndex = arr[i] - min;
            output[count[valToIndex] - 1] = arr[i];
            count[valToIndex]--;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{90, 89, 23, 77, 58};
        // int[] arr = new int[]{90, 89, 23, 77, 58}的话会创建一个容量为90的一个数组，但是实际容量只有5个
        int[] ints = CountingSort.countingSort(arr);

        for(int x: ints){
            System.out.println(x);
        }
    }
}
