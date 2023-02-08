package stack;

public class StackTester {

	public static void main(String[] args) {
		
		Stack stack = new StackImpl(6);
		stack.push("everlong");
	 	stack.push("wheels");
	 	stack.push("learn to fly");
	 	stack.push("the pretender");
	 	stack.push("my hero");
	 	stack.push("monkey wrench");
	 	//since this is 7th element, it should not be added
	 	stack.push("all my life");
	 	
	 	
		runTests(stack);

	}
	
	public static void runTests(Stack stack) {
	 	
	 	stack.display();
	 	System.out.println("\nIs full?: " + stack.isFull());
	 	
	 	System.out.println("\npopping top element...");
	 	stack.pop();
	 	stack.display();
	 	
	 	System.out.println("\nSize: " + stack.size() + "\nIs full?: " + stack.isFull());
	 	
	 	System.out.println("\npeeking...");
	 	System.out.println("Element: " + stack.peek());
	}

}
