class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        List<Integer> a = new ArrayList();
        List<Integer> b = new ArrayList();

        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                a.add(i);
            }
            if(wordsDict[i].equals(word2)){
                b.add(i);
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
        int res = 1000000;
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                int diff = Math.abs(a.get(i) - b.get(j));
                res = Math.min(res, diff);
            }
        }

        return res;
        

    }
}