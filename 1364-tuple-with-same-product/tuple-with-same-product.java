class Solution {
    public int tupleSameProduct(int[] nums) {

        if(nums.length < 4) return 0;
        int count = 0;

        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < nums.length; j++){
        //         for(int k = 0; k < nums.length; k++){
        //             for(int l = 0; l < nums.length; l++){
        //                 if(i == j || j == k || k == l || i == k) continue;
        //                 if(nums[i] * nums[j] == nums[k] * nums[l]){
        //                     //System.out.println(i+" "+j+" "+k+" "+l);
        //                     count++;
        //                 }

        //             }
        //         }
        //     }
        // }
        // diya hua hai: a * b = c * d 
        //  rewrite: a = (c * d / b)

        //set ager nikal lu
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }

        int res = 0;

        for(int key: map.keySet()){
            if(map.get(key) > 1){
                int val = map.get(key);
                // if values are more than 1 meang we can form the pair of 4
                // choose 2 out of pairs, nC2 = (n * n - 1 / 2)
                // as we need to make 4 element pair, so total permutation cn be 8 with 8 elemetns, thus  nC2 * 8 = (n * n - 1 / 2) * 8 == (n * (n - 1 )* 4
                res += val * (val - 1) * 4;
            }
        }

        return res;
         
    }
}