class Solution {
    public long minCuttingCost(int n, int m, int k) {
        
        long cost = 0l;

        if(n > k){
            long rem = n - k;
            cost += k * rem;
        }
        if(m > k){
            long rem = m - k;
            cost += k * rem;
        }
        
        
        return cost;
    }
}