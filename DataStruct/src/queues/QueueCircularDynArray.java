package queues;

class QueueDyn{
	int arr[];
	int front = -1, rear = -1;
	int capacity;
	
	QueueDyn(int capacity){
		arr = new int[capacity];
		this.capacity = capacity;
	}
	
	void Enqueue(int n) throws ArrayIndexOutOfBoundsException{
		System.out.println("rear is : "+rear+" front is : "+front);
		if((front!=0 && rear!=arr.length && rear - front == 0) || (front == 0 && rear == (arr.length))) {
			this.capacity = capacity*2;
			int[] arr1 = new int[this.capacity];int pos = 0;
			if(front>rear){
				
				for(int i = front-1;i<arr.length;i++) {
					System.out.println("here "+arr[i]);
					arr1[pos++] = arr[i];
				}
				
				for(int i = 0;i<rear;i++) {
					arr1[pos++] = arr[i];
				}
				
			}else {
//				System.out.println("else here");
				for(int i = 0;i<rear;i++) {
					arr1[pos++] = arr[i];
				}

			}
			arr = arr1;
			front = 0; rear = pos;
			arr1  = null;
//			throw new ArrayIndexOutOfBoundsException("The Queue is full");
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



public class QueueCircularDynArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			QueueDyn Q = new QueueDyn(3);
			Q.Enqueue(10);
			Q.Enqueue(20);
			Q.Enqueue(30);
			System.out.println(Q.dequeue());
			Q.Enqueue(40);
			Q.Enqueue(45);
			Q.Enqueue(55);
			Q.Enqueue(65);
			
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
			System.out.println(Q.dequeue());
						Q.Enqueue(65);
						System.out.println(Q.dequeue());

	}

}
