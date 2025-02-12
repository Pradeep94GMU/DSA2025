class Solution {
    public int maximumSum(int[] nums) {
        
        int res[] = new int[nums.length];
        HashMap<Integer, int[]> map = new HashMap<>();
        int val = 0;

        
        int globalMax = -1;
        
        
        for(int num: nums){
            val = 0;
            int max = num;
            int temp = num;
            while(temp > 0){
                val += temp % 10;
                temp = temp / 10;
            }
            if(!map.containsKey(val)){
                //map me nhi hai so val is max only
                map.put(val, new int[]{max, -1} );
                System.out.println("Firs: "+val+" "+Arrays.toString(map.get(val)));
            }
            else{
                int maxDig[] = map.get(val);
                
                if(max > maxDig[0]){
                    maxDig[1] = maxDig[0];
                    maxDig[0] = max;
                    
                }
                else if(max > maxDig[1]){
                    maxDig[1] = max;
                }
                //globalMax = Math.max(globalMax, max1 + max2);
                map.put(val,  maxDig);
                System.out.println("Sec: "+val+" "+Arrays.toString(map.get(val)));
            }
            
            //check here only, for globla max of each key
            int[] gl = map.get(val);
            if(gl[1] > -1){
                globalMax = Math.max(globalMax, gl[0] + gl[1]);
            }
            
        }
        
        
        return globalMax;
    }
}