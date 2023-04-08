// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6

class Solution {
    public int evalRPN(String[] exp) {
        
    Stack<String> vs = new Stack<>();

    for(int i = 0; i < exp.length; i++){
        String s = exp[i];
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            String val2 = vs.pop();
            String val1 = vs.pop();
            vs.push(String.valueOf(operation(val1,val2,s)));
        }else{
            vs.push(s);
        }
    }
        return Integer.parseInt(vs.pop());
 }
 public int operation(String v1 , String v2 , String op){
     if(op.equals("+")){
        return Integer.parseInt(v1) + Integer.parseInt(v2); 
     }else if(op.equals("-")){
        return Integer.parseInt(v1) - Integer.parseInt(v2);
     }else if(op.equals("*")){
         return Integer.parseInt(v1) * Integer.parseInt(v2);
     }else if(op.equals("/")){
         return Integer.parseInt(v1) / Integer.parseInt(v2);
     }
     return 0;
 }
}
