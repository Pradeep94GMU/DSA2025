class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        HashMap<Integer, int[]> map = new HashMap();
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rFreq = new int[m];
        int[] cFreq = new int[n];

        //ab mujhe find krna easy parega
        for(int i = 0; i < arr.length; i++){
            //find row and col
            int[] cell = map.get(arr[i]);
            int r = cell[0];
            int c = cell[1];

            //mujhe apna row adn col freq table update krna prega thats all
            rFreq[r]++;
            cFreq[c]++;
            if(rFreq[r] == n || cFreq[c] == m ) return i;

        }

        return 0;
        
    }
}