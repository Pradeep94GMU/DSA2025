class Solution {
    public int largestUniqueNumber(int[] nums) {

        int[] freq = new int[2002];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }

        for(int i = freq.length - 1; i>=0; i--){
            if(freq[i] == 1) return i;
        }

        return -1;

        
    }
}