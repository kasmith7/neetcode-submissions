class Solution {
        
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; i++) {
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] == target) {
                int[] res = new int[2];
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
            
        }
        return new int[2];
    }
}
