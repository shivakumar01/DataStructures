package QeuesPractice;

class QueueLL{
	Node head = null;
	Node rear = null;
	
	class Node{
		int data;
		Node prev;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	void pushFront(int data){
		Node n = new Node(data);
		if(head == null) {
			head = rear =  n;
		}else {
			head.prev = n;
			n.prev = null;
			n.next = head;
			head = n;
		}
	}
	
	void pushEnd(int data) {
		Node n = new Node(data);
		if(rear == null) {
			rear = head = n;
		}else {
			rear.next = n;
			n.prev = rear;
			n.next = null;
			rear = n;
		}
	}
	
	int popFront() {
		Node temp = null;
		if(head!=null) {
			temp = head;
			head = head.next;
			temp.next = null;
			if(head!=null)
				head.prev = null;
			return temp.data;
		}
			return -1;
	}
	
	int popRear() {
		Node temp = null;
		if(rear!=null) {
			
			temp = rear;
			rear = rear.prev;
			temp.prev = null;
			if(rear != null)
				rear.next = null;
			return temp.data;
		}
		
		return -1;
	}
	
}

public class HadTailLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueLL LL = new QueueLL();
		LL.pushFront(1);
		LL.pushEnd(2);
		LL.pushFront(3);
		System.out.println(LL.popFront());
		System.out.println(LL.popFront());
		System.out.println(LL.popRear());
		System.out.println(LL.popRear());
		System.out.println(LL.popRear());
		System.out.println(LL.popRear());
	}

}
