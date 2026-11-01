class Solution {

    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int n : nums)
            min = Math.min(min, n);

        for (int n : nums)
            ans += n - min;

        return ans;
    }
}