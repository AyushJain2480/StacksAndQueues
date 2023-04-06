import java.io.*;
import java.util.*;
// INfix to prefix and postfix conversion
/*
"a*(b-c)/d+e"
+/*a-bcde
abc-*d/e+
*/
public class InfixConversions{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> ops = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        
        if(ch == '('){
            ops.push(ch);
        }
        else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            pre.push(ch + "");
            post.push(ch + "");
        }
        else if(ch == ')'){
            while(ops.peek() != '('){
                char operator = ops.pop();
                 
                String val2INPre = pre.pop();
                String val1INPre = pre.pop();
                pre.push(operator + val1INPre + val2INPre);
                
               
                String val2INPost = post.pop();
                String val1INPost = post.pop();
                post.push(val1INPost + val2INPost + operator);
            }
            ops.pop(); // remove '('
        }
        else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
            while(ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())){
                char operator = ops.pop();
                 
                String val2INPre = pre.pop();
                String val1INPre = pre.pop();
                pre.push(operator + val1INPre + val2INPre);
                
               
                String val2INPost = post.pop();
                String val1INPost = post.pop();
                post.push(val1INPost + val2INPost + operator);
            }
            ops.push(ch);
        }
    }
    while(!ops.isEmpty()){
        char operator = ops.pop();
             
        String val2INPre = pre.pop();
        String val1INPre = pre.pop();
        pre.push(operator + val1INPre + val2INPre);
        
       
        String val2INPost = post.pop();
        String val1INPost = post.pop();
        post.push(val1INPost + val2INPost + operator);
    }
    System.out.println(pre.pop());
    System.out.println(post.pop());
 }
 
  public static int precedence(char optor){
    if(optor == '-'){
        return 1;
    }
    else if(optor == '+'){
        return 1;
    }
    else if(optor == '*'){
        return 2;
    }
    else if(optor == '/'){
        return 2;
    }
    else{
        return 0;
    }
 }
}
