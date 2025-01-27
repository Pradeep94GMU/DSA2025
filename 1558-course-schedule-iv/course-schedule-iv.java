class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {


        //as constraint is less so we can think of n^3 operation aslo
        //point to catch: queries: src -> dest ( we shlld find yes/No in minimul time to optimise this)
        //src se dest to bahut algorihtm hai but as tc n^3 jaa skta hai to floyd warshall check kr lo
        //usse hame O(1) find kr skte hai ki koi connected hai directly or indirectly or not
        //shprted path nhi pucha so no need to go few algorithm, it is just asking if possible or not
        boolean[][] isReachable = new boolean[numCourses][numCourses];

        //fill the table suing intermidiate node which run like 0 -> n -1 nodes

        //fill the preReq first
        for(int[] eachPre: prerequisites){
            int src = eachPre[0];
            int dest = eachPre[1];
            isReachable[src][dest] = true;

        }


        for(int intermidiateNode = 0; intermidiateNode <  numCourses; intermidiateNode++){
            for(int src = 0; src < numCourses; src++){
                for(int dest = 0; dest < numCourses; dest++){
                    //check kro ki src -> intermidate koi reachble hai and also intermidiate se dest reachlbe hai??
                    if(isReachable[src][intermidiateNode] && isReachable[intermidiateNode][dest]){
                        isReachable[src][dest] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        //now as we have our reachle data we can do quesries
        for(int[] each: queries){
            int src = each[0];
            int dest = each[1];
            res.add(isReachable[src][dest]);
        }

        return res;
        
    }
}