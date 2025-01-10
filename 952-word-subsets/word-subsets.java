class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList();

        //mujhe bas ye krna hai ki, harek char ka max nikal lo
        int[] maxFreq = new int[26];
        for(String inner: words2){
            int[] fre = getFreq(inner);
            //mujhe max update krna hai harek char ka jo mujhe baaad me khojna hai
            //max kyu kr rhe hai kyyuki, max khojeneg to chota wala automaticallyy mil jaeg
            for(int i = 0 ; i < 26; i++){
                maxFreq[i] = Math.max(maxFreq[i], fre[i]);
            }
            
        }


        for(String each: words1){
            //each la fre nikal lo and mere max wale se comapre kr lo
            int[] eachFreq = getFreq(each);
            if(isUniversal(eachFreq, maxFreq)){
                res.add(each);
            }
        }

        return res;
        
    }

    private int[] getFreq(String str){

        int[] freq = new int[26];
        for(char ch: str.toCharArray()){
            freq[ch - 'a']++;
        }

        return freq;
    }

    private boolean isUniversal(int[] eachFreq,int[] maxFreq){
        for(int i = 0; i < 26; i++){
            if(maxFreq[i] > eachFreq[i]){
                return false;
            }
        }
        return true;
    }
}