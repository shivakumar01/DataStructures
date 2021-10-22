package trees;

public class BinarySearchTest {
		public static void main(String args[]) {
		
				BinarySearchTree B = new BinarySearchTree();
				B.root = new Node(6);
				B.root.left = new Node(2);
				B.root.right = new Node(8);
				B.root.left.left = new Node(1);
				B.root.left.right = new Node(9);
				
//				B.insert(B.root, 5);
//				B.insert(B.root, 9);
//				B.insert(B.root, 7);
//				B.insert(B.root, 6);
				
//				B.Inorder(B.root);
//				B.delete(B.root,8);
//				B.Inorder(B.root);
				System.out.println(B.validity(B.root));
			
//				System.out.println("The LCA is "+B.find(B.root,5,9).data);
			
		}
}
