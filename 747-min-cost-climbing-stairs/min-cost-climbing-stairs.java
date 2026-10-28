class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int zero_th = Min_Cost(cost,0,dp);
        int one_th = Min_Cost(cost,1,dp);
        return Math.min(zero_th,one_th);
    }

    public static int Min_Cost(int [] cost,int i,int[] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int  f=Min_Cost(cost,i+1,dp);
        int  s=Min_Cost(cost,i+2,dp);
        return dp[i]=cost[i]+Math.min(f,s);
    }
}