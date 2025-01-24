class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int c = 0;
        boolean[] vis = new boolean[n];
        boolean[] inRec = new boolean[n];

        List<Integer>  list = new ArrayList();

        for(int i = 0; i < n; i++){
            //check for each node
            if(!vis[i]){
                isConnected(graph, i, vis, inRec);
            }
        }

        for(int i = 0; i < n; i++){
            if(inRec[i] == false){
                list.add(i);
            }
        }

        return list;
        
    }

    private boolean isConnected(int[][] graph, int start, boolean[] vis, boolean[] inRec){

        vis[start] = true;
        inRec[start] = true;

        for(int parosi: graph[start]){
            if(!vis[parosi] && isConnected(graph, parosi, vis, inRec)){
                return true; //ye bhi ek cycle de diya, 
            }
            else if(inRec[parosi]){
                return true; //found a cycle
            }
        }

        inRec[start] = false;
        return false; //no cycle found

    }
}