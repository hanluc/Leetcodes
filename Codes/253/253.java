/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<Interval> inters = new ArrayList<>(Arrays.asList(intervals));
        Collections.sort(inters, new sortByStart());
        Set<Interval> rooms = new HashSet<>();
        
        //simulation
        for(Interval i: inters){
            for(Interval r : rooms){
                if(!hasOverlap(r, i)){
                    rooms.remove(r);
                    break;                    
                }
            }
            rooms.add(i);
        }
        
        return rooms.size();
    }
    
    private boolean hasOverlap(Interval i1, Interval i2){
        if(i1.end <= i2.start)
            return false;
        if(i2.end <= i1.start)
            return false;
        return true;
    }
    
    class sortByStart implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
}
