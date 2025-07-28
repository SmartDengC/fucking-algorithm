package org.hahadeng.algo.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/number-of-provinces/description/">...</a>
 *
 * @author 邓聪
 * @since 2025/7/23 20:25
 */
public class Q547_NumberOfProvinces {
    /**
     * 返回联通数
     *
     * @param isConnected 联通数据
     */
    public int findCircleNumForOne(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans++;
                dfsForOne(i, isConnected, vis);
            }
        }
        return ans;

    }

    private void dfsForOne(int i, int[][] isConnected, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                dfsForOne(j, isConnected, vis);
            }
        }
    }


    /**
     * 通过联通图的方式来求解
     *
     * @param isConnected 节点关系
     */
    public int findCircleNumForTwo(int[][] isConnected) {
        // 通过邻接表来表示图
        int n = isConnected.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, x -> new ArrayList<>());

        for (int[] x : isConnected) {
            g[x[0]].add(x[1]);
            g[x[1]].add(x[0]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int dept = dfs(i, g, visited);
                ans.add(dept);
            }
        }
        return ans.size();
    }

    private int dfs(int i, List<Integer>[] g, boolean[] visited) {
        visited[i] = true;
        int size = 1;
        for (Integer j : g[i]) {
            if (!visited[j]) {
                size += dfs(j, g, visited);
            }
        }
        return size;
    }


    public static void main(String[] args) {
        // [[1,1,0],[1,1,0],[0,0,1]]
        Q547_NumberOfProvinces q = new Q547_NumberOfProvinces();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(q.findCircleNumForTwo(isConnected));
        System.out.println(1);
    }
}
