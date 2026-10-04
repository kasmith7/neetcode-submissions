class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixProduct = new int[len]; 

        int x = 1;
        for (int i = 0; i < len; i++) {
            x *= nums[i];
            prefixProduct[i] = x;
        }

        x = 1;
        for (int i = len - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = x * prefixProduct[i - 1];
            x *= tmp;
        }
        nums[0] = x;
        return nums;

    }
}  
