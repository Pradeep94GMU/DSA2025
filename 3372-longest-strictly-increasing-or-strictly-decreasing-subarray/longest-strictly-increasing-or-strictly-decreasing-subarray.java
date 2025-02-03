class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int max = 1;
        int len = 1;

        //now run left to right and check which is max,

        for(int i = 1; i < nums.length; i++){
            if(nums[i]  > nums[i - 1]){
                len++;
            }else{
                len = 1;
            }
            max = Math.max(len, max);
        }

         //run right to left to check which is max

        len = 1;

        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i]  < nums[i - 1]){
                len++;
            }else{
                len = 1;
            }
            max = Math.max(len, max);
        }


       
        return max;
        
    }
}