class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                st.push(arr[i]);
            }
            else if(arr[i] < 0){
                int val = Math.abs(arr[i]);
                
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < val){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == val){
                    st.pop();
                }
                // arr[i] is -ve and st is empty kya kroge push krdo -ve value 
                // if top is also -ve kya frk pdna koi collision ni push it
                else if(st.isEmpty() || st.peek() < 0){
                    st.push(arr[i]);
                } 
            }
        }
        if(st.isEmpty()){
            return new int[]{};
        }
        int n = st.size();
        int[] ans = new int[n];
        int i = ans.length - 1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        return ans;
    }
}
