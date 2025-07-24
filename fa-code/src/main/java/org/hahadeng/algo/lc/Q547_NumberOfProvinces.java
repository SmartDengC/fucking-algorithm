package org.hahadeng.algo.lc;

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
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans++;
                dfs(i, isConnected, vis);
            }
        }
        return ans;

    }

    private void dfs(int i, int[][] isConnected, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                dfs(j, isConnected, vis);
            }
        }
    }
}
