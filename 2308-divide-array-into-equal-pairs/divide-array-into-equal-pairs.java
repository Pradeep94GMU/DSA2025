class Solution {
    public boolean divideArray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap();

        for(int n: nums){
            if(map.containsKey(n)){
                map.remove(n);
            }else{
                map.put(n, 1);
            }
        }

        return map.size() == 0;
        
    }
}