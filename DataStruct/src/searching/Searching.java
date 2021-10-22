package searching;

public class Searching {
	
	
	public int BinarySearch(int Arr[], int ele,int low, int high) {
		
		int mid = (low+high)/2;
		
		System.out.println(mid+" "+Arr[mid]+" "+ele+" "+low+" "+high);
		
		if(low > high) {
			return -1;
		}
		
		if(Arr[mid] > ele) {
			System.out.println("more");
			return BinarySearch(Arr,ele,0,mid-1);
		}else if(Arr[mid] < ele) {
			System.out.println("less");
			return BinarySearch(Arr,ele,mid+1,high);
		}else if(Arr[mid] == ele) {
			System.out.println("matching");
			return mid;
		}
		
		return -1;
		
	}

}
