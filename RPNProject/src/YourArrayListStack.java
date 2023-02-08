
import java.util.ArrayList;

public class YourArrayListStack implements YourStack {
	// YOU MUST USE THIS IMPLEMENTATION - just code the methods
	ArrayList<Integer> theStack = new ArrayList<>();

	@Override
	public void push(Integer i) {
		theStack.add(i);
	}

	@Override
	public Integer pop() {
		int item = theStack.get(theStack.size());
		theStack.set(theStack.size(), null);
		return item;
	}

	@Override
	public Integer size() {
		return theStack.size();
	}

}
