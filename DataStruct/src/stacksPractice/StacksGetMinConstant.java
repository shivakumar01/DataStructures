package stacksPractice;

import java.util.Stack;


public class StacksGetMinConstant {
	public static void main(String args[]) {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> s1 = new Stack<Integer>();
		int arr[] = {2,6,4,1,5};
		int min = Integer.MAX_VALUE;
		
		for(int i = 0;i<arr.length;i++) {
			s.push(arr[i]);
			if(arr[i]<min) {
				s1.push(arr[i]);
				min = arr[i];
			}else {
				s1.push(min);
			}
		}
		
		for(int i = 0;i<arr.length;i++) {
			System.out.println("deleted ele is : "+s.peek()+"current minimum is: "+ s1.peek());
			int X = s.pop();
			int X1 = s1.pop();
		}
	
	}
}
