//most acceptance in leetcode
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if ( grid == null || grid.length == 0){
            return 0;
        }
        
        int[] vSkyline = new int[grid.length];
        int[] hSkyline = new int[grid[0].length];
        
        // the two loops of v & h could be compressed to one
        for(int i = 0; i < grid.length; i++ )
            for (int j = 0; j < grid[0].length; j++)
                vSkyline[i] = Math.max( vSkyline[i], grid[i][j] );
                hSkyline[j] = Math.max( hSkyline[j], grid[i][j] );
        
        int maxHeight = 0;
        for(int i = 0; i < grid.length; i++ )
            for (int j = 0; j < grid[0].length; j++){
                maxHeight += Math.min( vSkyline[i], hSkyline[j] ) - grid[i][j];
            }
        
        return maxHeight;
    
    }
}