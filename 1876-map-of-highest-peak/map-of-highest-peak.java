class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int r = isWater.length;
        int c = isWater[0].length;

        //water cell se aas pass wale sabko ager fill kr de to easily manage kr skte hai heugh
        int[][] res = new int[r][c];

        //fill with no vis mark
        for(int i = 0; i < r; i++){
            Arrays.fill(res[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        //ass pass wale sbko 1 level jo hai usko fill krna hai so it is like bfs,
        //need a starting point, so start with 0 cell
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(isWater[i][j] == 1){
                    //water hai yaha
                    res[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            //one by one chalna hai
            int[] cell = q.poll();
            
            for(int[] dir: dirs){
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if(nr >= 0 && nr < r && nc >= 0 && nc < c){
                    //also should be gaddda here
                    if(res[nr][nc] == -1){
                        //tabhi fill kr skte hai
                        res[nr][nc] = res[cell[0]][cell[1]] + 1;
                        q.offer(new int[]{nr, nc});

                    }
                }
            }
        }

        return res;
        
    }
}