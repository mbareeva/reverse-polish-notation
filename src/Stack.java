
public interface Stack<T> {
	boolean isEmpty();
	
	void pop() throws UnderflowException;
	
	void push(T o) throws OverflowException;
	
	T top() throws UnderflowException;
	
}
