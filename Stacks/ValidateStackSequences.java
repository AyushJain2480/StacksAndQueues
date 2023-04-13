class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        
        Stack<Integer> st = new Stack<>();
        while(i < pushed.length){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            i++;
        }
        return st.isEmpty();
    }
}
