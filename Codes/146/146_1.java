class LRUCache {
    int capa;
    int lowest,currentTime;  //for time; time starts form 1
    //int count;
    Map<Integer, Integer> map;  //(key,value)
    Map<Integer, Integer> timeOfKey; // (key,timestamp)
    Map<Integer, Integer> keyOfTime;// (timestamp,key)
    
    public LRUCache(int capacity) {
        lowest = 1;
        currentTime = 1;
        capa = capacity;
        map = new HashMap<>();
        timeOfKey = new HashMap<>();
        keyOfTime = new HashMap<>();
    }
    
    public int get(int key) {
        if( map.containsKey(key) )
        {   
            // for(int t : keyOfTime.keySet()){   //access -> update timeStamp
            //     if( keyOfTime.get(t) == key){
            //         keyOfTime.remove(t);   
            //         break;
            //     }
            // }
            int lasttime = timeOfKey.get(key);
            if (lasttime == lowest)
                lowest += 1;
            keyOfTime.remove(lasttime);  //remove timeStamp of key for refill
            keyOfTime.put(currentTime, key); 
            timeOfKey.put(key,currentTime);
            currentTime += 1;    //access -> currenttime += 1
            //System.out.printf(keyOfTime.toString());
            return map.get(key);
        }
        else
            return -1;
        
    }
    
    public void put(int key, int value) {
        //checkbound
        if(map.size() >= capa && !map.containsKey(key)) //none space left & a new key comes -> pop old key
        {
            //System.out.printf("bound out: %d\n",key);
            while(!keyOfTime.containsKey(lowest))  //find next lowest time;  a time hole produced by get() can be check by this step 
                lowest += 1;
            int lkey = keyOfTime.get(lowest);
            map.remove(lkey);
            keyOfTime.remove(lowest);
            lowest +=1;
        }       
        //old key is removed  
        
        // if( map.containsKey(key) )   
        //     for(int t : keyOfTime.keySet()){   //access -> update timeStamp
        //         if( keyOfTime.get(t) == key){
        //             keyOfTime.remove(t);   
        //             break;
        //         }
        //     }
        
        //if the key already exists, it needs to update timestamp
        if( map.containsKey(key) ) { 
            int lasttime = timeOfKey.get(key);   
            if (lasttime == lowest)
                lowest += 1;
            keyOfTime.remove(lasttime);  //remove timeStamp of key for refill
        }
        
        keyOfTime.put(currentTime, key); 
        timeOfKey.put(key,currentTime);
        map.put(key, value);
        currentTime += 1;   //put -> current time += 1
        
        
        return; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */