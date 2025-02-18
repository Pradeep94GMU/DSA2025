class Solution {
    public String smallestNumber(String pattern) {

        Stack<Integer> stk = new Stack();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= pattern.length(); i++){
            stk.add(i + 1);

            //if getting any i or last index then do the 
            if(i == pattern.length() || pattern.charAt(i) == 'I' ){
                //jitna bhi stack me entry hoga wo sabko resltu me dalo
                while(!stk.isEmpty()){
                    sb.append(stk.pop());
                }
            }
        }

        return sb.toString();
        
    }
}