1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless. 
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true


class DuplicatesBrackets{
      public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();
       Stack<Character> st = new Stack<>();
       
       for(int i = 0; i < s.length(); i++){
           char ch = s.charAt(i);
           if(ch == ')'){
               // now char is ) in this case
               // agar peek directly ( milta he to mtlb usme content ni he vo duplicate he to true return kardo
               if(st.peek() == '('){
                   System.out.println(true);
                   return;
               }
               // vrna tab tak pop krte jao jab tak ) na mil jay or use bhi pop kardo
               while(st.peek() != '('){
                   st.pop();
               }
               st.pop();
           }
           else{
               st.push(ch);
           }
       }
       System.out.println(false);
    }
}




public static boolean duplicateParanthesis(String expr) {
      Stack<Character> st = new Stack<>();
      for(int i = 0; i < expr.length(); i++){
            char ch = expr.charAt(i);
            if(ch == ')'){
          if(st.peek() == '(') return true;
          while(st.peek() != '('){
                        st.pop();
                  }
                  st.pop();
            }else{
                  st.push(ch);
            }
      }
      return false;
}
