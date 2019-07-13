package stack_queue;

public class Stack<T> implements StackInfo<T> {
	private int top,capacity,size;
	private Object A[];
	public Stack(){
		top =-1;
		capacity = 10000;
		size=0;
		A = new Object[capacity];
	}
	public Stack(int capacity){
		top =-1;
		this.capacity = capacity;
		size=0;
		A = new Object[capacity];
	}
	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(top == size)
			return true;
		return false;
	}

	@Override
	public void push(T o) {
		if(isFull()){
			System.out.println("Stack is full cannot push more");
		}else{
			top++;
			A[top]= (T)o;
			size++;
		}
		
	}

	@Override
	public T pop() {
		if(isEmpty()){
			System.out.println("Stack is empty cannot pop an element");
		}else{
			@SuppressWarnings("unchecked")
			final T o = (T)A[top];
			top--;
			size--;
			return o;
		}
		return null;
	}

	@Override
	public T peek() {
		if(!isEmpty()){
			@SuppressWarnings("unchecked")
			final T o =  (T) A[top];
			return o;
		}
		return null;
	}
	@Override
	public int size(){
		return size;
	}

}
