class Solution {
    public int addDigits(int num) {

        String n = ""+num;
        

        while(n.length() >= 2){
            int res = 0;
            for(char ch: n.toCharArray()){
                int val = (int)ch - '0';
                res += val;
            }
            //System.out.println(res);
            n = ""+res;
        }

        return Integer.parseInt(n);
        
    }
}