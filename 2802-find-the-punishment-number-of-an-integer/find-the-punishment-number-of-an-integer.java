class Solution {
    public int punishmentNumber(int n) {
       
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(check(0,i,0,Integer.toString(i*i))) count=count+(i*i);
        }
        return count;
    }
      public boolean check(int idx,int n,int s,String s1)
    {
        if(idx==s1.length())
        {
            if(s==n) return true;
            else return false;
        }
        for(int j=idx;j<s1.length();j++)
        {
            if(check(j+1,n,s+Integer.valueOf(s1.substring(idx,j+1)),s1))
                return true;
        }
         return false;
    }
}