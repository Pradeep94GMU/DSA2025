class Solution {
    public int maximumInvitations(int[] fav) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        int n = fav.length;
        for(int i = 0; i < n; i++){
            int u = i;
            int v = fav[i];
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        //System.out.println(adj);

        int longestCyclelength = 0;
        int happyCoupleCycle = 0;

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){
            //for each not vis node, i need to find any cycle from that and check the longest
            if(!vis[i]){
                int currNode = i;
                int currNodeCount = 0;
                HashMap<Integer, Integer> map = new HashMap();
                //untille cycle is found
                while(!vis[currNode]){
                    vis[currNode] = true;
                    map.put(currNode, currNodeCount);

                    //curr node, 0 ho gya ab next node 1 ko dekho
                    int nextNode = fav[currNode];
                    currNodeCount++;
                    //if cycle found
                    if(map.containsKey(nextNode)){ //yaha main check kr ki cycle mila ki nhi break huua maatlb ki cycpe milgya
                        //already we have a vis node, so, we got a cycle
                        int cycleLen = currNodeCount - map.get(nextNode);

                        //abhi ka jo len aaaya wo bada hai yaa phle jo tha wo bada hai
                        longestCyclelength = Math.max(longestCyclelength, cycleLen);

                        if(cycleLen == 2){
                            boolean[] vistedNode = new boolean[n];
                            vistedNode[currNode] = true;
                            vistedNode[nextNode] = true;
                            happyCoupleCycle += 2 + BFS(currNode, adj, vistedNode) + BFS(nextNode, adj, vistedNode);

                        }

                        break;

                    }
                    currNode = nextNode;

                }
            }
        }





        return Math.max(happyCoupleCycle, longestCyclelength);
        
    }

    private int BFS(int start, Map<Integer, List<Integer>>  adj, boolean[] vistedNode){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        vistedNode[start] = true;
        int maxDist = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int currNode = cell[0];
            int currDist = cell[1];

            for(int parosi: adj.getOrDefault(currNode, new ArrayList<>())){
                if(!vistedNode[parosi]){
                    vistedNode[parosi] = true;
                    q.offer(new int[]{parosi, currDist + 1});
                    maxDist = Math.max(maxDist, currDist + 1);
                }
            }
        }

        return maxDist;

    }
}