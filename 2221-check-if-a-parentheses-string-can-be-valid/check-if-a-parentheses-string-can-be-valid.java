class Solution {
    public boolean canBeValid(String s, String locked) {

        int n = s.length();
        if(n % 2 == 1) return false;
        Stack<Integer> open = new Stack();
        Stack<Integer> openClose = new Stack();

        for(int i = 0; i < n; i++){

           //ager sirf 0 hua lock to add openclose me
           if(locked.charAt(i) == '0'){
            openClose.add(i);
           }
           else if(locked.charAt(i) == '1' && s.charAt(i) == '('){
            open.add(i);
           }else if(locked.charAt(i) == '1' && s.charAt(i) == ')'){
                if(open.isEmpty()  && openClose.isEmpty()) return false;
                if(!open.isEmpty()){
                    open.pop();
                }else if(!openClose.isEmpty()){
                    openClose.pop();
                }
           }
            
        }

        if(!open.isEmpty() && openClose.size() < open.size()) return false;

        while(!open.isEmpty()){
            int idxOfOpen = open.pop();
            if(openClose.peek() < idxOfOpen) return false;
            else openClose.pop();
        }

        return true;
        
    }
}