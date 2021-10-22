package dsc;

import java.util.HashMap;

public class MinSteps {
	
	class Memo{
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
	}
	
	static int minJumps(int arr[],int steps,int pos,Memo memo) {
		if(memo.hm.containsKey(pos)) {
//			System.out.println("found in memo "+pos);
			return memo.hm.get(pos);
		}
		if(pos >= arr.length-1) {
			return steps;
		}else if(arr[pos] == 0) {
			return -1;
		}
		
		steps++;
		int minSteps = Integer.MAX_VALUE;
		int nextPos = pos+arr[pos];
		int numSteps;
		
		while(nextPos > pos) {
			System.out.println(steps+" "+nextPos);
			numSteps = minJumps(arr, steps, nextPos,memo);
			if(minSteps > numSteps && numSteps >= 0) {
				minSteps = numSteps;
			}
			nextPos--;
		}
		
		memo.hm.put(pos, minSteps);
		
		return minSteps;
	}
	

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		System.out.println(minJumps(arr, 0 , 0,new MinSteps().new Memo()));
	}

}
