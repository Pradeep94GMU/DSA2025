class Solution {
    public boolean check(int[] nums) {
        // int min = nums[0];
        // int i = 0;

        // for( i = 1; i < nums.length; i++){
        //     if(nums[i] > nums[i - 1]) break;
        // }

        // System.out.println(i);

        // for(int j = i; j < nums.length; j++){
        //     System.out.println(nums[j]+" "+nums[j - 1]);
        //     if(nums[j] < nums[j - 1] && nums[j] > min) return false;
        // }
        // if(nums[nums.length - 1] > min) return false;
        // System.out.println("HUHUH");


        // return true;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]){
                if (flag == true){
                    return false;
                }
                flag = true;
            }
        }

        if (flag == false){
            return true;
        }else{
            return nums[nums.length-1] <= nums[0] ? true : false;
        }

        
    }
}