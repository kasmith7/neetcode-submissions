class Solution {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        boolean[] set = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (set[i]) {
                continue;
            }
            counts[i] = nOnes(i);
            set[i] = true;

            for (int j = i * 2; j <= n; j <<= 1) {
                counts[j] = counts[i];
                set[j] = true;
            }
        }
        return counts;
    }

    private int nOnes(int n) {
        int bits = 0;
        while (n != 0) {
            bits += (n & 1);
            n >>= 1;
        }
        return bits;
    }
}
