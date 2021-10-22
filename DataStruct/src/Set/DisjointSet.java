package Set;

public class DisjointSet {
	
	int[] arr;
	
	DisjointSet(int size){
		arr = new int[size];
		for(int i = 0;i<size;i++) {
			arr[i] = i;
		}
	}
	
	int find(int ele) {
		if(ele > arr.length) {
			return 0;
		}
		
		while(arr[ele]!=ele) {
			ele = arr[ele];
		}
		return ele;
	}
	
	void union(int ele1,int ele2) {
		if(ele1 == ele2) {
			return;
		}
		
		arr[ele1] = ele2;
	}
	
	void display() {
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	void unionBySize() {
		
	}

}
