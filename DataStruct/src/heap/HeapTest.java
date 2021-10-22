package heap;

public class HeapTest {
	public static void main(String args[]) {
		Heap h = new Heap(9);
		int[] a = {17,13,6,1,4,2,5};
		for(int i = 0;i<a.length;i++) {
			h.insert(a[i]);
		}
		
		h.insert(20);
		System.out.println(h);
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
//		System.out.println("deleted item "+h.delete());
		
		
		
		
		h.ascSort();
	}

}
