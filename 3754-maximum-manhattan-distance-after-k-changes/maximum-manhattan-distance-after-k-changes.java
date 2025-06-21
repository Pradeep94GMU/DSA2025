class Solution {
    public int maxDistance(String s, int k) {

        int res = 0;
        int n = 0, ss = 0, e = 0, w = 0;

       for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'N'){
                n++;
            }else if(s.charAt(i) == 'W'){
                w++;
            }else if(s.charAt(i) == 'S'){
                ss++;
            }else if(s.charAt(i) == 'E'){
                e++;
            }
            int idealStep = i + 1;
            int md = Math.abs(n - ss) + Math.abs(e - w);

            int neededStep = Math.min(2 * k, idealStep - md);

            res = Math.max(md + neededStep, res);



        }

        return res;


        
    }
}