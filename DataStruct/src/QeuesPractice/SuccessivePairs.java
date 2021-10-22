package QeuesPractice;
import java.util.*;



public class SuccessivePairs {
	
	public static void main(String args[]) {
		java.util.Stack<Integer> S = new java.util.Stack<Integer>();
		Queue Q = new Queue();
		int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		int len = 0;
		int K = 4;
		for(int i = 0;i<arr.length;i++) {
			Q.Enqueue(arr[i]);
		}
		len = arr.length;
		int pos = K;
		
		while(K-- > 0) {
			S.push(Q.Dequeue());
//			System.out.println("here");
		}
		
		while(!S.isEmpty()) {
			Q.Enqueue(S.pop());
		}
		
		for(int i = 0;i<len-pos;i++) {
			Q.Enqueue(Q.Dequeue());
		}
		
		while(!Q.isEmpty()) {
			System.out.print(Q.Dequeue()+" ");
		}
		
		
		
		
		
	}

}
