class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B'){
                    //check kro ki iske row and col me koi black to nhi
                    if(noBlackFoundInRC(picture, i, j)){
                        count++;
                    }
                }
            }
        }

        return count;
        
    }

    private boolean noBlackFoundInRC(char[][] picture, int i, int j){ // i = 0, j = 2
        //check in row 
        int m = picture.length;
        int n = picture[0].length;
        for(int row = 0; row < m; row++){
            //har row ke j col me check krna prega
            if(row == i) continue;
            if(picture[row][j] == 'B') return false;
        }

        //har col me check kaise krenge?? row fix krke
        for(int col = 0; col < n; col++){
            if(col == j) continue;
            if(picture[i][col] == 'B') return false;
        }

        return true;
    }
}