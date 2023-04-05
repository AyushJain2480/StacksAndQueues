import java.io.*;
import java.util.*;

public class InfixEvaluation{
  
// In infix notation, operators are placed between the operands, such as "3 + 4 * 5". In RPN, the operators are placed after the operands, such as "3 4 5 * +". RPN is also known as postfix notation.

// asked in DTU and microsoft
// Infix to Postfix 

// we can create calculator application with infix evaluation
// we can also solve it like first convert it to postfix notation and than solve and direct like this also
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> opnds = new Stack<>();
    Stack<Character> optors = new Stack<>();
    
    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        
        if(ch == '('){
            optors.push(ch);
        }
        else if(Character.isDigit(ch)){
            opnds.push(ch - '0');
        }
        else if(ch == ')'){
            while(opnds.peek() != '('){
                int val2 = opnds.pop();
                int val1 = opnds.pop(); // niche pda hoga val1 - val2 karna he
                char operator = optors.pop();
                int solve = operation(val1,val2,operator);
                opnds.push(solve);
            }
            opnds.pop(); // for '('
        }
        else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
            // ch is wanting higher priority operators to solve first
            while(opnds.peek() != '(' && opnds.size() != 0 && precedence(ch) <= precedence(optors.peek())){
                int val1 = opnds.pop();
                int val2 = opnds.pop();
                char operator = optors.pop();
                int solve = operation(val1,val2,operator);
                opnds.push(solve);
            }
            // ch is pushing itself now 
            optors.push(ch);
        }
        
    }
    // jab tak operators bache he tab tak nikalte rhe 
    while(optors.size() != 0){
        int val2 = opnds.pop();
        int val1 = opnds.pop(); // niche pda hoga val1 - val2 karna he
        char operator = optors.pop();
        int solve = operation(val1,val2,operator);
        opnds.push(solve);
    }
    System.out.println(opnds.peek());
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
    else if(optor == '/){
        return 2;
    }
 }
 
 public static int operation(int v1 ,int v2, char optor){
    if(optor == '-'){
        return v1 - v2;
    }
    else if(optor == '+'){
        return v1 + v2;
    }
    else if(optor == '*'){
        return v1 * v2;
    }
    else if(optor == '/){
        return v1 / v2;
    } 
 }
}
