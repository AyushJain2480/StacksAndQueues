class DailyTemperatures {
    public int[] dailyTemperatures(int[] nums) {
        int[] nge = new int[nums.length];
        
        Stack<Integer> st = new Stack<>();
 
        for(int i = nums.length - 1; i >= 0; i--){
            // -a+ (pop ans push)
            while(st.size() > 0 && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            // sbko pop kradia this is the biggest element so right me to milega hi ni 
            if(st.isEmpty()){
                nge[i] = 0;
            }else{
                // jab tak chote milre the pop kia fir jese hi bada mila ruk gye
                nge[i] = st.peek() - i;
            }   
            st.push(i);
        }
        return nge;
    }
}// almost next greater element

