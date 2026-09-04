class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int max = nums[0];
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            int min = nums[i];

            for (int j = i + 1; j < len; j++) {
                min = Math.min(min, nums[j]);
            }

            max = Math.max(max, nums[i]);

            if ((max - min) <= k) {
                return i;
            }
        }

        return -1;
    }
}