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
                cummSumMax = currEle;
            }else{
                
                cummSumMax += currEle;

            }

            if(currEle <= totTillMin){
                
                cummSumMin = currEle;
            }else{
                
                cummSumMin += currEle;

            }
            res = Math.max(res, Math.abs(currEle));
            res = Math.max(res, Math.abs(totTillMax));
            res = Math.max(res, Math.abs(totTillMin));
            //res = Math.max(res, Math.abs(currEle));

            // System.out.println(nums[i]+" cummS "+totTillMax);
            // System.out.println(nums[i]+" cummS "+totTillMin);
            // System.out.println();
        }

        return Math.max(res,Math.max(cummSumMax, cummSumMin)) ;
        
    }
}