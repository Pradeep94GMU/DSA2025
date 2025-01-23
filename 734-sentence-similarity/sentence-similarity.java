class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if(sentence1.length != sentence2.length) return false;
       
        
        int n = sentence1.length;

        HashSet<String> simPairs = new HashSet();
        for(List<String> each: similarPairs){
            simPairs.add(each.get(0)+","+each.get(1));
            simPairs.add(each.get(1)+","+each.get(0));
        }

        System.out.println(simPairs);

        for(int i = 0; i < n; i++){
            String s1 = sentence1[i];
            String s2 = sentence2[i];

            // if(!s1.equals(s2) && ( similarPairs.size() > 0 && similarPairs.contains(s1+","+s2))
            //     &&( similarPairs.size() > 0 && similarPairs.contains(s2+","+s1))
            //     ) { 

            //     // System.out.println(s1+" "+similarPairs.get(i).contains(s1));
            //     // System.out.println(s2+" "+similarPairs.get(i).contains(s2));
            //     return false;
            // }

            if(!s1.equals(s2) && !simPairs.contains(s1+","+s2) ) return false;
            
        }

        return true;


        
    }
}