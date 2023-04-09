// 3d 2d 1i 4i 6d 5i 9d 8d 7
//        |  |     | 

// 2d 1i 5d 4d 3i 7d 6i 8
//    |         |     |

// 3d 2d 1i d6 d5 4 
// kya ye sabse chota no he yes kyuki dd ke hisab se sabse chota no. 123 he or next dd ke hisab 
// se 123 save rkhte hue 654 small he no duplicacy allowed isley 321 ni leskte 

// jo ulti counting banani he vo stack ki help se banayge
// 'D' dikhta he to push karke num bdate he 
// 'I' dikhta he to push karke no. badate he or pop karke print karte he
// last num ko bina dekhe push krege or pop krke print krege
class Solution {
    public String smallestNumber(String pattern) {
         Stack<Integer> st = new Stack<>();
         int num = 1;
         String res = "";
         for(int i = 0; i < pattern.length(); i++){
             char ch = pattern.charAt(i);
             if(ch == 'D'){
                 st.push(num);
                 num++;
             }else{
                 st.push(num);
                 num++;
                 while(!st.isEmpty()){
                     res += st.pop();
                 }
             }
         }
        st.push(num);
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
}
