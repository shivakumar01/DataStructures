package trees;
import java.util.*;
import queues.QueueCircularArray;

public class Tree {

	Node root;
	
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	/* traversals */
	
	void preOrder(Node node){
		System.out.println(node.data);
		if(node.left == null) {
			return;
		}
		preOrder(node.left);
		if(node.right == null) {
			return;
		}
		preOrder(node.right);
	}
	
	
	void preOrderIterative(){
		Node n = root;
		Stack<Tree.Node> s = new Stack<Tree.Node>();
		while(n!=null) {
			processSubTree(n,s);
			if(!s.isEmpty()) {
				n = s.pop();
				n = n.right;
			}else {
				n = null;
			}
		}
	}

	void processSubTree(Node n,Stack<Tree.Node> s) {
		while(n.left!=null) {
			System.out.println(n.data);
			s.push(n);
			n = n.left;
		}
		System.out.println(n.data);
	}
	
	
	void inOrder(Node n) {
		if(n == null) {
			return;
		}
		inOrder(n.left);
		System.out.println(n.data);
		inOrder(n.right);
	}

	void inOrderItervative(Node n) {
		Stack<Tree.Node> s = new Stack<Tree.Node>();
		while(n!=null) {
			processInorderSubTree(n,s);
			if(!s.isEmpty()) {
//				System.out.println("popped");
				n = s.pop();
				System.out.println(n.data);
			}
			else { 
				n = null;
			}
			
			
			while(n!=null && n.right == null) {
				if(!s.isEmpty()) {
//					System.out.println("popped again");
					n = s.pop();
					System.out.println(n.data);
				}else {
					n = null;
				}
			}
			if(n!=null) {
				n = n.right;
			}
		}
	}
	
	void processInorderSubTree(Node n, Stack<Tree.Node> s) {
		while(n!=null) {
//			System.out.println("n data is "+n.data);
			s.push(n);
			n = n.left;
		}
	}
	
	void postOrder(Node n) {
		if(n == null) {
			return;
		}
		postOrder(n.left);
		postOrder(n.right);
		System.out.println(n.data);
	}
	
	void postOrderIterative(Node n) {
		Stack<Tree.Node> s = new Stack<Tree.Node>();
		Tree.Node previous = null;
		do {
			while(n!=null) {
				s.push(n);
				n = n.left;
			}
			while(n==null && !s.isEmpty()) {
				n = s.peek();
				if(n.right == null || n.right == previous) {
					System.out.println(n.data);
					s.pop();
					previous = n;
					n = null;
				}else {
					n = n.right;
				}
			}
		}while(!s.isEmpty());
	}
	
	void levelOrder(Node n) {
		Deque<Tree.Node> Q = new ArrayDeque<Tree.Node>();
		if(n!=null)
			Q.add(n);
		else
			System.out.println("Tree is empty");
		while(!Q.isEmpty()) {
			Node current = Q.poll();
			System.out.println(current.data);
			if(current.left!=null) {
				Q.add(current.left);
			}
			if(current.right!=null) {
				Q.add(current.right);
			}
		}
	}
	
	/* practice program code */
	int max = Integer.MIN_VALUE;
	int maximum(Node n) {
		findMaximum(n);
		return max;
	}
	
	void findMaximum(Node n) {
		if(n == null) {
			return;
		}else {
			if(n.data > max) {
				max = n.data;
			}
		}
		maximum(n.left);
		maximum(n.right);
	}
	
	int findEle(Node n,int data) {
		if(n == null) {
			return 0;
		}else if(n.data == data) {
			return 1;
		}
		
		int status = findEle(n.left,data);
		if(status == 1) {
			return 1;
		}
		return findEle(n.right,data);
	
	}
	
	void insertEle(int data) {
		Queue<Tree.Node> Q = new ArrayDeque<>();
		Q.add(root);
		Node n1 = new Node(data);
		while(!Q.isEmpty()) {
			Node ele = Q.poll();
			if(ele.left == null) {
				ele.left = n1;
				return;
			}else {
				Q.add(ele.left);
			}
			
			if(ele.right == null) {
				ele.right = n1;
				return;
			}else {
				Q.add(ele.right);
			}
		}
		
	}
	int size = 0;
	int sizeOfBinaryTree(Node n) {
		if(n == null) return 0;
		else size++;
		sizeOfBinaryTree(n.left);
		sizeOfBinaryTree(n.right);
		return size;
	}
	
	void levelOrderReverse(Node n) {
		Queue<Tree.Node> Q = new ArrayDeque<Tree.Node>();
		Stack<Tree.Node> S = new Stack<Tree.Node>();
		Q.add(n);
		while(!Q.isEmpty()) {
			Node ele = Q.poll();
			S.push(ele);
			if(ele.right!=null)
				Q.add(ele.right);
			if(ele.left!=null)
				Q.add(ele.left);
		}
		
		while(!S.isEmpty()) {
			System.out.print(S.pop().data+" ");
		}
		System.out.println();
	}
	
	void deleteTree(Node n) {
		if(n == null)return;
		deleteTree(n.left);
		deleteTree(n.right);
		if(n.left != null)
			n.left = null;
		if(n.right!=null)
			n.right = null;
		root = null;
	}
	
	int heightL = 0,heightR = 0;
	int maximum = Integer.MIN_VALUE;
	int heightOfTree(Node n) {
		if(n == null)return 0;
		else {
			heightL = heightOfTree(n.left);
			heightR = heightOfTree(n.right);
			if(heightL > heightR) return (heightL+1);
			return heightR+1;
		}
	}
	
	Node findDeepestNode(Node n) {
		Queue<Tree.Node> Q = new ArrayDeque<Tree.Node>();
		Q.add(n);
		Node deepEle = null;
		while(!Q.isEmpty()) {
			deepEle = Q.poll();
//			System.out.println(deepEle.data);
			if(deepEle.left!=null) Q.add(deepEle.left);
			if(deepEle.right!=null) Q.add(deepEle.right);
		}
		return deepEle;
	}
	
	Node[] findDeepestNodeForDeletion(Node n) {
		Queue<Tree.Node> Q = new ArrayDeque<Tree.Node>();
		Q.add(n);
		Node deepEle = null;
		Node prevEle = null;
		while(!Q.isEmpty()) {
			deepEle = Q.poll();
//			System.out.println(deepEle.data);
			if(deepEle.left!=null) {
				prevEle = deepEle;
				Q.add(deepEle.left);
			}
			if(deepEle.right!=null) {
				prevEle = deepEle;
				Q.add(deepEle.right);
			}
		}
		Node[] Arr = {deepEle,prevEle};
		return Arr;
	}
	
	void deleteEle(Node n,int ele) {
		Queue<Tree.Node> Q = new ArrayDeque<Tree.Node>();
		Node[] Arr;
		Q.add(n);
		int currentEle = n.data;
		Node currentNode = n;
		Node parentNode = null;
		while(!Q.isEmpty() && parentNode == null) {
			currentNode = Q.poll();
			
			if(currentNode.left!=null) {
				if(currentNode.left.data == ele) { 
					parentNode = currentNode;
					currentNode = currentNode.left;
				}else 
				Q.add(currentNode.left);
			}
			if(currentNode.right!=null) {
				if(currentNode.right.data == ele) { parentNode = currentNode;
				currentNode = currentNode.right;}
				else
				Q.add(currentNode.right);
			}
		}
		if(ele == currentNode.data) {
			Arr = findDeepestNodeForDeletion(currentNode);
//			System.out.println(Arr[0].data);
			if(Arr[0] != null && Arr[0].data!=ele) {
				currentNode.data = Arr[0].data;
				if(Arr[1].right!=null) {
					Arr[1].right = null;
				}else {
					Arr[1].left = null;
				}
			}
			else
			{
				if(parentNode.right.data == ele) {
					parentNode.right = null;
				}else {
					parentNode.left = null;
				}
			}
		}
			return;
		
	}
	
	
	boolean checkStructure(Node n1,Node n2) {
		if((n1 == null && n2!=null) || (n1!=null & n2 == null)) {
//			System.out.println(n1.data+" "+n2);
			return false;
		}else if(n1 == null && n2 == null) {
			return true;
		}
		
		return checkStructure(n1.left, n2.left) && checkStructure(n1.right, n2.right);
		
//		boolean status = checkStructure(n1.left,n2.left);
//		if(status) {
//			status = checkStructure(n1.right, n2.right);
//			if(!status) {
//				return status;
//			}
//		}
//		return status;
	}
	
	
	int sum = 0;
	int sumTree(Node n) {
		if(n == null)return 0;
		sumTree(n.left);
		sumTree(n.right);
		sum+=n.data;
		return sum;
	}
	
	
	
	
}
