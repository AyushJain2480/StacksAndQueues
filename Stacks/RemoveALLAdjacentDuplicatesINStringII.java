
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
