class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList());
        }

        for(int i = 0; i < n; i++){
            int edge[] = edges[i];
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        for(int i = n - 1; i >= 0; i--){
            int edge[] = edges[i];
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            //mujhe laast edge se hatana prega one by one
            //usse phale ek adj list bana lo and usse last element ko hata kr dekho
            //1,5 ko hatao
            adj.get(u).remove((Integer)v);
            adj.get(v).remove((Integer)u);
            //ab bas check kr lo ki graph connnected hai yaa nhi
            boolean[] vis = new boolean[n];
            
            //check connectivity from 0 node till last
            dfs(vis, 0, adj);

            //hamare vis boolean se pata kr skte hai ki connected hai yaa nhi
            boolean isConnected = true; //intially sab connected
            for(boolean eachNode: vis){
                if(eachNode == false){
                    //one node is not connected
                    isConnected = false;
                    break;
                }
            }

            if(isConnected){ //check kr rhe ki abhi bhi connected hai
                return new int[]{u + 1, v + 1};
            }


            //ellse add back the remove edge again
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{0,0};
    }

    private void dfs(boolean[] vis, int start,List<List<Integer>> adj){
        vis[start] = true;
        for(int parosi: adj.get(start)){
            if(!vis[parosi]){
                dfs(vis, parosi, adj);
            }
        }
    }
}