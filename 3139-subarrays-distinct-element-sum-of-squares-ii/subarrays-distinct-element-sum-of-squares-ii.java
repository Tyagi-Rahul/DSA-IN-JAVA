class Solution {
    static final int MOD = 1_000_000_007;

    int[] sum;
    int[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long currentSum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            long delta = queryAndAdd(1, 0, n - 1, prev + 1, i);
            currentSum = (currentSum + 2 * delta + i - prev) % MOD;
            ans = (ans + currentSum) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    long queryAndAdd(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            long result = sum[node];
            sum[node] = (int) ((sum[node] + (long) (end - start + 1)) % MOD);
            lazy[node]++;
            if (lazy[node] >= MOD) {
                lazy[node] -= MOD;
            }
            return result;
        }

        pushDown(node, start, end);

        int mid = start + (end - start) / 2;

        long result = 0;

        result += queryAndAdd(node * 2, start, mid, left, right);
        result += queryAndAdd(node * 2 + 1, mid + 1, end, left, right);

        sum[node] = (int) ((sum[node * 2] + (long) sum[node * 2 + 1]) % MOD);

        return result % MOD;
    }

    void pushDown(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = node * 2;
        int rightChild = node * 2 + 1;

        long value = lazy[node];

        sum[leftChild] = (int) ((sum[leftChild] + value * (mid - start + 1)) % MOD);
        sum[rightChild] = (int) ((sum[rightChild] + value * (end - mid)) % MOD);

        lazy[leftChild] = (int) ((lazy[leftChild] + value) % MOD);
        lazy[rightChild] = (int) ((lazy[rightChild] + value) % MOD);

        lazy[node] = 0;
    }
}