package QeuesPractice;



class Stack{
	
	Queue Q1 = new Queue();
	Queue Q2 = new Queue();
	
	void push(int data) {
		Q1.Enqueue(data);
	}
	
	int pop() {
		int len =  0;
		while(!Q1.isEmpty()) {
			len++;
			Q2.Enqueue(Q1.Dequeue());
		}
//		System.out.println(len);
			while(len>1) {
				len--;
//				System.out.println("len is "+len);
				Q1.Enqueue(Q2.Dequeue());
			}
		return Q2.Dequeue();
	}
	
}

public class StackTwoQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack S = new Stack();
		S.push(10);
		S.push(20);
		S.push(30);
		S.push(40);
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
	}

}
