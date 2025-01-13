class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] aplha = new int[26];

        for(char ch: tasks){
            aplha[ch - 'A']++;
        }
        int res = 0;

        //we need max freq
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int each: aplha){
            if(each > 0){
                 maxHeap.offer(each);
            }
           
        }

        System.out.println(maxHeap);
        //sare tak nhi hote tab tak
        while(!maxHeap.isEmpty()){

            List<Integer> list = new ArrayList();

            //mujhe max wala lena hai and upto n + 1 task to krna ahai krna hai
            for(int task = 1; task <= n + 1; task++){
                //lekin, ho sktaa hai ki hame heaap is kam size ka mile
                if(!maxHeap.isEmpty()){
                    int freq = maxHeap.poll();
                    freq--;
                    list.add(freq);
                }
                
            }

            //now remiaanign task we have to insert back for next time
            for(int remTask: list){
                if(remTask > 0){
                    maxHeap.offer(remTask);
                }
            }

            //tricky part, as we got to know that, if our task is left in heap, mining
            //we haave fullfill one trip( n + 1 times) already compuuted
            //but if we are not able to do that , menaing we ar enot able to fill the heap and heap is empty , meaning, we can max do list size task
            if(maxHeap.isEmpty()){
                res += list.size();
            }else{
                res += (n + 1);
            }
        }

        return res;
        
    }
}