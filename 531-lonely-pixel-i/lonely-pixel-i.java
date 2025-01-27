class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int count = 0;
        int[] rC = new int[m];
        int[] cC = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //fill rC and cC
                if(picture[i][j] == 'B'){
                    rC[i]++;
                    cC[j]++;
                }
            }
        }

        //now for the secord pass, we just need to check if the count == 1 for that perticular r and c
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B' && rC[i] == 1 && cC[j] == 1){
                    count++;
                }
            }
        }


        return count;
        
        
    }

    
}