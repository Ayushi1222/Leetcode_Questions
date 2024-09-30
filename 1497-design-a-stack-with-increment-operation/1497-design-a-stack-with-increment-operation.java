class CustomStack {
    private int[] arr;
    private int i;
    public CustomStack(int maxSize) {
        this.arr=new int[maxSize];
    }
    
    public void push(int x){
        if(i<this.arr.length)
        {
            arr[i]=x;
            i++;
        }
    }
    
    public int pop(){
        if(i>0)
        {
            return this.arr[--i];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int j=0;j<Math.min(k,i);j++)
        {
            this.arr[j]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */