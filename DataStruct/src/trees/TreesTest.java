package trees;

public class TreesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree T = new Tree();
		Tree.Node n = T.new Node(1);
		T.root = n;
		Tree.Node n1 = T.new Node(2);
		Tree.Node n2 = T.new Node(3);
		n.left = n1;
		n.right = n2;
		Tree.Node n3 = T.new Node(4);
		Tree.Node n4 = T.new Node(5);
		n1.left = n3;
		n1.right = n4;
		Tree.Node n5 = T.new Node(6);
		Tree.Node n6 = T.new Node(7);
		n2.left = n5;
		n2.right = n6;
		Tree.Node n7 = T.new Node(8);
		Tree.Node n8 = T.new Node(9);
		n4.left = n7;
		n4.right = n8;
		T.preOrderIterative();
		System.out.println("*****inorder******");
		T.inOrder(T.root);
		System.out.println("*****inorder iterative******");
		T.inOrderItervative(T.root);
		System.out.println("*****postOrder*****");
		T.postOrder(T.root);
		System.out.println("*****postOrder iterative*****");
		T.postOrderIterative(T.root);
		System.out.println("*****levelOrder iterative*****");
		T.levelOrder(T.root);
		System.out.println("*****maximum value*****");
		System.out.println(T.maximum(T.root));
		System.out.println("*****find value*****");
		System.out.println(T.findEle(T.root,10));
		System.out.println("*****insert ele*****");
//		T.insertEle(10);
//		T.insertEle(11);
//		T.insertEle(12);
		T.levelOrder(T.root);
		System.out.println("Size of the tree is");
		System.out.println(T.sizeOfBinaryTree(T.root));
		System.out.println("level order reverse is");
		T.levelOrderReverse(T.root);
//		T.deleteTree(T.root);
		System.out.println("level order is");
		T.levelOrder(T.root);
		System.out.println("height is");
		System.out.println(T.heightOfTree(T.root)+1);
		System.out.println("************Deepest element is************");
		Tree.Node deepEle = T.findDeepestNode(T.root);
		if(deepEle!=null) {
			System.out.println(deepEle.data);
		}else {
			System.out.println("The tree is empty");
		}
		
		System.out.println("************Delete element is************");
		T.deleteEle(T.root, 3);
		T.levelOrder(T.root);
		
		
		Tree T1 = new Tree();
		Tree.Node d1 = T1.new Node(1);
		T1.root = d1;
		Tree.Node d2 = T1.new Node(2);
		Tree.Node d3 = T1.new Node(3);
		d1.left = d2;
		d1.right = d3;
		d2.left = T1.new Node(4);
		
		Tree T2 = new Tree();
		Tree.Node dd1 = T1.new Node(1);
		T2.root = dd1;
		Tree.Node dd2 = T2.new Node(2);
		Tree.Node dd3 = T2.new Node(3);
		dd1.left = dd2;
		dd1.right = dd3;
		Tree.Node dd4 = T2.new Node(4);
		dd2.right = dd4;
		
		
		System.out.println(T1.checkStructure(T1.root,T2.root));
		System.out.println("******************* sum is ****************");
		System.out.println(T.sumTree(T1.root));
		
		
		
		
		
	}

}
