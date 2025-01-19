class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList();

        int prev = lower - 1;

        for(int i = 0; i <= nums.length; i++){
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            //current boundry nikal liya
            if(prev + 1 <= curr - 1){ // -1 != 0 - 1 == -1
                List<Integer> inner = new ArrayList();
                inner.add(prev + 1) ;
                inner.add(curr - 1);
                res.add(new ArrayList<>(inner));
            }

            prev = curr;


        }

        return res;
        
    }
}