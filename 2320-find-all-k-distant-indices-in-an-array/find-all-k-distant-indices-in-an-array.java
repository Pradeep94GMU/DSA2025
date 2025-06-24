class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        TreeSet<Integer> set = new TreeSet();
        TreeSet<Integer> set2 = new TreeSet();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key){
                set2.add(i);
            }
        }

        for(int n: set2){
            int left = Math.max(0, n - k);
            int right = Math.min(nums.length - 1, n + k);
            for(int j = left; j <= right; j++){
                set.add(j);
            }


        }

        List<Integer> res = new ArrayList();
        for(int n: set){
            res.add(n);
        }

        return res;
    }
}