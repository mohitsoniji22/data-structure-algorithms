package com.leetcode.blind75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    * Problem Link: https://leetcode.com/problems/pacific-atlantic-water-flow/
    * Difficulty: Medium
    * Category: Graph, Depth-First Search, Breadth-First Search, Matrix
    * Description:
    * Given an m x n matrix of non-negative integers representing the height of each unit
    * cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix
    * and the "Atlantic ocean" touches the right and bottom edges.
    * Water can only flow in four directions (up, down, left, or right) from a cell
 */
public class PacificAtlanticWaterFlow417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific borders (top row, left col)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
        }

        // DFS from Atlantic borders (bottom row, right col)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);
        }

        List<List<Integer>> res = new ArrayList<>();

        // Cells visited by both → result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int rows, int col, int prevHeight) {

        // out of bounds
        if (rows < 0 || col < 0 || rows >= heights.length || col >= heights[0].length) return;

        // must not go downhill in reverse flow
        if (heights[rows][col] < prevHeight || ocean[rows][col]) return;


        ocean[rows][col] = true;

        // explore neighbors
        dfs(heights, ocean, rows + 1, col, heights[rows][col]);
        dfs(heights, ocean, rows - 1, col, heights[rows][col]);
        dfs(heights, ocean, rows, col + 1, heights[rows][col]);
        dfs(heights, ocean, rows, col - 1, heights[rows][col]);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow417 solver = new PacificAtlanticWaterFlow417();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solver.pacificAtlantic(heights);

        System.out.println("Cells where water can flow to both oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
