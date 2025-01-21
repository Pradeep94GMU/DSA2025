class Solution {
    public long gridGame(int[][] grid) {

        long firstRowRemSum = Arrays.stream(grid[0]).asLongStream().sum();

        long secRobotMinSum = Long.MAX_VALUE;

        long secRowRemSum = 0l;


        for(int robot1Col = 0; robot1Col < grid[0].length; robot1Col++){
            //each col se trn leta hai to cal kr lo , dono dir se kitna ho payega
            firstRowRemSum -= grid[0][robot1Col];

            //dusre robot hoga wo apna profit dekhega
            long bestOfTwoRobots = Math.max(secRowRemSum, firstRowRemSum);

            secRobotMinSum = Math.min(secRobotMinSum,bestOfTwoRobots );
            secRowRemSum += grid[1][robot1Col];
        }

        
        return secRobotMinSum;
    }
}