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
