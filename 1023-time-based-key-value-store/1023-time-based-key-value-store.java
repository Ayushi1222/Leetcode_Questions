class Pair{
    String val;
    int timestamp;

    Pair(int timestamp, String val){
        this.timestamp=timestamp;
        this.val=val;
    }
}

class TimeMap {
    private HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String val, int timestamp) {
        if(map.containsKey(key))
        {
            map.get(key).add(new Pair(timestamp,val));
        }
        else
        {
            ArrayList<Pair> l=new ArrayList<>();
            l.add(new Pair(timestamp,val));
            map.put(key,l);
        }
    }
    
    public String get(String key, int timestamp) {

        String out="";
        if(map.containsKey(key))
        {
            ArrayList<Pair> l= map.get(key);
            int s=0;
            int e=l.size()-1;
            while(s<=e)
            {
                int mid=(s+e)/2;
                int currtime=l.get(mid).timestamp;
                if(currtime==timestamp)
                {
                    return l.get(mid).val;
                }
                else if(currtime<timestamp)
                {
                    out=l.get(s).val;
                    s=mid+1;
                }
                else
                {
                    e=mid-1;
                }
            }
        }
        return out;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,val,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */