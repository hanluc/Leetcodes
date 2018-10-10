class Solution {
    public int numJewelsInStones(String J, String S) {
        
        HashSet h = new HashSet();
        for( int i= 0 ; i<J.length() ; i++){
            h.add(J.charAt(i));
        }
        int num = 0;
        for (char c : S.toCharArray()){
            if (h.contains(c))
                num ++;
        }
        
        return num;
    }
}