package Set;

public class DisjointSetTest {
	public static void main(String args[]) {
		
		DisjointSet D = new DisjointSet(5);
//		D.display();
		D.union(0, 1);
//		D.display();
		D.union(1, 2);
//		D.display();
		D.union(2, 3);
//		D.display();
		D.union(3, 4);
		D.display();
	}

}
