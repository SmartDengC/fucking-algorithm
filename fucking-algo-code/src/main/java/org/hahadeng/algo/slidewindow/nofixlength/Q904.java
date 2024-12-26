package org.hahadeng.algo.slidewindow.nofixlength;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 邓聪
 */
public class Q904 {
    public static int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            // 添加数据到cnt里面
            cnt.merge(fruits[right], 1, Integer::sum);

            while(cnt.size() > 2){
                // 当size大于2的时候，就把左指针的数据remove掉
                cnt.merge(fruits[left], -1, Integer::sum);
                if(cnt.get(fruits[left]) == 0){
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    @Test
    public void test(){
        // 这两者的区别是什么？
        int[] fruits = {1,2,1};
        int[] fruits2 = new int[]{0,1,2,2};
        int i = Q904.totalFruit(fruits);
        System.out.println(i);
    }
    @Test
    public void test2(){
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 1;
        System.out.println(++a == 1);
        System.out.println(b++ == 1);
        // true
        System.out.println(1 == c++);
        // false
        System.out.println(1 == ++d);
    }
}
