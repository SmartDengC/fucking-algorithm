package org.hahadeng.algo.slidewindow.fixlength;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring/description/">...</a>
 *
 * @author 邓聪
 */
public class Q1297 {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // 不同字符个数小于maxLetters
        // 子串长度大于minsize，小于maxsize
        // 要出现次数最多，那么子串的长度就尽量短

        Map<Character, Integer> cnt = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        // 求每个子串的出现次数
        StringBuilder str = new StringBuilder();

        for(int i = 0;i<chars.length;i++){
            cnt.merge(chars[i], 1, Integer::sum);
            str.append(chars[i]);

            if(i< minSize - 1){
                continue;
            }

            if(cnt.size() <= maxLetters){
                map.merge(str.toString(), 1, Integer::sum);
            }

            // out
            str.deleteCharAt(0);

            if(cnt.merge(chars[i-minSize+1], -1, Integer::sum) == 0){
                cnt.remove(chars[i-minSize+1]);
            }

        }

        int ans = 0;

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            ans = Math.max(ans, entry.getValue());
        }
        return ans;
    }

    @Test
    public void test(){
        String s = "aababcaab";
//        int i = Q1297.maxFreq(s, 2, 3, 4);
//        System.out.println(i);


        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(2);
        q.offer(1);
        q.offer(3);

        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
        System.out.println(5 & 5);
    }
}
