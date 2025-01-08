class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                   // System.out.println(words[i] +" : " +words[j]);
                    count++;
                }
            }
        }

        return count;
        
    }

    private boolean isPrefixAndSuffix(String s1, String s2){
         //System.out.println("origi "+s1 + " : " + s2);
        if(s1.length() <= s2.length()){
            String pre = s2.substring(0, s1.length());
            String suf = s2.substring(s2.length() - s1.length());
            //System.out.println(pre +" : "+suf);
            return pre.equals(suf) && pre.equals(s1);
        }

        return false;
    }
}