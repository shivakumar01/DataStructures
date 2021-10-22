package Stacks;

import Stacks.LinkedList.Node;

class LinkedList{
	
	
	class Node{
		char data;
		Node next;
	
		Node(char data){
			this.data = data;
			this.next = null;
		}
		
	}
	
	Node head = null;
	void add(char data){
		Node n = new Node(data);
		if(head == null) {
			head = n;
		}
		else {
			n.next = head;
			head = n;
		}
	}
	
	Node delete() {
		if(head == null) {
			return head;
		}
		
		Node temp = head;
		head = temp.next;
		temp.next = null;
		
		return temp;
	}
	
	
	
}

class StackLL{	
	LinkedList LL = null;
	
	StackLL(){
		
		LL = new LinkedList();
		
	}
	
	void push(char data) {
		LL.add(data);
	}
	
	char pop() {
		Node n = LL.delete();
		if(n == null) {
			System.out.println("stack underflow");
		}else {
			System.out.println(n.data);
		}
		return n.data;
	}
	
	boolean isEmpty() {
		return LL.head == null;
	}

}

public class StackImplLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLL s = new StackLL();
		
		String S1 = "() (() [()])";
		char C[] = S1.toCharArray();
		Boolean valid = true;
		
		for(int i = 0;i<C.length;i++) {
			if(C[i] == '(' ||  C[i] == '{' || C[i] == '[') {
				s.push(C[i]);
			}else if(C[i] == ')' || C[i] == '}' || C[i] == ']') {
				if(!s.isEmpty()) {
					char popped = s.pop();
					if(C[i] == ')' && popped != '(' || C[i] == '}' && popped != '{' ||  C[i] == ']' && popped != '[') {
						valid = false;
						break;
					}
				}else {
					valid = false;
					break;
				}
				
			}
		}
		
		if(!s.isEmpty()) {
			valid = false;
		}
		
		System.out.println(valid);
	
	}

}
