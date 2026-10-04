class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int hi = numbers.length - 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            int lo = i + 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (numbers[mid] + numbers[i] == target) {
                    int[] res = new int[2];
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
                else if (numbers[mid] + numbers[i] < target) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        return new int[] {0, 0};
    }

    private int bs(int[] numbers, int i, int x) {
        int lo = i, hi = numbers.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (numbers[mid] == x) {
                return mid;
            }

            else if (numbers[mid] > x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return -1;

    }
}
