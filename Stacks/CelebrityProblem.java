// A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
// A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
// Note: Follow 0 based indexing.
// Follow Up: Can you optimize it to O(N)
 

// Example 1:

// Input:
// N = 3
// M[][] = {{0 1 0},
//          {0 0 0}, 
//          {0 1 0}}
// Output: 1
// Explanation: 0th and 2nd person both
// know 1. Therefore, 1 is the celebrity. 

// Example 2:

// Input:
// N = 2
// M[][] = {{0 1},
//          {1 0}}
// Output: -1
// Explanation: The two people at the party both
// know each other. None of them is a celebrity.

// Your Task:
// You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters 
// and returns the index of the celebrity. If no such celebrity is present, return -1.


// Expected Time Complexity: O(N^2)
// Expected Auxiliary Space: O(1)


// Constraints:
// 2 <= N <= 3000
// 0 <= M[][] <= 1


class CelebrityProblem
{ 
    Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {   
        int i;
        int check = 0;
    	for(i = 0; i < M.length; i++){
    	    int j;
    	    for(j = 0; j < M[0].length; j++){
    	        if(M[i][j] == 1){
    	            break;
    	        }
    	    }
    	    if(j == M.length){
    	        check = i;
    	        break;
    	    }else if(i == M.length -1 && j != M.length){
    	        return -1;
    	    }
    	}
        boolean flag = true;
        
    	for(int k = 0; k < M.length; k++){
    	    if(k == check)continue;
    	    if(M[k][check] != 1){
    	        flag = false;
    	        break;
    	    }
    	}
    	if(flag == true){
    	    return check;
    	}
    	return -1;
    }
    
    // O(n) elimination technique agar a , b ko janta he to a celb ni hoskta 
    // agar a , b ko nhi janta to b celb ni hoskta 
    
    int celebrity(int M[][] , int n){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            st.push(i);
        }
        while(st.size() >= 2){
            int a = st.pop();
            int b = st.pop();
            if(M[a][b] == 1){ // a knows b - a is not celb
               if(M[b][a] == 0){
                    st.push(b);
               }
            }else if (M[a][b] == 0){ // a dont know b - b is not celb
                if(M[b][a] == 1){
                    st.push(a);
                }
            } 
        }
        if(st.isEmpty()){
            return -1;
        }   
       int check = st.pop();
       boolean flag = true;
       for(int j = 0; j < M[0].length; j++){
           if(M[check][j] == 1){
               flag = false;
               break;
           }
       }
       if(!flag){
           return -1;
       }
       	for(int k = 0; k < M.length; k++){
    	    if(k == check)continue;
    	    if(M[k][check] != 1){
    	        flag = false;
    	        break;
    	    }
    	}
    	if(flag == true){
    	    return check;
    	}
    	return -1;
    }
}
