class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int highestPossible = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1 ; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int pair = nums[i] + nums[j];

                int lo = j + 1, hi = highestPossible;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if (pair + nums[mid] == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[mid]);
                        res.add(tmp);
                        highestPossible = mid;
                        break;
                    }
                    else if (pair + nums[mid] < 0) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid - 1;
                    }
                }


                // //////NAIVE O(n^3)
                // for (int k = j + 1; k < nums.length; k++) {

                //     if (k > j + 1 && nums[k] == nums[k-1]) continue;
                //     if (pair + nums[k] == 0) {
                //         var tmp = new ArrayList<Integer>();
                //         tmp.add(nums[i]);
                //         tmp.add(nums[j]);
                //         tmp.add(nums[k]);
                //         res.add(tmp);
                //     }
                //     
                // }
                //////
            }
        }
        return res;


    }
}
