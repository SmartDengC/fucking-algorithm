package org.hahadeng.algo.lc;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 邓聪
 * @since 2025/8/4 17:11
 */
public class Q3243_ShortestDistanceAfterRoad {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // 求0到n-1的最短距离
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, x -> new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            g[i].add(i + 1);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] row = queries[i];
            int x = row[0], y = row[1];
            g[x].add(y);
            ans[i] = bfs(g, n);
        }
        return ans;
    }

    public int bfs(List<Integer>[] g, int n) {
        // 遍历从i到j的最短路径
        int[] dis = new int[n];
        // 先填充值，在设置默认值。
        Arrays.fill(dis, -1);

        dis[0] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (dis[y] < 0) {
                    dis[y] = dis[x] + 1;
                    q.offer(y);
                }
            }
        }
        return dis[n - 1];
    }

    public static void main(String[] args) {
        AtomicInteger x = new AtomicInteger(0);
        int i = x.incrementAndGet();
        int andIncrement = x.getAndIncrement();

        System.out.println(i);
        System.out.println(andIncrement);

    }

}
