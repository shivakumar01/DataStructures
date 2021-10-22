package sorting;

public class SortingAlgos {

/* Bubble sort start */	
	void bubbleSort(int[] arr) {
		int temp,swaps = 0;
		for(int i = 0;i<arr.length-1;i++) {
			swaps = 0;
			System.out.println("pass "+(i+1));
			for(int j = 0;j<arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swaps++;
				}
			}
			
			if(swaps == 0) {
				i = arr.length-2;
			}
		}
		
		printSortedArr(arr);
		
	}
	
	
/* Bubble sort end */

/* selection sort start */
	void selectionSort(int[] arr) {
		int smallestPos = -1;
		int temp;
		for(int i = 0;i<arr.length-1;i++) {
//			System.out.println("pass "+(i+1));
			smallestPos = i;
			for(int j = i+1;j<arr.length;j++) {
				if(arr[j] < arr[smallestPos]) {
					smallestPos = j;
				}
			}
			
				temp = arr[i];
				arr[i] = arr[smallestPos];
				arr[smallestPos] = temp;
		}
		printSortedArr(arr);
		
	}
/* selection sort end */
	
	void insertionSort(int[] arr) {
		int temp;
		for(int i = 1;i<arr.length;i++) {
			temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = temp;
		}
		
		printSortedArr(arr);
	}
	
/* selection sort end */
	
/* shell sort start */
	
	void shellSort(int[] arr) {
		int gap = (int)Math.floor(arr.length/2);
		int temp;
		int pass = 1;
		while(gap >= 1) {
//			System.out.println("pass "+(pass++)+" "+gap);
		for(int k = gap;k<arr.length;k++) {	
			for(int i = k-gap;i>=0;i-=gap) {
				 if(arr[i] > arr[i+gap]) {
					 temp = arr[i];
					 arr[i] = arr[i+gap];
					 arr[i+gap] = temp;
				 }else {
					 break;
				 }
			}
		}	
//			printSortedArr(arr);
			gap =  (int)Math.floor(gap/2);
		}
		
	printSortedArr(arr);
		
	}
	
/* shell sort end */
	
/* Merge Sort start */
	
	void mergeSortUtil(int[] Arr, int lb, int ub) {
		mergeSort(Arr, lb, ub);
		printSortedArr(Arr);
	}
	
	
	void mergeSort(int[] Arr,int lb,int ub) {
		
		if(lb<ub) {
			int mid = (lb+ub)/2;
			mergeSort(Arr,lb,mid);
			mergeSort(Arr,mid+1,ub);
			merge(Arr,lb,mid,ub);
		}
		
		
	}
	
	
	void merge(int[] Arr,int lb,int mid,int ub) {
		System.out.println("merge");
		System.out.print("[ ");
		for(int i = lb;i<=mid;i++) {
			System.out.print(Arr[i]+" , ");
		}
		System.out.print(" ]");
		System.out.print("[ ");
		for(int i = mid+1;i<=ub;i++) {
			System.out.print(Arr[i]+" , ");
		}
		System.out.print(" ]");
		System.out.println();
		int k = 0,i = lb,j = mid+1;
		int L[] = new int[ub-lb+1];
		while(i <= mid && j <= ub) {
			if(Arr[i] > Arr[j]) {
				L[k++] = Arr[j];
				j++;
			}else {
				L[k++] = Arr[i];
				i++;
			}
		}
		
		while(i<=mid)
		{
			L[k++] = Arr[i++];
		}
		
		while(j<=ub)
		{
			L[k++] = Arr[j++];
		}
		
		
		for(int l = lb,m = 0;l<=ub;l++,m++) {
			Arr[l] = L[m];
		}
		
	}
	
	
/* Merge Sort end */

	
/* Quick Sort start */
	
	void quickSort(int Arr[], int lb, int ub) { 
		int end = ub, start = lb,pivot,temp;
		
		if(lb < ub) {
			pivot = Arr[lb];
		while(start < end) {
		
			while(start <= ub && Arr[start] <= pivot) {
				start++;
			}
			
			while(end >=lb && Arr[end] > pivot) {
				end--;
			}
			
			
			if(start < end && start <= ub && end >= lb ) {
					temp = Arr[start];
					Arr[start] = Arr[end];
					Arr[end] = temp;
			}
		}
	
		temp = Arr[end];
		Arr[end] = Arr[lb];
		Arr[lb] = temp;
	
		quickSort(Arr,lb,end-1);
		quickSort(Arr,end+1,ub);
		
		}
	}
	
	
	void quickSortUtil(int Arr[]) {
		quickSort(Arr,0,Arr.length-1);
		printSortedArr(Arr);
	}
	
/* Quick Sort end */
	
	
/* linear sort algorithms start */
	
	void countingSort(int Arr[]) {
		
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<Arr.length;i++) {
			if(max < Arr[i]) {
				max = Arr[i];
			}
		}
		System.out.println(max);
		int count[] = new int[max+1];
		int ArrN[] = new int[Arr.length];
		
		for(int i = 0;i<Arr.length;i++) {
			count[Arr[i]]++;
		}
		
		for(int i = 1;i<=max;i++) {
			count[i]+=count[i-1];
		}
		
		for(int i = 1;i<=max;i++) {
			System.out.print(count[i]+" ");
		}
//		System.out.println("count is" +Arr[9]);
		for(int i = Arr.length-1;i>=0;i--) {
			System.out.println(Arr[i]+" "+count[Arr[i]]);
			--count[Arr[i]];
	
			ArrN[count[Arr[i]]] = Arr[i];
			
		}
		
		for(int i = 0;i<Arr.length;i++) {
			Arr[i] = ArrN[i];
		}
		
		printSortedArr(Arr);
		
	}
	
	
	void radixSort(int[] Arr) {
		
		int max = Integer.MIN_VALUE;
	
		for(int i = 0;i<Arr.length;i++) {
			if(max < Arr[i]) {
				max = Arr[i];
			}
		}
		
		int count[] = new int[10];
		int arrN[] = new int[Arr.length];
		int arrN1[] = new int[Arr.length];
		
		for(int i = 0;i<Arr.length;i++) {
			arrN1[i] = Arr[i];
		}
		
		while(max > 0){
			
			count = new int[10];
			System.out.println("pass ");
			
			max/=10;
			
			for(int i = 0;i<Arr.length;i++) {
				count[(arrN1[i]%10)]++;
			}
			
			for(int i = 1;i<10;i++) {
				count[i]+=count[i-1];
			}
			
			printSortedArr(count);
			printSortedArr(arrN1);
			printSortedArr(Arr);
			
			System.out.println();
			
			for(int i = Arr.length-1;i>=0;i--) {
				count[arrN1[i]%10]--;
				arrN[count[arrN1[i]%10]] = Arr[i];
				
			}
			
			for(int i = 0;i<Arr.length;i++) {
				Arr[i] = arrN[i];
				arrN1[i] = Arr[i]/10;
			}
			
			printSortedArr(Arr);
			
		}
		
		printSortedArr(Arr);
		
	}
	

/* linear sort algorithms end  */
	
	
/* print utility */
	
	void printSortedArr(int[] arr) {
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
}
