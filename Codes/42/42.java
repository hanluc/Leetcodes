class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int water = 0;
        int temph = 0;
        while( l < r ){
            if( temph < Math.min(height[l],height[r])) //update temph if there is a higher bar
                temph = Math.min(height[l],height[r]);
            else {
                while ( l < height.length &&  height[l] <= temph  )     // move the pointer until meet higher bar
                    l += 1;
                while ( r > -1 && height[r] <= temph  )
                    r -= 1;
                continue;
            }
            //fill water
            for( int i = l + 1; i < r; i ++){
                if( height[i] < temph ){
                    water += temph - height[i];
                    height[i] = temph;
                }
            }
            //move pointer
            while ( l < height.length && height[l] <= temph )     // move the pointer until meet higher bar
                l += 1;
            while ( r > -1 && height[r] <= temph )
                r -= 1;         
        }
        return water;
    }
}//