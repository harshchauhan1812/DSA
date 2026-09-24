public class Solution {
    int cnt;
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        
        solve(nums, 0, 0, target);

        return cnt;
    }

    void solve(int[] nums, int idx, int sum, int target){
        if(idx==nums.length){
            if(sum==target){
                cnt++;
            }
            return;
        }

        solve(nums, idx+1, sum+nums[idx], target);
        solve(nums, idx+1, sum-nums[idx], target);
        
    }

}