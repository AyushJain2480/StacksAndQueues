class NextGreaterElement
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] nums, int n)
    { 
        long[] nge = new long[nums.length];
        
        Stack<Long> st = new Stack<>();
        
        st.push(nums[nums.length - 1]);
        nge[nums.length - 1] = -1; // there is no next element on the right side for the last element 
        
        // ek ke undar ek loop n2 isley nhi he kyuki pop wala loop har element 
        // ke lie nhi chalta he
        for(int i = nums.length - 2; i >= 0; i--){
            // -a+ (pop ans push)
            while(st.size() > 0 && st.peek() <= nums[i]){
                st.pop();
            }
            // sbko pop kradia this is the biggest element so right me to milega hi ni 
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                // jab tak chote milre the pop kia fir jese hi bada mila ruk gye
                nge[i] = st.peek();
            }   
            st.push(nums[i]);
        }
        return nge;
    } 
}
