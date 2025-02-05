class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        HashSet<Character> set = new HashSet();
        int[] freq1 = new int[26];
        for(char ch : s2.toCharArray()){
            freq1[ch - 'a']++;
        }
        int[] freq2 = new int[26];
        for(char ch : s1.toCharArray()){
            freq2[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++){
           if( freq1[i] != freq2[i]) return false;
        }

        // set.clear();
        // for(char ch : s1.toCharArray()){
        //     set.add(ch);
        // }

        // for(char ch: s2.toCharArray()){
        //     if(!set.contains(ch)) return false;
        // }
        // set.clear();
        int count = 0;

        for(int i = 0; i < s2.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                set.add(s1.charAt(i));
                set.add(s2.charAt(i));
                count++;

                if(count > 2) return false;

                // if(set.size() > 2) return false;
            }
        }

        // return true;

        return true;

        
    }
}