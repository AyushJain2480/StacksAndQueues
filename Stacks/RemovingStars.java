class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                st.push(ch);
            }else{
                st.pop();
            }
        }
        String str = "";
        while(!st.isEmpty()){
            str += st.pop();
        }
        System.out.println(str);
        return reverse(str);
    }
    
    public String reverse(String str){
        StringBuilder sb = new StringBuilder().append(str);
        return sb.reverse().toString();
    }
}







// optimise version
class Solution {
   public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray())
            if (c == '*')
                res.deleteCharAt(res.length() - 1);
            else
                res.append(c);
        return res.toString();
    }
}
