class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        if(intervals.length <= 1) return true;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];

            if(end > newStart) return false;

            start = newStart;
            end = newEnd;
        }

        return true;
        
    }
}