package QeuesPractice;

import java.util.Stack;

class Queue{
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	void Enqueue(int data) {
		s1.push(data);
	}
	
	int Dequeue() throws ArrayIndexOutOfBoundsException {
		
		if(s2.isEmpty()) {
			if(s1.isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("Queue is empty");
			}
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		
		return s2.pop();
		
	}
	
	boolean isEmpty() {
		if(s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		return false;
	}
	
}

public class QueueTwoStacks {

	public static void main(String args[]) {
		Queue Q = new Queue();
		Q.Enqueue(10);
		Q.Enqueue(11);
		Q.Enqueue(12);
		Q.Enqueue(13);
		
		try {
			System.out.println(Q.Dequeue());
			System.out.println(Q.Dequeue());
			System.out.println(Q.Dequeue());
			System.out.println(Q.Dequeue());
			System.out.println(Q.Dequeue());
		}catch(ArrayIndexOutOfBoundsException E) {
			System.out.println(E.getMessage());
		}
	}
	
}
