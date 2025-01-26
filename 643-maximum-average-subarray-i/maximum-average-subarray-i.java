class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int i = 0;
        int j = 0;
        double sum = 0;
        double res = -100000;

        //if(nums.length == k) return 

        while(j < nums.length){

            if(j - i + 1 <= k){
                sum += (double)nums[j];
               
                if(j - i + 1 == k){
                    // System.out.println(sum+" "+ (j - i + 1));
                    res = Math.max(res, (sum / (j - i + 1)));
                    System.out.println(res);
                }
                j++;
            }else{
                sum -= (double)nums[i];
                i++;
            }
        }

        return res;
        
    }
}