class Solution {
    public boolean validWordSquare(List<String> words) {
        int l = 0;
        for(String w:words)
        {
            l = Math.max(l, w.length());
        }
        int k = Math.max(words.size(),l);



        char mat[][] = new char[k][k];

        for(int i = 0;i<k;i++)
        {
            if(i>=words.size())
                break;

            String w = words.get(i);
            int j = 0;
            for(char c:w.toCharArray())
            {
                mat[i][j] = c;
                j+=1;
            }
        }

        for(int i = 0; i<k; i++)
        {
            for(int j = i; j<k; j++)
            {
                if(mat[i][j] != mat[j][i])
                {
                    return false;
                }
                
            }
        }


        return true;



        
    }
}