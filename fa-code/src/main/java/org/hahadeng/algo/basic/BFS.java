package org.hahadeng.algo.basic;

import java.util.*;

/**
 * @author 邓聪
 * @since 2025/8/4 16:32
 */
public class BFS {

    public int[] bfs(int n, int[][] edges, int start) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, x -> new ArrayList<>());

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }

        // 定义一个数组表示从起点到终点的距离
        int[] dis = new int[n];
        // 表示尚未访问
        Arrays.fill(dis, -1);
        // 定义一个队列
        Queue<Integer> q = new ArrayDeque<>();
        // 起点距离起点为0
        dis[start] = 0;
        // 把起点放到队列里面
        q.offer(start);

        // bfs老套路
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (dis[y] < 0) {
                    dis[y] = dis[x] + 1;
                    q.offer(y);
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int i = Integer.parseInt("110", 2);
        System.out.println(i);
    }
}
