package heap;

public class Heap {

	private int[] arr;
	private int hCount;
	private int capacity;
	
	Heap(int capacity){
		arr = new int[capacity];
		this.hCount = -1;
		this.capacity = capacity;
	}
	
	/* insert into the heap */
	
	public void insert(int data) {
		if(hCount == capacity) {
			System.out.println("Full");
			return;
		}
		hCount++;
		arr[hCount] = data;
		
		
		prelocateUp();
		
		display();
	}
	
	public int delete() {
		
		int data = arr[0];
		
		arr[0] = arr[hCount];
		hCount--;
		prelocateDown();
		display();
		return data;
	}
	
	private void display() {
		for(int i = 0;i<=hCount;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	private void prelocateUp() {
		System.out.println("prelocating");
		int i = hCount;
		int parent = (i)/2;
		int temp;
//		System.out.println("first at "+parent+" "+i);
		while(i>0 && arr[parent] < arr[i]) {
//			System.out.println("swap at "+parent+" "+i);
			temp = arr[parent];
			arr[parent] = arr[i];
			arr[i] = temp;
			i = parent;
			parent = (i)/2;
		}
	}
	
	private void prelocateDown() {
		int i = 0;
		int rChild = (2*i)+1;
		int lChild = (2*i)+2;
		int rChildData = 1,lChildData = 2,temp;
		
		
		do {
			
			if(rChild > hCount) {
				rChild = -1;
			}else {
				rChildData = arr[rChild];
			}
			
			if(lChild > hCount) {
				lChild = -1;
			}else {
				lChildData = arr[lChild];
			}
			
			if(rChild!=-1) {
				if(lChild != -1) {
					if(rChildData > lChildData) {
						temp = rChildData;
						arr[rChild] = arr[i];
						arr[i] = temp;
						i = rChild;
					}else {
						temp = lChildData;
						arr[lChild] = arr[i];
						arr[i] = temp;
						i = lChild;
					}
				}
			}else{
				if(lChild!=-1) {
					temp = lChildData;
					arr[lChild] = arr[i];
					arr[i] = temp;
					i = lChild;
				}else {
					return;
				}
			}
			rChild = (2*i)+1;
			lChild = (2*i)+2;
		}while(rChild < hCount || lChild < hCount);
		
		
		return;
		
	}
	
	
	void ascSort() {
		int totalEle=0;
		while(hCount>0) {
		int data = delete();
		System.out.println("data received is "+data);
		arr[hCount+1] = data;
		totalEle++;
		}
		hCount = totalEle;
		display();
	}
	
	
	
	
	
}
