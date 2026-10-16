class Solution {
    int MOD = 1_000_000_007;
    long[] sum, sumSq;
    int[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new int[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int prev = last.getOrDefault(num, -1);

            update(1, 0, n - 1, prev + 1, i, 1);
            ans = (ans + query(1, 0, n - 1, 0, i)) % MOD;

            last.put(num, i);
        }

        return (int) ans;
    }

    private void apply(int node, int l, int r, int val) {
        long len = r - l + 1L;
        long oldSum = sum[node];

        sumSq[node] = (sumSq[node]
                + 2L * val * oldSum
                + len * val * val) % MOD;

        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] += val;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) return;

        int mid = l + (r - l) / 2;

        apply(node * 2, l, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, r, lazy[node]);

        lazy[node] = 0;
    }

    private void update(int node, int l, int r,
                        int ql, int qr, int val) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }

        push(node, l, r);

        int mid = l + (r - l) / 2;

        update(node * 2, l, mid, ql, qr, val);
        update(node * 2 + 1, mid + 1, r, ql, qr, val);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }

    private long query(int node, int l, int r,
                       int ql, int qr) {
        if (ql > r || qr < l) return 0;

        if (ql <= l && r <= qr) {
            return sumSq[node];
        }

        push(node, l, r);

        int mid = l + (r - l) / 2;

        return (query(node * 2, l, mid, ql, qr)
                + query(node * 2 + 1, mid + 1, r, ql, qr))
                % MOD;
    }
}