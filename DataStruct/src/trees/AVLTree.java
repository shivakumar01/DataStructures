package trees;

public class AVLTree {
	
	class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		Node(int data){
			this.data = data;
			height = 1;
		}
	}
	
	private Node root = null;
	private int heightDiff = 0;
	
	public Node getRoot() {
		return root;
	}
	
	public void insert(Node node,int item) {
		this.root = insertAVL(node, item);
	}
	
	public Node insertAVL(Node node,int item) {
		
		if(node == null) {
			if(root == null) {
				root = new Node(item);
				return root;
			}
			return new Node(item);
		}
		
		if(node.data<item) {
			node.right = insertAVL(node.right,item);
		}else if(node.data > item) {
			node.left = insertAVL(node.left,item);
		}
		
		/* calculating height difference */
		
		heightDiff = height(node.left) - height(node.right);
		
		if(heightDiff > 1 && node.left.data > item) {
			/* Right Rotate */
			System.out.println("left left case");
			return rightRotate(node);
		}else if(heightDiff < -1 && node.right.data < item) {
			/* Left Rotate */
			System.out.println("right right case");
			return leftRotate(node);
		}else if(heightDiff > 1 && node.left.data < item) {
			System.out.println("left right case");
			node.left =  leftRotate(node.left);
			return rightRotate(node);
		}else if(heightDiff < -1 && node.right.data > item) {
			System.out.println("right left case");
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		node.height = Math.max(height(node.left),height(node.right))+1;
		
		return node;
		
	}
	
	
	private Node rightRotate(Node n) {
		Node temp1 = n.left.right;
		Node temp2 = n.left;
		temp2.right = n;
		n.left = temp1;
		n.height = Math.max(height(n.left), height(n.right))+1;
		temp2.height = Math.max(height(n.left), height(n.right))+1;
		return temp2;
	}
	
	private Node leftRotate(Node n) {
		Node temp1 = n.right.left;
		Node temp2 = n.right;
		temp2.left = n;
		n.right = temp1;
		n.height = Math.max(height(n.left), height(n.right))+1;
		temp2.height = Math.max(height(n.left), height(n.right))+1;
		return temp2;
	}
	
	private int height(Node n) {
		if(n == null)return 0;
		return n.height;
	}
	
	public void Inorder(Node n) {
		if(n == null) {
			return;
		}
		Inorder(n.left);
		System.out.print(n.data+" ");
		Inorder(n.right);
	}
	
	
	

}
