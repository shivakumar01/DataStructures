package dsc;

public class Arrays {
	
	/*   Kth smallest element - sorting and search O(NlogN) */
	
	class kthSmallest{
		
		int[] heap;
		int size = 0;
		int capacity;
		
		kthSmallest(int capacity){
			heap = new int[capacity];
			this.capacity = capacity;
		}
		
		/* using min heap*/
		
		void insert(int ele) {
			
			if(size == capacity) {
				System.out.println("heap is full");
			}else {
				heap[size++] = ele;
				prelocateUp();
//				display();
			}
			
			
		}
		
		private void display() {
			for(int i = 0;i<size;i++) {
				System.out.print(heap[i]+" ");
			}
			System.out.println();
		}
		
		int delete() {
			int deletedEle;
			if(size < 0) {
				deletedEle = -1;
				System.out.println("heap is empty");
			}else {
				deletedEle = heap[0];
				size--;
				heap[0] = heap[size];
				prelocateDown();
//				display();
			}
			return deletedEle;
		}
		
		void prelocateUp() {
			int pos = size-1;
			int parent = (pos/2);
			int temp;
			
		
			while(pos > 0 && heap[parent] > heap[pos]) {
//				System.out.println(parent+" "+pos);
				temp = heap[parent];
				heap[parent] = heap[pos];
				heap[pos] = temp;
				pos = parent;
				parent = parent/2;
			}
			}
			
		
		
		
		void prelocateDown() {
			int parent = 0;
			int rChild = (2*parent)+1;
			int lChild = (2*parent)+2;
			int temp;
			
			while((rChild < size || lChild < size) && (heap[parent] > heap[rChild] || heap[parent] > heap[lChild])) {
//				System.out.println(rChild+" "+lChild);
				if(lChild < size && heap[parent] > heap[lChild] && heap[lChild] < heap[rChild]) {
					temp = heap[parent];
					heap[parent] = heap[lChild];
					heap[lChild] = temp;
					parent = lChild;
				}else if(rChild < size && heap[parent] > heap[rChild]) {
					temp = heap[parent];
					heap[parent] = heap[rChild];
					heap[rChild] = temp;
					parent = rChild;
				}
				
				rChild = (2*parent)+1;
				lChild = (2*parent)+2;
				
			}
			
		}
		
		/* using quick select */
		
		int quickSelect(int[] arr, int lb, int ub,int pos) {
			
			int pivot = arr[lb];
			int temp;
			int start = lb;
			int end = ub;
			
			while(start < end) {
				
				while(start <=ub  && arr[start] <= pivot) {
					start++;
				}
				
				while(end >= lb && arr[end] > pivot) {
					end--;
				}
				
				if(start < end) {
					temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
				}
				
			}
			

			temp = arr[end];
			arr[end] = pivot;
			arr[lb] = temp;

			
			
			if(end == pos) {
				return arr[end];
			}else if(end > pos) {
				return quickSelect(arr,lb, end-1,pos);
			}
				return quickSelect(arr,end+1,ub ,pos);
			
		
	}
	
	}
}
