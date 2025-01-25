class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        //sorted array se grp bana skte hai
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        //now we can make a grop
        HashMap<Integer, LinkedList<Integer>> groupingMap = new HashMap();

        int groupNum = 0;

        //first group me add kro do intial setup
        LinkedList<Integer> currGrp = new LinkedList<>();

        currGrp.add(sorted[0]); //intiall firts num kaa 1 grp hoga
        HashMap<Integer, Integer> eleBelongToWhichGroup = new HashMap();
        eleBelongToWhichGroup.put(sorted[0], groupNum);

        for(int i = 1; i < nums.length; i++){
            if(Math.abs(sorted[i] - sorted[i - 1]) <= limit){
                currGrp.add(sorted[i]);
                eleBelongToWhichGroup.put(sorted[i], groupNum);
            }
            else{
                //new grp to purane wlae ko saave kro fir clear kr
                groupingMap.put( groupNum++ , new LinkedList<>(currGrp)  );
                currGrp.clear();
                //curr i wala number new grp me intial setup kr dega
                currGrp.add(sorted[i]);
                eleBelongToWhichGroup.put(sorted[i], groupNum);
            }
        }

        groupingMap.put( groupNum++ , new LinkedList<>(currGrp)  ); //for last currGrp


        // for (Map.Entry<Integer, LinkedList<Integer>> entry : groupingMap.entrySet()) {
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }

        //System.out.println(eleBelongToWhichGroup);

        int[] res = new int[nums.length];
        int k = 0;

        //now i need to do one more thing that, which i did, 
        //double ds use krne hai
        for(int n: nums){
            //check kro ki n kis grp kaa haai
            int group = eleBelongToWhichGroup.get(n);
            int number = groupingMap.get(group).pollFirst();
            res[k++] = number;
        }
       

        return res;
        
    }
}