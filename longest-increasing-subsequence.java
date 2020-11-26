class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        //recursive memoization
        Integer[][] memo = new Integer[nums.length+1][nums.length];
        return recurse(memo, -1, 0, nums);
        
    }
    public int recurse(Integer[][] memo, int previndex, int index, int[] nums){
        if(index==nums.length)return 0;
        int include = 0;
        if(memo[previndex+1][index]!=null)
            return memo[previndex+1][index];
        else if(previndex==-1 || nums[previndex]<nums[index]){
            include = 1+ recurse(memo, index, index+1, nums);
        }
        memo[previndex+1][index] = Math.max(include, recurse(memo, previndex, index+1, nums));
        return memo[previndex+1][index];
    }
}
