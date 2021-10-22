package dsc;




public class MedianMatrix {
	  static int binarySearchCount(int[][] matrix,int mid,int r,int c){
	        int count = 0;
	        int low, high;
	        int countMid;
	        for(int i = 0;i<r;i++){
	            low = 0;high = c-1;
	                while(low <= high) {
	                    countMid = (low+high)/2;
//	                    System.out.println("insder "+low+" "+high+" "+matrix[i][countMid]+" "+mid);
	                    if(matrix[i][countMid] <= mid)low = countMid+1;
	                    else high = countMid-1;
//	                    System.out.println("insder "+low+" "+high+" "+ (matrix[i][countMid] <= mid) );
	                }
	            count+=low;
	        }
	      return count;    
	    }
	    
	   static int median(int matrix[][], int r, int c) {
	        // code here 
	        int low = 0,high = (int)(Math.pow(10, 9));
	        int mid;
	        int count;
	        while(low <= high){
	            mid = (low+high)/2;
	            System.out.println("not insider "+low+" "+high);
	            count = binarySearchCount(matrix,mid,r,c);
	            System.out.println(count);
	            if(count <= (r*c)/2){
	               low = mid+1;
	            }else{
	                high = mid-1;
	            }
	        }
	      return low;
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int r= 3,c = 3;
		int[][] matrix = new int[r][c];
		int[] arr = {1,3,5,2,6,9,3,6,9};
		int pos = 0;
		for(int i = 0;i<r;i++) {
			for(int j = 0;j<c;j++) {
				matrix[i][j] = arr[pos++];
			}
		}
		
		for(int i = 0;i<r;i++) {
			for(int j = 0;j<c;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		System.out.println(median(matrix,3,3));

	}

}
