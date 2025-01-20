class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int cummSumMax = 0;
        int cummSumMin = 0;
        int res = 0;


        for(int i = 0; i < nums.length; i++){
            int currEle = nums[i];
            int totTillMax = cummSumMax + nums[i];
            int totTillMin = cummSumMin + nums[i];

            if(currEle >= totTillMax){
                res = Math.max(res, Math.abs(currEle));
                cummSumMax = currEle;
            }else{
                res = Math.max(res, Math.abs(totTillMax));
                cummSumMax += currEle;

            }

            if(currEle <= totTillMin){
                res = Math.max(res, Math.abs(currEle));
                cummSumMin = currEle;
            }else{
                res = Math.max(res, Math.abs(totTillMin));
                cummSumMin += currEle;

            }

            // System.out.println(nums[i]+" cummS "+totTillMax);
            // System.out.println(nums[i]+" cummS "+totTillMin);
            // System.out.println();
        }

        return Math.max(res,Math.max(cummSumMax, cummSumMin)) ;
        
    }
}