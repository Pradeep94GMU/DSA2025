/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < n; i++){
            set.add(i);
        }
        
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < n; j++){
                if(i != j){
                    // System.out.println("Hihi");
                    if(knows(i, j)){
                        System.out.println("Hihi");
                       if(set.contains(i)) set.remove(i); 
                       j = n; 
                    }
                }
            }
        }

         System.out.println(set);

        if(set.size() != 1) return -1;

        for(int mm: set){
            // System.out.println(set);
            for(int j = 0; j < n; j++){
                // if(mm == j) continue;
                if(!knows(j , mm)){
                   return -1;
                }
                
            }

            return mm;
        }
        return -1;

    }
}