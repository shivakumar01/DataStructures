package queues;

import java.util.Stack;

class QueueLL{
	
	Node front,rear;
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	void push(int data){
		Node n = new Node(data);
		if(front == null) {
			front = rear = n;
		}else {
			rear.next = n;
			rear = n;
		}
	}
	
	int pop() throws ArrayIndexOutOfBoundsException{
		if(front == null) {
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		}
		
		Node temp = front.next;
		int data = front.data;
		front.next = null;
		if(front == rear) {
			rear = null;
		}
		front = temp;
		return data;
	}
	
	void reverse() {
		Stack<Integer> s = new Stack<Integer>();
		
		while(front!=rear) {
			s.push(pop());
		}
		
		while(!s.isEmpty()) {
			push(s.pop());
		}
		
	}
	
}

public class QueueLinkedList {
	public static void main(String args[]) {
		QueueLL LL = new QueueLL();
		
		LL.push(1);
		LL.push(10);
		LL.push(20);
		LL.push(30);
		LL.reverse();
		try {
			System.out.println(LL.pop());
			System.out.println(LL.pop());
			System.out.println(LL.pop());
			System.out.println(LL.pop());
			System.out.println(LL.pop());
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println(e.getLocalizedMessage());
	}
	}	
}
