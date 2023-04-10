class Solution {
    // ()()(()()) [1 1 -1 1 1] pop it out jab tak -1 na mile 
    // val = 2  --> [1 1 -1]
    // open bracket bhi krdo i.e -1 // [1 1]
    // [1 1] push 2 * val = 2 * 2 = 4 // [1 1 4]
    // final sum = 1 + 1 + 4 = 6 ans
    
    public int scoreOfParentheses(String str) {
        Stack<Integer> st = new Stack<>();
        
        // taking '(' as -1
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
               st.push(-1);
            }else{
               if(st.peek() == -1){
                   st.pop(); // means ( pop karo 
                   st.push(1); // or () iske lie 1 dalo
               }else{ // manlo peek par ( nhi he ) hi he like (())
                   // matlb jab tak opening ( ni milta pop krte jao 
                   int val = 0;
                   while(st.peek() != -1){
                       val += st.pop(); // 2
                   }
                   st.pop(); // popping '('
                   st.push(2 * val);
               }
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}


class Solution {
    int i = 0;
    public int scoreOfParentheses(String str) {
      return recursion(str);
    }
    
    public int recursion(String s){
         int score = 0;
         while(i < s.length()){
             char ch = s.charAt(i++);
             if(ch == '('){
                 score += recursion(s);
             }else{
                 if(score == 0){
                     return 1;
                 }else{
                     return 2 * score;
                 }
             }
         }
        return score;
    }
}
