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



// next greater element 2 


Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find 

its next greater number. If it doesn't exist, return -1 for this number.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Arrays.fill(nge, -1);

        Stack<Integer> st = new Stack<>();
        st.push(nums.length - 1);
        
        // Traverse the array in reverse order
        for(int i = nums.length - 2; i >= 0; i--){
            while(st.size() > 0 && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = nums[st.peek()];
            }
            
            st.push(i);
        }
        
        // Traverse the array again to handle circularity
        for(int i = nums.length - 1; i >= 0; i--){
            while(st.size() > 0 && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                break;
            }else{
                nge[i] = nums[st.peek()];
            }
            
            st.push(i);
        }
        
        return nge;
    }
}
