class Solution {
    public int[] distinctNumbers(int[] nums, int k) {

        //untill i maatch the window size, i cna ajust add into window and set allso
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[nums.length - k + 1];
        int x = 0;

        int i = 0;
        int j = 0;
        while(j < nums.length){

            if(j - i + 1 <= k){
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }else{
                //window pura ho gya
                res[x++] = map.size();
                map.put(nums[i],map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;

            }
        }

        res[x] = map.size();

        return res;
        
    }
}