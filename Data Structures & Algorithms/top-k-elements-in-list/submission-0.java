class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[][] buckets = new int[2001][2];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i][1] = i - 1000;
        }

        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 1000][0]++;
        }

        int[] res = new int[k];
        int x = 0;
        Arrays.sort(buckets, (a, b) -> a[0] - b[0]);
        for (int i = buckets.length - 1; i >= buckets.length - k; i--) {
            res[x++] = buckets[i][1];
        }
        return res;
    }
}
