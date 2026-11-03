class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int n : nums)
            max = Math.max(max, n);

        for(int i=0;i<nums.length;i++){
            ans+=max-nums[i];
        }
        return ans;
    }
}