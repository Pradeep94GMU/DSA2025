class Solution {
    public int[][] candyCrush(int[][] board) {

        //simulation game hai to aaram se krenge
        //mere target hai ki ek to endless loop chalega untill we are getting some value 
        boolean found = true;
        int M = board.length;
        int N = board[0].length;
        while(found){
            found = false;
            //curr value hai wo 3 yaa 3 se jyda hai to found sahi rhge, 

           for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    int currVal = Math.abs(board[i][j]);
                    if(currVal == 0) continue;
                    //find then next + 1, + 2 val
                    if(j < N - 2 &&  Math.abs(board[i][j + 1]) == currVal && Math.abs(board[i][j + 2]) == currVal){
                        found = true;
                        int idx = j;
                        //hame current index se le kar un sare index value ko mark krna prega haatane k liye
                        while(idx < N && Math.abs(board[i][idx]) == currVal) {
                            board[i][idx++] = -currVal;
                            }
                    }

                    //find then next + 1, + 2 val
                    if(i < M - 2 &&  Math.abs(board[i + 1][j]) == currVal && Math.abs(board[i + 2][j]) == currVal){
                        found = true;
                        int idx = i;
                        //hame current index se le kar un sare index value ko mark krna prega haatane k liye
                        while(idx < M && Math.abs(board[idx][j]) == currVal) 
                        {
                            board[idx++][j] = -currVal;
                        }
                    }
                }
           }
           //yaha tak aate aate, maine pura check kr liya ki kon sa hataya jaa skt ahai , to ab bas hata do
           if(found){
                for(int j = 0; j < N; j++){
                    //for each col, we need to go full down , meaning read each row from bottom till top and swap with only pos
                    int swapIdx = M - 1;
                    for(int i = M - 1; i >= 0; i--){
                        if(board[i][j] > 0){
                            board[swapIdx--][j] = board[i][j];
                        }
                    }
                     //hame baki bacha hua ko 0 se fill krna prega, from swaoIdx se 0 tak sare row ko 0 fill
                     for(int i = swapIdx; i >= 0; i--){
                        board[swapIdx--][j] = 0;
                     }
                }
           }

          
        }

        return board;
        
    }
}