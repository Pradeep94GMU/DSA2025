class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        //3 variable hote hai yaha
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] res = new int[m][n]; // given m * k -> k * n then res have m * n mat lenge

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int x = 0; x < k; x++){
                   // System.out.println(i+" "+j+" "+k);
                    res[i][j] += mat1[i][x] * mat2[x][j];
                }
            }
        }

        return res;


        
    }
}