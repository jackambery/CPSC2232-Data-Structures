
public interface StackInterface<T> {
	
	public boolean full();

	public boolean empty();

	public boolean push(T el);

	public T pop();
}
