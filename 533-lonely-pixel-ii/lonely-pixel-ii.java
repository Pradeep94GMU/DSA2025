class Solution {
    public int findBlackPixel(char[][] picture, int target) {


        int m = picture.length;
        int n = picture[0].length;

        int[] rC = new int[m];
        int[] cC = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B'){
                    rC[i]++;
                    cC[j]++;
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            String each = new String(picture[i]); //WBWBBW -> freq nikal lo which will help in check same rows
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B' && rC[i] == target && cC[j] == target){
                    //valid for rule 1 and for make sure rule 2 works, we just need to check the map count
                    String each = new String(picture[i]);
                    if(map.get(each) == target){
                        count++;
                    }
                }
            }
        }

        return count;
        
    }
}