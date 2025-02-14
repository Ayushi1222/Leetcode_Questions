class ProductOfNumbers {
    ArrayList<Long> l;
    public ProductOfNumbers() {
        l=new ArrayList<>();
        l.add(1L);
    }
    
    public void add(int num) {
        if(num==0)
        {
            l.clear();
            l.add(1L);
        }
        else
        {
            long prod=l.get(l.size()-1)*num;
            l.add(prod);
        }
    }
    
    public int getProduct(int k) {
        if(l.size()<=k) return 0;
        long ans=l.get(l.size()-1) / l.get(l.size()-1-k);
        return (int) ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */