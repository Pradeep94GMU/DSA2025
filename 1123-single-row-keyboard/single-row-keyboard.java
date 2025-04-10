class Solution {
    public int calculateTime(String keyboard, String word) {

        HashMap<Character, Integer > map = new HashMap();
        int i = 0;
        for(char ch: keyboard.toCharArray()){
            map.put(ch, i);
            i++;
        }

        int timeTaken = 0;
         i = 0;
        for(char ch: word.toCharArray()){
            int j = map.get(ch);
            timeTaken += Math.abs(i - j);
            i = j;
            
        }
        return timeTaken;
        
    }
}