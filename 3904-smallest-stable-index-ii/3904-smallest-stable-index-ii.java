class Solution {
    public int firstStableIndex(int[] nums, int k) {
       int[] min = new int[nums.length];
       int max = nums[0];
       int current = Integer.MAX_VALUE;

       for(int i = nums.length -1; i>=0; i--){
            if(current>nums[i]){
               current = nums[i];
        }
        min[i] = current;
       } 
       for(int i = 0; i<nums.length; i++){
            max = Math.max(nums[i],max);
            if(max-min[i]<=k)return i;
       }
       return -1;
    }
}