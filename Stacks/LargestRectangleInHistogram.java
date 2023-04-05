// har ek bar ko height ki torpe manke dekhiye or dono taraf fela ke dekhiye kha tak fel skta he 
// vo jha tak fel skta he uski width hojaygi or height * width se area mil jayga 

// phle to ek loop har bar ke lie lgega 
// fir dusra loop is bat ka ki har bar kitna felskta he ye pta lgana he 

// hame ye O(n) me karna he 
// 4 jab right me felta he to kha tak felta he next smaller element tak (jab tak bade elements milte rehte he vo felta rehta he jese hi use chota elements milta he vo meri boundary he usee age me nhi ja pauga )

// nse in the right uski right boundary he agar nse nhi he to boundary last arr.length lelo
// nse in the left uski left boundary he agar nse nhi he to boundary -1 ko lelo

// index store krdege tbhi index minus karuga width dekhne ko milega 

class Solution {
    public int largestRectangleArea(int[] arr) {
        
        int[] rb = new int[arr.length]; // nse index on the right
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){ // chote par rukega
                //bade or barabar p ni
                st.pop();
            }
            // sare pop hogy means right me koi chota he hi ni 
            if(st.size() == 0){
                rb[i] = arr.length;
            }else{ // agar he right me chota to ruk jao or stack ke top me pda hoga chota wala
                // vo rb hogi 
                rb[i] = st.peek();
            }
            st.push(i);
        }
        
        int[] lb = new int[arr.length]; // nse index on the left
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }  
        
         int maxArea = 0;
         for(int i = 0; i < arr.length; i++){
             // add check to ensure bar height is greater than 0

             int width = rb[i] - lb[i] - 1;
             int area = arr[i] * width; // (height = arr[i])
             if(area > maxArea){
                 maxArea = area;
             }
         }
         return maxArea;
    }
}
