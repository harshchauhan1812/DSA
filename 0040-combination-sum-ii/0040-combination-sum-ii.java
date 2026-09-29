class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates ,target, 0, 0,list);
        return ans;
    }
    public void solve (int nums[],int target, int sum , int i, List<Integer> list){
       if(sum==target){
          ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || i==nums.length){
            return;
        }
        //take
        list.add(nums[i]);
        solve (nums,target,sum+nums[i],i+1,list);
        list.remove(list.size()-1);

        //skip
        int j=i;
        while(j+1<nums.length && nums[j]==nums[j+1]){
            j++;
        }
        solve(nums, target, sum , j + 1, list);
    }
}