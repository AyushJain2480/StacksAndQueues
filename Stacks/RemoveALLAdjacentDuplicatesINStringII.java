
// giving Tle I dont think its a hard level question because most of the solutions I tried are giving TLE and the solutions are also not so intuitive 
class Solution {
    public String removeDuplicates(String s, int k) {
    if(s.length() < k){
        return s;
    }    
    int i = 0; // index to iterate through the string
    int count = 1; // keep track of consecutive characters

    for (int j = 1; j < s.length(); j++) {
        if (s.charAt(j) == s.charAt(i)) {
            count++; // increment count if consecutive characters match
        } else {
            i = j; // reset index to start of new character
            count = 1; // reset count to 1 for new character
        }

        if (count == k) {
            // remove k consecutive characters and call recursively on the reduced string
            return removeDuplicates(s.substring(0, i) + s.substring(j+1), k);
        }
    }

    // if no consecutive characters found, return the string
    return s;
}
}
// Time : O(N*K)
// space : O(N)
class Solution {
    public String removeDuplicates(String s, int k) {
     // Using 2 Stacks
     // we will take the first char in temp stack and than we will check the top of 
     // main and temp stack if they are same we will pop the top of main and push it in 
     // temp and we will check the size of the temp if i.e equal to k that means we have 
     // k continous same chars in temp so we discarded the temp stack
     // if the top of the main does not matches with the top of the temp stack 
     // than we will not shift the char from the main to the temp and if the temp 
     // size is not equal to k i.e means the top which is not same break the count to 
     // reach k so pop the chars from the temp and push it in main stack
     // at last our soln is present in the stack we will apppend it in strinbuilder 
     // and reverse the string as stack works in LIFO manner
     Stack<Character> main = new Stack<>();
     for(char ch : s.toCharArray()){
         Stack<Character> temp  = new Stack<>();
         temp.push(ch);
         // jab tak same milre he main se uthao or temp me dalo 
            while(!main.isEmpty() && main.peek() == ch){
                temp.push(main.pop());
            }
         // dalne k bad check kro agar k size ke nhi hore to vapis daldo 
         // agar hore honge to temp me hi pde rehndo age bdo next step 
         // me vese bhi new stack use hogi
             if(temp.size() != k){
                 while(!temp.isEmpty()){
                     main.push(temp.pop());
                 }
             }
         }
        
     StringBuilder sb = new StringBuilder();
     while(!main.isEmpty()){
         sb.append(main.pop());
     }
     return sb.reverse().toString();
    }
}
// Accepted hah really tough
class Solution {
    public String removeDuplicates(String s, int k) {
      // we will not use temp stack in this approach instead we will try 
      // to store key value pair in the stack where key is char and count is integer
      // if we get the same char that is at the top we will increase the count for that 
      // char and if the count reaches k than we will pop that pair
      Stack<int[]> main = new Stack<>();
        
      for(char ch : s.toCharArray()){
          // if current char is same as prev char
          if(!main.isEmpty() && main.peek()[0] == ch){
              main.peek()[1]++; // increment the count
          }else{
              // otherwise we need to push a new char array 
              main.push(new int[]{ch,1});
          }
          // if the count of the top char is equal to k simply pop it out
          if(main.peek()[1] == k) main.pop();
      }
        
      StringBuilder sb = new StringBuilder();
      while(!main.isEmpty()){
          int[] top = main.pop();
          while(top[1]-- > 0){
              sb.append((char)top[0]);
          }
      }
     return sb.reverse().toString();
    }
}

