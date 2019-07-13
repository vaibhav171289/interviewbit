package stack_queue;

public interface StackInfo<T> {
	
	boolean isEmpty();
	boolean isFull();
	void push(T o);
	T pop();
	T peek();
	int size();
}
