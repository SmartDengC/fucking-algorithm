package org.hahadeng.algo.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 邓聪
 * @since 2025/7/30 15:59
 */
public class Q2368_ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] rst = new boolean[n];
        for (int x : restricted) {
            rst[x] = true;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, x -> new ArrayList<>());

        for (int[] e : edges) {
            int x = e[0], y = e[1];
            // 只有值不都不受限制，才添加到树上
            if (!rst[x] && !rst[y]) {
                g[x].add(y);
                g[y].add(x);
            }
        }

        boolean[] visited = new boolean[n];
        dfs(0, g, visited, rst);

        int ans = 0;
        for (boolean b : visited) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int x, List<Integer>[] g, boolean[] visited, boolean[] rst) {
        visited[x] = true;
        for (int y : g[x]) {
            if (!visited[y] && !rst[y]) {
                dfs(y, g, visited, rst);
            }
        }
    }

    public static void main(String[] args) {

        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = {4, 5};


        int x = new Q2368_ReachableNodesWithRestrictions().reachableNodes(n, edges, restricted);
        System.out.println(x);
    }
}
