class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for (int []a:dp) {
            Arrays.fill(a, -1);
        }

        return LCS(nums1,nums2,0,0,dp);
    }
    public static int LCS(int [] s1, int [] s2, int i, int j, int[][] dp) {
        if (i == s1.length || j == s2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        if (s1[i] == s2[j]) {
            ans = 1 + LCS(s1, s2, i + 1, j + 1, dp);
        } else {
            int f1 = LCS(s1, s2, i + 1, j, dp);
            int f2 = LCS(s1, s2, i, j + 1, dp);

            ans = Math.max(f1, f2);
        }

        return dp[i][j] = ans;
    }
}