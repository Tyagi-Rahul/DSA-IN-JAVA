class Solution {
    public int maxCoins(int[] nums) {
        int [] a= new int[nums.length+2];
        a[0]=a[a.length-1]=1;
        for (int i = 0; i < nums.length; i++) {
            a[i + 1] = nums[i];
        }
        int[][] dp = new int[a.length][a.length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return max_coin(a, 0, a.length - 1, dp);

    }

    public static int  max_coin(int[]nums,int si,int ei,int[][]dp){
        if(si+1==ei){
            return 0;
        }
        int ans=Integer.MIN_VALUE;
        if (dp[si][ei] != -1) {
            return dp[si][ei];
        }
        for(int i=si+1;i<ei;i++){
            int l = max_coin(nums,si,i,dp);
            int r = max_coin(nums,i,ei,dp);
            int s =nums[si]*nums[i]*nums[ei];
            int t=l+r+s;
            ans=Math.max(ans,t);
        }
        return dp[si][ei]=ans;
    }
}