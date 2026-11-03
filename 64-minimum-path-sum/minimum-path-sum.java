class Solution {
    public int minPathSum(int[][] grid) {
        // if(grid==null||grid.length==0||grid[0].length==0){
        //     return 0;
        // }
        // int rows=grid.length,columns=grid[0].length;
        // int[][] dp=new int[rows][columns];
        // dp[0][0]=grid[0][0];
        // for(int i=1;i<rows;i++){
        //     dp[i][0]=dp[i-1][0]+grid[i][0];
        // }
        // for(int j=1;j<columns;j++){
        //     dp[0][j]=dp[0][j-1]+grid[0][j];
        // }
        // for(int i=1;i<rows;i++){
        //     for(int j=1;j<columns;j++){
        //         dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        //     }
        // }
        // return dp[rows-1][columns-1];

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return TD(grid,0,0,dp);
    }

    public static int TD(int[][]grid , int r,int c,int[][]dp){
        if(r==grid.length-1 && c==grid[0].length-1){
            return grid[r][c];
        }
        if(r>=grid.length || c>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        int right=TD(grid,r+1,c,dp);
        int down=TD(grid,r,c+1,dp);
        return dp[r][c]=Math.min(right,down)+grid[r][c];

    }
}