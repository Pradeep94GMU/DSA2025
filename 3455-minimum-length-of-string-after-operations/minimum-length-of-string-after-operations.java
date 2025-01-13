class Solution {
    public int minimumLength(String s) {

        if(s.length() < 3) return s.length();

        char[] str = s.toCharArray();

        for(int i = 1; i < str.length - 1; i++){

            if(str[i] == '*') continue;

            char currCh = str[i];
            //mere ko dekhna hai left and right side me
            boolean foundInLeft = false;
            int indexLeft = -1;
            for(int left = i - 1; left >= 0; left--){
                if(currCh == str[left]) {
                    foundInLeft = true;
                    indexLeft = left;
                    break;
                }
            }

            if(foundInLeft == false){
                continue;
            }

            //right me first khojo
            boolean foundInRight = false;
            int indexRight = -1;
            for(int right = i + 1; right < s.length(); right++){
                if(currCh == str[right]) {
                    foundInRight = true;
                    indexRight = right;
                    break;
                }

            }

            if(foundInRight == false){
                continue;
            }

            if(foundInRight && foundInLeft){
                str[indexLeft] = '*';
                str[indexRight] = '*';
            }

        }
        //System.out.println(Arrays.toString(str));

        int count = 0;

        for(char ch: str){
            if(ch != '*'){
                count++;
            }
        }

        return count;
        
    }
}