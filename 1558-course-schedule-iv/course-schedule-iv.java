class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        //pre se ek graph bana lo pahle,
        List<List<Integer>> adj = new ArrayList();
        int n = prerequisites.length;
        List<Boolean> res = new ArrayList<>();
        if(n == 0){
            //all course are independent so we need to return all query as false
            return new ArrayList<Boolean>(Collections.nCopies(queries.length, false));

        }

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList());
        }

        for(int[] each_pre : prerequisites){
            int u = each_pre[0];
            int v = each_pre[1];
            adj.get(u).add(v);
        }
        System.out.println(adj);

        //for each queries
        for(int[] eachQu: queries){
            int requiredCourse = eachQu[0];
            int targetCourse = eachQu[1];
            boolean[] vis = new boolean[numCourses];
            boolean isPoss = checkPreq(adj, requiredCourse, targetCourse, vis);
            res.add(isPoss);
        }



        return res;
        
    }

    private boolean checkPreq(List<List<Integer>> adj, int src, int dest, boolean[] vis){
        //we can see basically we need to do src -> dest kinda thing
        //one src and one dest= dfs se bhi kr skte hai and bfs se bhi ho jayega
        vis[src] = true;

        for(int parosi: adj.get(src)){
            if(parosi == dest) return true;
            if(!vis[parosi]){
                if(checkPreq(adj, parosi, dest, vis)){
                    return true;
                }
            }
        }

        return false;

    }
}