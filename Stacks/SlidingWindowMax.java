class SlidingWIndowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        
        Stack<Integer> stack = new Stack<>();
        nge[nums.length - 1] = nums.length;// nums.length ,-1, Integer.MAX_VALUE;
        // yha arr.length isley use krre he kyuki hum ek logic likhege ki 
        // kya apka next greater window ke bahar he 
        stack.push(nums.length - 1);
        
       // pops ans pushes 
        for (int i=nums.length-2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            } else {
                nge[i] = nums.length;
            }
            stack.push(i);
        }
        int j = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i=0; i <= nums.length - k ; i++) {
            // i is the starting of every new windows 
            if(j < i){
                j = i;
            }
            // it is jumping on nge to nge inside windows jese hi nge bahar milta he window ke 
            // we stop there becoz unke bich ke element small honge to window ka mx vhi j par 
            // h
            while (nge[j] < i + k) {
                j = nge[j];
            }
            // har window me j jha rukega vhi max hoga us window ka
            res[i] = nums[j];
        } 
        return res;
    }
}

