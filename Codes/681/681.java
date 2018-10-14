class Solution {
    public String nextClosestTime(String time) {
        char[] nums = time.toCharArray();
        Arrays.sort(nums);   //":" is sorted to the end; sorted by ascii order
        HashMap<Character, Integer> rank = new HashMap<>();
        
        for (int i = 0; i < nums.length; i ++){
            rank.put(nums[i],i);
        }
        
        for ( int i = time.length() - 1; i >= 0 ; i--){
            if(i == 2) continue;    //i is ":"
            char temp = time.charAt(i);
            if( rank.get(temp) == 3 )  //largest num -- no alternative to replace it
                continue;
            StringBuilder s = new StringBuilder(time);  
            s.setCharAt(i, nums[rank.get(temp) + 1]); //replace the number 
            //if higher digit changes ,all lower digit should be replaced by smallest num so as to maintain the smallest distance
            if (i < time.length() - 1) //higher digit
                for(int j = i + 1; j < time.length() ; j++ )
                    if (j != 2)   //skip ":"
                        s.setCharAt(j,nums[0]);   //set lower digit to smallest num
            if( isValid(s.toString())){
                s.setCharAt(i, nums[rank.get(temp) + 1]);
                return s.toString();
            } 
        }
        //if it is 23:59 -- no valid replacement 
        char[] res = {nums[0], nums [0], ':', nums[0], nums[0]};
        return new String(res);
    }
    
    private boolean isValid(String time) {
        int hr = Integer.parseInt( time.substring( 0, 2) );
        if(hr > 23)
            return false;
        if (time.charAt(2) != ':')
            return false;
        int mi = Integer.parseInt( time.substring( 3 ));
        if( mi > 59)
            return false;
        
        return true;
        
    }
}