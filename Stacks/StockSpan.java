// GFG
class StockSpan
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
           int[] span = new int[arr.length];
   
           Stack<Integer> st = new Stack<>();
           st.push(0);
           span[0] = 1;// sirf vhi hoga span me left me kuch he hi ni
           // pop ans push
           
           for(int i = 1; i < n; i++){
               while(st.size() > 0 && arr[st.peek()] <= arr[i]){
                   st.pop();
               }
               // sare pop krdie to ans index + 1 hoga kyuki sare span me ayge 
               if(st.size() == 0){
                   span[i] = i + 1;
               }else{
                   span[i] = i - st.peek();
               }
               st.push(i);
   }
   
   return span;
        
    }
    
}

// Online stock problem leetcode
class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int i = -1;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
       i+=1; // whenever the next function is called we will increase the index by 1
      // Find the previous greater element
       while(!st.isEmpty() && st.peek()[1] <= price){
            st.pop();
       }
       // If there is no previous greater element
       if(st.isEmpty()){
            st.push(new int[]{i,price});
            return i + 1;
       }
        int prevIndex = st.peek()[0]; // get index of previous greater element
        st.push(new int[]{i, price});
        return i - prevIndex;
    }
}
