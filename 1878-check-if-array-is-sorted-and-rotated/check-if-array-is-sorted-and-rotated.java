class Solution {
    public boolean check(int[] nums) {

        //i need to rotate this numbers 
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        if(checkSame(nums, sorted)) return true;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                //i + 1 wala index se last tak mujhe swap krna hai naye aarray me
                int[] swapped = new int[nums.length];
                int start = 0;
                for(int idx = i + 1; idx < nums.length; idx++){
                    swapped[start++] = nums[idx];
                }
                for(int idx = 0; idx <= i; idx++){
                    swapped[start++] = nums[idx];
                }
                if(checkSame(swapped, sorted)) return true;
            }
        }

        return false;
        
    }


    private boolean checkSame(int[] a, int[] b){
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}