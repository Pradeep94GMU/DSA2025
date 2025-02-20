class Solution {
    String bin = "01";
    List<String> res = new ArrayList();
    public String findDifferentBinaryString(String[] nums) {

        int len = nums.length;

        //find the binary string of length len
        findAllBinary("", len );

        HashSet<String> set = new HashSet();

        for(String each: nums){
            set.add(each);
        }

        for(String each: res){
            if(!set.contains(each)){
                return each;
            }
        }

        return "";
 
    }

    private void findAllBinary(String str, int len ){
        if(str.length() == len){
            res.add(str);
            return;
        }


        for(int i = 0; i < 2; i++){ //for pos            
            findAllBinary(str + bin.charAt(i), len);
        }
    }
}