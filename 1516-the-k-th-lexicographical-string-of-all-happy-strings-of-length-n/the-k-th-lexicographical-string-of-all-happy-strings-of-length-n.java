class Solution {
    List<String> res = new ArrayList();
    String abc = "abc";
    public String getHappyString(int n, int k) {

        sol("", n, k);

        if(res.size() < k) return "";

        return res.get(k - 1);
        
    }

    private void sol(String curr, int n, int k){

        if(curr.length() == n){
            res.add(curr);
            return;
        }



        for(int i = 0; i < 3; i++){
            
            if(curr.length() == 0 || curr.charAt(curr.length() - 1) != abc.charAt(i)){
                sol(curr + abc.charAt(i), n,k);
            }
        }
    }
}