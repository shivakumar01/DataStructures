package Stacks;

class Stack {
	int top;
	int capacity;
	int arr[] = null;
	Stack(int capacity){
		this.capacity = capacity;
		top = -1;
		arr = new int[capacity];
	}
	
	boolean isEmpty(){
		return top == -1;
	}
	
	boolean isFull() {
		return top == (capacity-1);
	}
	
	void push(int data) throws Exception {
		if(top == (capacity-1)) {
			throw new Exception("stack is full");
		}
		arr[++top] = data;
	}
	
	int pop() throws Exception {
		if(top == -1) {
			throw new Exception("stack is empty");
		}
		return arr[top--];
	}
	
}

public class StackImplArray {
	public static void main(String args[]) {
		Stack s = new Stack(3);
		try {
			s.push(2);
			s.push(1);
			s.push(9);
//			s.push(10 );
		}catch(Exception E) {
			System.out.println(E.getMessage());
		}
		
		try {
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
//			System.out.println(s.pop());
		}catch(Exception E) {
			System.out.println(E.getMessage());
		}
		
		
		
	}
}
