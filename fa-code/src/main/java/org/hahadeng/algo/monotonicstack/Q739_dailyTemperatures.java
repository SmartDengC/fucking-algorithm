package org.hahadeng.algo.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HaHaDeng
 * @description: 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @since 2025/6/18 23:23
 */

public class Q739_dailyTemperatures {
    /**
     * 需要解决的问题
     * 1 java中用什么数据结构来实现单调栈，实现栈结构，可以用ArrayList每次操作最后一个，
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 示例 1:
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     * 提示：
     * 1 <= temperatures.length <= 105
     * 30 <= temperatures[i] <= 100
     */


    public void testStackOperations() {
        // 创建一个ArrayDeque对象，用于实现栈结构
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.pop();

        while (!stack.isEmpty()) {
            // out 2, 1
            System.out.println(stack.pop());
        }
    }


    public void testXorOperation() {
        int a = 0, b = 2;
        int x = a ^ b;
        // out 2
        System.out.println(x);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = len - 1; i >= 0; i--) {
            int t = temperatures[i];
            while (!st.isEmpty() && t >= temperatures[st.peek()]) {
                st.pop();
            }
            // 如果栈不为空
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        Q739_dailyTemperatures q739 = new Q739_dailyTemperatures();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] ints = q739.dailyTemperatures(temperatures);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
