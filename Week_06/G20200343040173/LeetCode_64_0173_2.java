/**
 * 64. 最小路径和
 * 
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 解法 2：二维动态规划
 * 最后返回结果是最小路径的和
 * 我们每次向右或者向下走，最小路径和 = 拿当前的值 + min(向右一步，向下一步)
 * 
 * dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
 * 
 * 时间复杂度 ：O(mn)。遍历整个矩阵恰好一次。
 * 空间复杂度 ：O(mn)。额外的一个同大小矩阵。
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] dp = new int[rowSize][colSize];

        for (int i = rowSize - 1; i >= 0; i--) {
            for (int j = colSize - 1; j >= 0; j--) {
                if (i == rowSize - 1 && j != colSize - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != rowSize - 1 && j == colSize - 1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if (i != rowSize - 1 && j != colSize - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}