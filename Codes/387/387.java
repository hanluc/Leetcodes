class Solution {
    public int firstUniqChar(String s) {
        if(s.length()== 0)
            return -1;
        Map<Character, Integer> cToI = new HashMap<>();
        Set<Character> cs = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if(cs.contains(c)){
                cToI.remove(c);
                continue;
            }
            else{
                cToI.put(c, i);
                cs.add(c);
            }                
        }
        
        // ArrayList<Integer> l = new ArrayList(cToI.values());
        // Collections.sort(l);   //or go through the string one more time and return the first char in set
        // if(l.size() == 0)
        //     return -1;
        // return l.get(0);
        
        for (char c : s.toCharArray()){
            if(cToI.containsKey(c))
                return cToI.get(c);
        }
        return -1;
    }
}