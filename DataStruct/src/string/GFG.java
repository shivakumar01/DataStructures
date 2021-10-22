package string;

public class GFG {
	    
	    static int[] calculateMinMax(int[] arr, int start, int end){

	        int[] result = new int[2]; 
	        
//	        System.out.println(start+" "+end);
	         
	        if(start >= end){
	            result[0] =  arr[start];
	            result[1] = arr[start];
	            return result;
	        }
	        
//	        System.out.println("here");
	       
	       int[] res1=  calculateMinMax(arr,start,((start+end)/2));
	       int[] res2 = calculateMinMax(arr,((start+end)/2)+1,end);
	       
	      
	       
	       if(res1[0] > res2[0]){
	           result[0] = res2[0];
	       }else{
	           result[0] = res1[0];
	       }
	       
	        if(res1[1] > res2[1]){
	           result[1] = res1[1];
	       }else{
	           result[1] = res2[1];
	       }
	        
	     return result;
	    }
	    
	    
		public static void main (String[] args) {
			int[] arr = {1,2,3,4,5,19,0,2,6};
			int[] result = calculateMinMax(arr,0,arr.length-1);
			System.out.println(result[0]+" "+result[1]);
		}
	}
