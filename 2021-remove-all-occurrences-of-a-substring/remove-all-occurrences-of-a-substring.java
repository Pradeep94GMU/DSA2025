class Solution {
    public String removeOccurrences(String s, String part) {

        int i = 0;
        int len = s.length();
        while(s.contains(part)){
            int idx = s.indexOf(part);
            String first = s.substring(0, idx);
            String sec = s.substring(idx + part.length(), s.length());
            //System.out.println(first+" "+sec);

            s = first + sec;
        }

        return s;
        
    }
}