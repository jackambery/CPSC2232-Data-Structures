package stack;

import java.util.ArrayList;

public class StackImpl implements Stack {

	ArrayList<String> stack = new ArrayList<String>();
	int capacity = 10; //default capacity of 10
	
	public StackImpl(int size) {
		capacity = size;
	}
	
	@Override
	public void push(String s) {
		if (stack.size() < capacity) {
			stack.add(s);
			stack.trimToSize();
		}
		else {
			System.out.println("---cannot add element, stack is full---");
		}
		
		
	}

	@Override
	public String pop() {
		String item = peek();
		stack.remove(stack.size() - 1);
		stack.trimToSize();
		return item;
	}

	@Override
	public Boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Boolean isFull() {
		if (stack.size() == capacity) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public String peek() {
		String item = stack.get(stack.size() - 1);
		return item;
	}

	@Override
	public void setCapacity(int size) {
		capacity = size;
		
	}

	@Override
	public void display() {
		System.out.println("Items in the stack: ");
		for (String s : stack) {
			System.out.println(s);
		}
		
	}

}
