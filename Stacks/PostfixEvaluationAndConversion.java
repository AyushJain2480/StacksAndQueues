
// dont know why its not printing but idea is this only hope you get it 
import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> vs = new Stack<>();
    Stack<String> pre = new Stack<>();
    Stack<String> infix = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
    
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            String val2 = vs.pop();
            String val1 = vs.pop();
            vs.push(operation(val1,val2,ch) + "");
            
            String infixv2 = infix.pop();
            String infixv1 = infix.pop();
            infix.push("(" + infixv1 + ch + infixv2 + ")");
            
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            pre.push(ch + prev1 + prev2);
        }else{
            vs.push(ch + "");
            pre.push(ch + "");
            infix.push(ch + "");
        }
    }
    System.out.println(vs.pop());
    System.out.println("infix is " + infix.pop());
    System.out.println("prefix is" + pre.pop());
 }
 public static int operation(String v1 , String v2 , char op){
     if(op == '+'){
        return Integer.parseInt(v1) + Integer.parseInt(v2); 
     }else if(op == '-'){
        return Integer.parseInt(v1) - Integer.parseInt(v2);
     }else if(op == '*'){
         return Integer.parseInt(v1) * Integer.parseInt(v2);
     }else if(op == '/');
         return Integer.parseInt(v1) / Integer.parseInt(v2);
     }
     return 0;
 }
}
