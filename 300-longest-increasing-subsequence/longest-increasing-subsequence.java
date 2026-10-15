class Solution {
    public int lengthOfLIS(int[] nums) {
        return LTS(nums);
    }

    public static int LTS(int[] arr){
        int n=arr.length;
        int [] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    int x = dp[j];
                    dp[i]=Math.max(dp[i],x+1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}