class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] findFarmland(int[][] land) {

        Queue<int[]> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList();


        

        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1){
                    //found the a land so start grouping into 1
                    //intial land ka r and c found
                    List<Integer> inner = new ArrayList();
                    inner.add(i);
                    inner.add(j);
                    q.offer(new int[]{i, j});
                    getLastLandCord(land, inner, q);
                    res.add(new ArrayList<>(inner));
                }
            }
        }
        System.out.println(res);
        //int[][] result = new int[300][300];
        if(res.size() == 0) return new int[0][0];
        
        int[][] result = new int[res.size()][res.get(0).size()];
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < res.get(0).size(); j++){
                result[i][j] = res.get(i).get(j);
            }
        }

        return result;
        
    }

    private void getLastLandCord(int[][] land,List<Integer> inner, Queue<int[]> q){
        int lastr = 0;
        int lastc = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            lastr = r;
            lastc = c;
            land[r][c] = 0;
            //search in 4 dir and update this
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length){
                    if(land[nr][nc] == 1){
                        land[nr][nc] = 0;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

        }

        inner.add(lastr);
        inner.add(lastc);
    }
}