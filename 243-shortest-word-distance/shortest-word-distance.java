class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int idx1 = -1, idx2 = -1;
        int res = 1000000;

        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                idx1 = i;
            }
            if(wordsDict[i].equals(word2)){
                idx2 = i;
            }

            if(idx1 != -1 && idx2 != -1){
                //kahi bich me dono idx hai then just compare the diff
                int diff = Math.abs(idx2 - idx1);
                res = Math.min(res, diff);
            }


        }

        // Collections.sort(a);
        // Collections.sort(b);

        // System.out.println(a);
        // System.out.println(b);
        // //just cross compare
        // int diff1 = Math.abs(b.get(b.size() - 1) - a.get(0));
        // int diff2 = Math.abs(a.get(a.size() - 1) - b.get(0));
        // int diff3 = Math.abs(a.get(0) - b.get(0));
        // int diff4 = Math.abs(a.get(a.size() - 1) - b.get(b.size() - 1));

        //int res = Math.min(diff1, Math.min(diff2, Math.min(diff3, diff4)));
        
        // for(int i = 0; i < a.size(); i++){
        //     for(int j = 0; j < b.size(); j++){
        //         int diff = Math.abs(a.get(i) - b.get(j));
        //         res = Math.min(res, diff);
        //     }
        // }

        return res;
        

    }
}