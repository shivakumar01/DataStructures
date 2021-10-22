package stacksPractice;

import java.util.Stack;

public class StacksGetMinConstantTimeSpace {
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> s1 = new Stack<Integer>();
			int arr[] = {1,2,6,4,1,5,0};
			int min = Integer.MAX_VALUE;
			
			for(int i = 0;i<arr.length;i++) {
				s.push(arr[i]);
				
				if(arr[i] < min || arr[i] == min) {
					min = arr[i];
					s1.push(min);
				}
				
			}
			
			for(int i = 0;i<arr.length;i++) {
				
				int X = s.pop();
				if(X == min) {
					s1.pop();
					if(!s1.isEmpty())
						min = s1.peek();
					else
						min = Integer.MAX_VALUE;
				}
				System.out.println("deleted ele is : "+X+"current minimum is: "+ min);
			}
	}
}
