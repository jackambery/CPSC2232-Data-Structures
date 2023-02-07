
public class StackRef<T> implements StackInterface<T> {
	
	private Node<T> top;

	public StackRef() {
		top = null;
	}

	public boolean push(T el) {
		Node<T> node = new Node<T>(el, top);
		top = node;
		return true;
	}

	public T pop() {
		if (empty()) {
			return null;
		}
		T data = top.getData();
		top = top.getNext();
		return data;
	}

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return top == null;
	}

}
