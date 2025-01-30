class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // Step 1: Construct the adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        //check bipartite graph
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int node = 0; node < n; node++){
            if(color[node] == -1){
                if(isBipartite(graph, node, color, 1) == false){
                    return -1;
                }
            }
        }

        //now as we are here so we are sure valid bipaartitie so now call bfs to find max length depth
        
        int[] levels = new int[n];

        for(int node = 0; node < n; node++){
            levels[node] = bfs(graph, node, n);
        }


        //find max grp from each cpmponent
        int maxGroups = 0;
        boolean[] visited = new boolean[n];

        for(int node = 0; node < n; node++){
            if(!visited[node]){
                maxGroups += findMaxFromEachComponent(graph, node, visited, levels);
            }
        }


        return maxGroups;
    }


    private boolean isBipartite(Map<Integer, List<Integer>> graph, int curr, int[] color, int currColor){
        color[curr] = currColor;

        for(int parosi: graph.get(curr)){
            //check kro ki dono parsi same color ka to nhi
            if(color[curr] == color[parosi]) return false;

            if(color[parosi] == -1){
                if(isBipartite(graph, parosi, color, 1 - currColor) == false){
                    return false;
                }
                
            }
        }

        return true;
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start, int n) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);  // {node} 
        vis[start] = true;

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(int parosi: graph.get(curr)){
                    if(vis[parosi]) continue;

                    q.offer(parosi);
                    vis[parosi] = true;
                }
            }
            level++;
        }
        return level - 1;
    }

    private int findMaxFromEachComponent(Map<Integer, List<Integer>>graph, int node,boolean[] visited,int[] level){
        int maxGrp = level[node];
        visited[node] = true;

        for(int parosi: graph.get(node)){
            if(!visited[parosi]){
               maxGrp = Math.max(maxGrp, findMaxFromEachComponent(graph, parosi, visited, level));
            }
        }

        return maxGrp;

    }


}