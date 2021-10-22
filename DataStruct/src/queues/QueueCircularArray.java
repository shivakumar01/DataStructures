package queues;

class Queue{
	int arr[];
	int front = -1, rear = -1;
	
	Queue(int capacity){
		arr = new int[capacity];
	}
	
	void Enqueue(int n) throws ArrayIndexOutOfBoundsException{
		if((front!=0 && rear!=arr.length && rear - front == 1) || (front == 0 && rear == (arr.length))) {
			throw new ArrayIndexOutOfBoundsException("The Queue is full");
		}
		
		if(front == -1) {
			front++;
			rear++;
		}
		
		if(rear == arr.length) {
			rear = 0;
		}
		
		arr[rear++] = n;
		
	}
	
	int dequeue() throws ArrayIndexOutOfBoundsException {
		if(front == -1 && rear == -1) {
			throw new ArrayIndexOutOfBoundsException("The Queue is empty");
		}
		
		int temp = arr[front];
		
		if(front == (rear-1)) {
			front = rear = -1;
		}else if(front == arr.length-1 ) {
			front = 0;
		}else {
			front++;
		}
		
		return temp;
		
	}
	
	boolean isEmpty(){
		if(front == -1)
			return true;
		return false;
	}
	
	
}

public class QueueCircularArray {
	public static void main(String args[]) {
			Queue q = new Queue(3);
			try {
				q.Enqueue(10);	
				q.Enqueue(20);
				q.Enqueue(100);	
//				q.Enqueue(1000);	
				System.out.println(q.dequeue());
				System.out.println(q.dequeue());	
				System.out.println(q.dequeue());
				System.out.println(q.dequeue());
			}catch(ArrayIndexOutOfBoundsException E) {
				System.out.println(E.getMessage());
			}
			
		return;
	}
}
