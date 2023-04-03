class IntroductionToStacks{
public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		
		st.push(1);
		st.push(2);
		System.out.println(st);
		st.push(3);
		System.out.println(st);
		st.push(4);
		System.out.println(st);
		System.out.println(st + " " + st.peek() + " " + st.size());
		st.pop();
		System.out.println(st + " " + st.peek() + " " + st.size());
		st.pop();
		System.out.println(st + " " + st.peek() + " " + st.size());
		st.pop();
		System.out.println(st + " " + st.peek() + " " + st.size());
		st.pop();
		System.out.println(st);
		System.out.println(st.size());
		try{
		System.out.println(st.peek());
		}catch(Exception e){
		    System.out.println("It is empty no peek is there");
		}
	}
  }
