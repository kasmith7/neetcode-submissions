class Solution {
    public int[] productExceptSelf(int[] nums) {

        // if (nums.length == 2) {
        //     nums[0] ^= nums[1];
        //     nums[1] ^= nums[0];
        //     nums[0] ^= nums[1];
        // }


        int len = nums.length;

        int[] rPass = new int[len];
        int[] lPass = new int[len];

        rPass[0] = nums[0];
        lPass[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            rPass[i] = rPass[i-1] * nums[i];
            lPass[len - i - 1] = lPass[len - i] * nums[len - i - 1];
        }

        nums[0] = lPass[1];
        nums[len - 1] = rPass[len - 2];

        for (int i = 1; i < len - 1; i++) {
            nums[i] = rPass[i - 1] * lPass[i + 1];
        }
        return nums;

        // Input: nums = [1,2,4,6]
        //mul right
        // 1 2 8 48
        //mul left
        // 48 48 24 6

        // Output: [48,24,12,8]   

    }
}  
