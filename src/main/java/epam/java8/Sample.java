package epam.java8;

//Find no of islands in a 2D matrix
public class Sample {

    public int noOfIslands(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }
        int noOfIslands = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    noOfIslands++;
                    dfs(mat, i, j);
                }
            }
        }

        return noOfIslands;
    }

    public void dfs(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }
        mat[i][j] = 0; // mark as visited

        dfs(mat, i + 1, j);
        dfs(mat, i - 1, j);
        dfs(mat, i, j + 1);
        dfs(mat, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(new Sample().noOfIslands(mat));
    }
}
