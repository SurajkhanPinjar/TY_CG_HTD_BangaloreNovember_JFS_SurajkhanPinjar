import java.util.Stack;

public class Stack1 {
	public static void main(String[] args) {
		
		Stack s1=new Stack();
		s1.add(10);
		s1.add(52);
		s1.add(85);
		s1.add(75);
		System.out.println(s1);
		
		System.out.println("------push pop peek------");
		System.out.println(s1.pop());
		System.out.println(s1.push(100));
		System.out.println(s1);
		System.out.println(s1.search(100));
		System.out.println(s1.peek());
		
		
		
	}

}
