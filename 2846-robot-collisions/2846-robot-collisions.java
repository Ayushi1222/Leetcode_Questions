class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> l=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        Integer[] idx=new Integer[positions.length];
        for(int i=0;i<positions.length;i++)
        idx[i]=i;
        Arrays.sort(idx,(a,b)->Integer.compare(positions[a],positions[b]));
        for(int currindex:idx)
        {
            if(directions.charAt(currindex)=='R')
            {
                st.push(currindex);
            }
            //If char=='L'
            else
            {
                while(!st.empty() && healths[currindex]>0)
                {
                    int topIndex=st.pop();
                    if (healths[topIndex] > healths[currindex]) 
                    {
                        healths[topIndex] -= 1;
                        healths[currindex] = 0;
                        st.push(topIndex);
                    } 
                    else if (healths[topIndex] < healths[currindex]) 
                    {
                        // Current robot survives, top robot is destroyed
                        healths[currindex] -= 1;
                        healths[topIndex] = 0;
                    } 
                    else 
                    {
                        // Both robots are destroyed
                        healths[currindex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }
        for(int i=0;i<healths.length;i++)
        {
            if(healths[i]>0)
            l.add(healths[i]);
        }
        return l;
    }
}