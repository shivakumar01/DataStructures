package Stacks;

class StackDyn{
	
	int top;
	int capacity;
	int arr[] = null;
	StackDyn(int capacity){
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
	
	void push(int data) {
		if(top == (capacity-1)) {
			DoubleCap();
			System.out.println("capacity doubled");
		}
		arr[++top] = data;
	}
	
	int pop() throws Exception {
		if(top == -1) {
			throw new Exception("stack is empty");
		}
		return arr[top--];
	}
	
	void DoubleCap(){
		capacity = capacity * 2;
		int arr1[] = new int[capacity];
		for(int i = 0;i<=top;i++) {
			arr1[i] = arr[i];
		}
		arr = arr1;
	}
	
}

public class StackImplDynamicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackDyn s = new StackDyn(3);
		s.push(2);
		s.push(1);
		s.push(9);
		System.out.println(s.isEmpty()+" "+s.isFull());
		s.push(10);
		
		try {
			System.out.println(s.pop());
			System.out.println(s.pop());	
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
		}catch(Exception E) {
			System.out.println(E.getMessage());
		}
	}

}
