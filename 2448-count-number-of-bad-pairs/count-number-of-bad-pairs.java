class Solution {
    public long countBadPairs(int[] nums) {

        long res = 0l;
        long goodpairs = 0l;
        long totalpairs = (long)nums.length * (nums.length - 1);

        Map<Long, Long> s = new HashMap<>();
        long calc = 0l;

        for(int i = 0; i< nums.length; i++)
        {
            calc = i - nums[i];

            if(s.containsKey(calc))
            {
                goodpairs += s.get(calc);
                s.put( calc , s.get(calc) +1);
            }
            else
            {
                s.put(calc, 1l);
            }

        } 

        System.out.println(totalpairs/2+ " " + goodpairs); 

        return (totalpairs/2) - goodpairs;
    }
}