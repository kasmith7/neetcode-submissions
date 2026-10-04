class Solution {
    public int longestConsecutive(int[] nums) {
       Arrays.sort(nums);
       int curr = Integer.MIN_VALUE;
       int seqLen = 0;
       int res = 0;
       for (int n : nums) {
        if (n == curr) {
            continue;
        }
        else if (n == curr + 1) {
            seqLen++;
        }
        else {
            seqLen = 1;
        }
        curr = n;
        if (seqLen > res) {
            res = seqLen;
        }
       }
        return res;
    }
}
