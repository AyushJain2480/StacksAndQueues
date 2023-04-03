class ValidParenthesis{
  
    Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
               stack.push(ch);
            }
            else {
               if(stack.isEmpty()){ // if there is no element in the stack that means string is started from back sign ) , } , ]
                   return false; // so return false directly because there is no opp pair in the stack 
                 // jab he hi ni element to kya peak kroge exception dedega isley phle hi false return kardo
               }
               else{
                    char top = stack.peek();
                    if(
                        (top == '(' && ch == ')') || 
                        (top == '{' && ch == '}') || 
                        (top == '[' && ch == ']') 
                    ){
                        stack.pop();
                    }else{
                        return false;
                    }
                } 
            }
        }
        return stack.isEmpty();
    }
  
  
}
