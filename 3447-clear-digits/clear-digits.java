class Solution {
    public String clearDigits(String s) {

        Stack<Character> stk = new Stack();
        for(char ch: s.toCharArray()){
            if(!Character.isDigit(ch)){
                stk.add(ch);
            }else{
                if(!stk.isEmpty()) stk.pop();

            }
        }


        String res = "";

        for(char ch: stk){
            res += ch;
        }
        return res;
    }
}