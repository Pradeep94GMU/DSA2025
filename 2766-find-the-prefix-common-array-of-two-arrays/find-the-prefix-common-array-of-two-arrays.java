class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        Set<Integer> set = new HashSet();
        int[] ans = new int[A.length];
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
            set.add(B[i]);

            int totalExpSize = (i + 1 ) * 2;
            ans[i] = totalExpSize - set.size();
        }

        return ans;
        
    }
}