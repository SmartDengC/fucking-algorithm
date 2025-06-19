package org.hahadeng.algo.monotonicStack;

import org.junit.Test;

import java.util.*;

/**
 * @author HaHaDeng
 * @since 2025/6/18 23:23
 */

public class q739 {
    // 需要解决的问题
    // 1 java中用什么数据结构来实现单调栈，实现栈结构，可以用ArrayList每次操作最后一个，
    @Test
    public void test() {
        // 创建一个ArrayList对象
        List<Integer> lit = new ArrayList<>();

        // 向ArrayList中添加元素
        lit.add(1);
        lit.add(2);

        // 创建一个ArrayDeque对象，用于实现栈结构
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
       // stack.pop();

        while(!stack.isEmpty()){
            // out 2, 1
            System.out.println(stack.pop());
        }
        // 0 ^ x = x
        int x = 0 ^ 2;

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = len-1;i>=0;i--){
            int t = temperatures[i];
            while(!st.isEmpty() && t >= temperatures[st.peek()]){
                st.pop();
            }
            // 如果栈不为空
            if(!st.isEmpty()){
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;

    }

    @Test
    public void test2(){
        q739 q739 = new q739();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};

        int[] ints = q739.dailyTemperatures(temperatures);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
