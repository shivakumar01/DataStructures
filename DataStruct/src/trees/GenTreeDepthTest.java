package trees;

public class GenTreeDepthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] Arr = {-1,0,1,6,6,0,0,2,7};
		int[] location = new int[Arr.length];
		int j,max = Integer.MIN_VALUE;
		for(int i = 0;i<Arr.length;i++) {
			j = i;
			while(Arr[j]!=-1 && Arr[Arr[j]]!=-1) {
				location[Arr[Arr[j]]]++;
				if(location[Arr[Arr[j]]]>max) {
					max = location[Arr[Arr[j]]];
				}
				j = Arr[j];
				
			}
		}
		
		System.out.println(max);
	}

}
