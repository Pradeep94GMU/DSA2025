class Solution {
    public long pickGifts(int[] gifts, int k) {
        //kuikhkhjk
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: gifts){
            maxHeap.offer((long)n);
        }

        while(k-- > 0 ){
            //heap kabhi empty  nhi hoga, we need push back agaain
            long max = maxHeap.poll();
            long leftBehind = (long)Math.floor(Math.sqrt(max));
            maxHeap.offer(leftBehind);


        }

        long res = 0l;
        while(!maxHeap.isEmpty()){
            res = res + maxHeap.poll();

        }

        return res;
        
    }
}