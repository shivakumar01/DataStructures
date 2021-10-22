package trees;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}

public class BinarySearchTree {
	Node root;
	
	void Inorder(Node n){
		if(n == null)return;
		Inorder(n.left);
		System.out.println(n.data);
		Inorder(n.right);
	}
	
	Node insert(Node n,int D) {
		if(n.data < D) {
			if(n.right!=null) {
				n.right =  insert(n.right,D);
			}else {
				n.right = new Node(D);
			}
		}else if(n.data > D) {
			if(n.left!=null) {
				n.left = insert(n.left,D);
			}else {
				n.left = new Node(D);
			}
		}
		
		return n;
	}
	
	void delete(Node n,int data) {
		Node prev = null,temp = null;
		while(n!=null) {
			if(n.data > data) {
				prev = n;
				n = n.left;
			}else if(n.data < data) {
				prev = n;
				n = n.right;
			}else {
				if(n.right==null && n.left==null) {
					if(prev.data > data) {
						prev.left = null;
						n = null;
					}else {
						prev.right = null;
						n = null;
					}
				}else if(n.right!=null || n.left!=null) {
					if(n.right!=null) {
						if(prev.right == n) {
							prev.right = n.right;
						}else {
							prev.left = n.right;
						}
					}else {
						if(prev.right == n) {
							prev.right = n.left;
						}else {
							prev.left = n.left;
						}
					}
					n = null;
				}else {
					temp = n;
					n = n.left;
					while(n.right != null) {
						prev = n;
						n = n.right;
					}
					temp.data = n.data;
					prev.right = n.left;
					n = null;
				}
			}
		}
	}
	
	Node find(Node n, int a,int b) {
		if((a < n.data && b > n.data) || (b < n.data && a > n.data)) {
			return n;
		}
		else if(n.data < a && n.data < b) {
			return find(n.right,a,b);
		}else {
			return find(n.left,a,b);
		}
		
	}
	
	int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;	
  boolean validity(Node n) {
	  
	  if(n == null)return true;
	  if(n.left!=null && max < n.left.data) {
		  max = n.left.data;
	  }
	  validity(n.left);
	  System.out.println("n is "+n.data+" max value is "+max);
	  if((n.left!=null && n.left.data < n.data) && n.data >= max) {
		  if(n.right!=null && min > n.right.data) {
			  min = n.right.data;
		  }
		  if(n.right!=null && max < n.right.data) {
			  System.out.println("max is "+max+" "+n.right.data);
			  max = n.right.data;
		  }
		  validity(n.right);
		  	if((n.right!=null && n.right.data < n.data) || n.data > min) {
		  		System.out.println("returning false");
		  		return false;
		  	}
	  }else if(n.left != null) {
		  return false;
	  }
	 return true;
  }
 	
}
