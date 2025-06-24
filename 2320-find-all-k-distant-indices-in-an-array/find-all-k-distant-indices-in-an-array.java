class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        TreeSet<Integer> set = new TreeSet();
        

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key){
                int left = Math.max(0, i - k);
                int right = Math.min(nums.length - 1, i + k);
                for(int j = left; j <= right; j++){
                    set.add(j);
                }

            }
        }

        List<Integer> res = new ArrayList();
        for(int n: set){
            res.add(n);
        }

        return res;
    }
}