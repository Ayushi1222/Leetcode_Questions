class MyHashMap {
    ArrayList<ArrayList<Integer>> list;

    public MyHashMap() {
        list=new ArrayList<ArrayList<Integer>>();
    }

    public void put(int key, int value) {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).get(0)==key)
            list.remove(i);
        }
        ArrayList<Integer> l=new ArrayList<>();
        l.add(key);
        l.add(value);
        list.add(l);
    }


    public int get(int key) {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).get(0)==key)
            return list.get(i).get(1);
        }
        return -1;
    }

    public void remove(int key) {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).get(0)==key)
            list.remove(i);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */