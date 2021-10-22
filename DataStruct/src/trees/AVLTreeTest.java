package trees;

public class AVLTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AVLTree A = new AVLTree();
		A.insert(A.getRoot(), 8);
		A.insert(A.getRoot(), 5);
		A.insert(A.getRoot(), 9);
		A.insert(A.getRoot(), 3);
		A.insert(A.getRoot(), 6);
		A.insert(A.getRoot(), 7);

		A.Inorder(A.getRoot());
		System.out.println();
	}

}
