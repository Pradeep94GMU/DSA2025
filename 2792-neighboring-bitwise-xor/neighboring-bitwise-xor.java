class Solution {
    public boolean doesValidArrayExist(int[] d) {
        int n = d.length;
        int[] a1 = new int[n];
        int[] a2 = new int[n];

        //first pos will have max 2 options
        a1[0] = 0;
        a2[0] = 1;

        for(int i = 1; i < n; i++){
            a1[i] = (a1[i - 1] ^ d[i - 1]);
            a2[i] = (a2[i - 1] ^ d[i - 1]);
        }

        //bas last wala check kr lo
        boolean opt1 = (a1[n - 1] ^ a1[0]) == d[n - 1];
        boolean opt2 = (a2[n - 1] ^ a2[0]) == d[n - 1];

        return opt1 || opt2; //dono me se koi ek bhi sahi de de
        
    }
}