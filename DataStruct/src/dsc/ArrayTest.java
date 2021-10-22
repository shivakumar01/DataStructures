package dsc;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arrays.kthSmallest K = new Arrays().new kthSmallest(10);
		
		int[] a = {17,13,6,1,4,2,5,0};
//		for(int i = 0;i<a.length;i++) {
////			System.out.println("inserting");
//
//			K.insert(a[i]);
//		}
//		
////		System.out.println("deleting");
//		
//		for(int i = 0;i<2;i++) {
//			System.out.println(K.delete());
//		}
//		
//		System.out.println(K.delete());
		
		System.out.println(K.quickSelect(a, 0,a.length-1, 4));

	}

}
