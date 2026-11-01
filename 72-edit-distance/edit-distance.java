class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for (int []a:dp) {
            Arrays.fill(a, -1);
        }

        return minTD(word1, word2, 0, 0, dp);
    }

    public int minTD(String w1,String w2,int i,int j,int[][] dp){
        if(i==w1.length()){
            return w2.length()-j;
        }
        if(j==w2.length()){
            return w1.length()-i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans=0;
        if(w1.charAt(i)==w2.charAt(j)){
            ans=minTD(w1,w2,i+1,j+1,dp);
        }else{
            int in=minTD(w1,w2,i,j+1,dp);
            int d=minTD(w1,w2,i+1,j,dp);
            int r=minTD(w1,w2,i+1,j+1,dp);
            ans=1+Math.min(in,Math.min(d,r));
        }
        return dp[i][j]=ans;

    }
}