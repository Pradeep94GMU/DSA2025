class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;

        // aas we understand that if we found a pair, which match then total 8 perm we can make, so for every new pair found, we need to * 8 times to the res
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int prod = nums[i] * nums[j];
                res += 8 * map.getOrDefault(prod, 0);
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }

        return res;
        
    }
}