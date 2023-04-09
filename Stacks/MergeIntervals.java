class Solution {
    public int[][] merge(int[][] intervals) {
       // sort the intervals on the basis of starting point 
       // using lambda expression or comparator we can sort the array object

       Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

       // We don't know how many intervals will be created so use arrayList
       ArrayList<int[]> list = new ArrayList<>();

       for(int[] interval : intervals){
           if(list.size() == 0){ // if list is empty add the interval which comes first
               list.add(interval);
           }else{
               int[] prevInterval = list.get(list.size() - 1);
               if(prevInterval[1] >= interval[0]){
                   prevInterval[1] = Math.max(prevInterval[1],interval[1]);
               }else{
                   list.add(interval);
               }
           }
       }
       return list.toArray(new int[list.size()][]);

    }

    public int[][] merge(int[][] intervals){

    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

    Stack<int[]> stack = new Stack<>();

    for(int[] interval : intervals){
        if(stack.isEmpty()){
            stack.push(interval);
        }else{
            int[] prevInterval = stack.peek();
            if(prevInterval[1] >= interval[0]){
                prevInterval[1] = Math.max(prevInterval[1],interval[1]);
            }else{
                stack.push(interval);
            }
        }
    }
    ArrayList<int[]> list = new ArrayList<>();
    Stack<int[]> newStack = new Stack<>();

    while(!stack.isEmpty()){
        newStack.add(stack.pop());
    }
    while(!newStack.isEmpty()){
        list.add(newStack.pop());
    }
    return list.toArray(new int[list.size()][]);
    }
}



class Solution {
    public int[][] merge(int[][] intervals) {
        
        Stack<int[]> st = new Stack<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        
        for(int[] arr : intervals){
            pq.add(arr);
        }
         
        st.push(pq.poll());
        
        while(!pq.isEmpty()){
            int[] pqp = pq.poll();

            int[] stp = st.peek();

            if(pqp[0] > stp[1]){
                st.push(pqp);
            }else{
                int[] nstp = st.pop();
                int maxEnd = Math.max(nstp[1],pqp[1]);
                int[] npush = new int[2];
                npush[0] = nstp[0];
                npush[1] = maxEnd;
                st.push(npush);
            }
        }
        while(!st.isEmpty()){
            pq.add(st.pop());
        }
        int[][] ans = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
