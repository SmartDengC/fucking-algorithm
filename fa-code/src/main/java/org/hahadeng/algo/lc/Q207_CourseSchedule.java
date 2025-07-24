package org.hahadeng.algo.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 课程表
 * <a href="https://leetcode.cn/problems/course-schedule/description/">...</a>
 * <p>
 * 返回true表示能够完成所有课程，没有环。
 * 如果返回false表示不能完成所有课程，表示有环
 *
 * @author 邓聪
 * @since 2025/7/23 18:31
 */
public class Q207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建有向图
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        // 定义一个大小为numCourses的数组，然后遍历
        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 如果节点被访问
            if (colors[i] == 0 && dfs(i, g, colors)) {
                return false;
            }
        }
        return true;
    }

    /**
     * dfs遍历， 判断有没有环
     * 0 未访问 1 正在访问 2 已经访问
     * 如果领节点被访问了，表示有环；如果领节点没有访问，但是递归节点被访问了，表示有环。
     *
     * @param x      节点坐标
     * @param g      图
     * @param colors 节点的访问状态
     */
    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1;

        for (int y : g[x]) {
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) {
                return true;
            }
        }

        colors[x] = 2;
        return false;
    }

    public static void main(String[] args) {

        // g 是一个数组，数据每个元素都是一个列表
        List<Integer>[] g = new ArrayList[10];
        Arrays.setAll(g, x -> new ArrayList<>(Collections.singletonList(1)));

        // List[[]]
        System.out.println(1);

    }
}
