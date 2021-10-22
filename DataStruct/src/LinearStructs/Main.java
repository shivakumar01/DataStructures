package LinearStructs;

import java.util.*;
import java.io.PrintWriter;
import java.lang.*;
 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		long low = 1,high = 0,max = Integer.MIN_VALUE;
		long mid,ans = -1;
		
		Scanner S = new Scanner(System.in);
		
		int T = S.nextInt();
		for(int i = 0;i<T;i++){
			ans = -1;max = 0;low = 1;
			int P = S.nextInt();
			int L = S.nextInt();
			
			int arr[] = new int[L];
			
			
			for(int j = 0;j < L;j++){
				arr[j] = S.nextInt();
				max = Math.max(max,arr[j]);
			}
			
			high = (max*(P)*(P+1))/2;
			
			
			
			while(low <= high){
//				System.out.println(low+" "+high);
				mid = (low+high)>>1;
				if(isPossible(arr,mid,L,P)){
					ans = mid;
					high = mid-1;
				}else{
					low = mid+1;
				}
			}
			PrintWriter out = new PrintWriter(System.out);
			out.println(ans);
			out.flush();
//			if(S.hasNextLine())S.nextLine();
		}
		
	}
	
	static boolean isPossible(int[] arr,long barrier,int chefs,int P){
		int chef = 0,curr = 1,parathas = 0,rank;
		long sum = 0;
		
		while(chef < arr.length && parathas < P) {
			rank = arr[chef];
			if(sum+(curr*rank) <= barrier) {
				sum += (curr*rank);
				curr++;
			}else {
				chef++;
				if(chef >= arr.length)return false;
				sum = arr[chef];
				curr = 2;
			}
			parathas++;
		}
		
		if(parathas < P) {
			return false;
		}
		
	return true;	
	}
} 
