package done;

import java.util.ArrayList;

import givens.YourStack;

public class YourArrayListStack implements YourStack {
	// YOU MUST USE THIS IMPLEMENTATION - just code the methods
	ArrayList<Integer> theStack = new ArrayList<>();

	@Override
	public void push(Integer i) {
		theStack.add(i);
	}

	@Override
	public Integer pop() {
		theStack.trimToSize();
		int item = theStack.get(theStack.size()-1);
		theStack.remove(theStack.size()-1);
		return item;
	}

	@Override
	public Integer size() {
		return theStack.size();
	}

}
