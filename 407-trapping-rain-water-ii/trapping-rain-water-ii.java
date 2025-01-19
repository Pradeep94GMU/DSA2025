class Solution {
    public int trapRainWater(int[][] h) {

        if(h.length < 3) return 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int m = h.length;
        int n = h[0].length;
        //spiral reading....
        boolean[][] vis = new boolean[h.length][h[0].length];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new int[]{h[i][j], i, j});
                    vis[i][j] = true;
                }
            }
        }


        // for(int[] each: minHeap){
        //     System.out.println(Arrays.toString(each));
        // }

        //for each entry, see which one is 

        System.out.println(Arrays.deepToString(vis));
        int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        int trapWater = 0;

        while(!minHeap.isEmpty()){
            int[] each = minHeap.poll();
            int height = each[0];
            int r = each[1];
            int c = each[2];

            for(int[] dir: dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && !vis[newR][newC]){
                    vis[newR][newC] = true;

                    //cal trap water
                    trapWater += Math.max(0, (height - h[newR][newC]));

                    //update the pq
                    minHeap.offer(new int[]{ Math.max(height, h[newR][newC]) , newR, newC});

                }
            }
        }



        return trapWater;
        
    }
}