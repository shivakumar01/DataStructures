
package string;

public class StringAlgo {
	
	
	public int stringSearchBruteForce(String s, String p) {
		int j = 0,count = 0,pos = 0;
		boolean found = false;
			for(int i = 0;i<s.length();i++) {
				if(!found && s.charAt(i) == p.charAt(j)) {
					found = true;
					pos = i;
					count = 0;
				}
				System.out.println(i+" "+j);
				if(found && s.charAt(i) == p.charAt(j)) {
					count++;
					j++;
				}else {
					found = false;
					j = 0;
					count = 0;
					pos = 0;
				}
				
				if(count == p.length()) {
					return pos;
				}
			}
		return -1;	
	}
	
	
	public int RobinKarpAlgo(String s, String p) {
		int hashP = 0;
		int hashS = 0;
		int pLen = p.length();
		int j = pLen-1;
		
		for(int i = 0;i<pLen;i++) {
			hashP += Math.pow(10,j)*p.charAt(i);
			hashS += Math.pow(10,j--)*s.charAt(i);
		}
		
		System.out.println(hashP+" "+hashS);
		
		if(compareHash(hashS,hashP,s,p,0) == 1) {
			return 0;
		}
		
		j = pLen-1;
		
		for(int i = 1;i<=(s.length()- p.length());i++) {

			hashS -= (Math.pow(10,j))*s.charAt(i-1);
			hashS *= 10;
			hashS += s.charAt(i+j);
	
			if(compareHash(hashS,hashP,s,p,i) == 1) {
				
				return i;
				
			}
	
		}
		
		return -1;
		
	}
	
	private int compareHash(int hashS, int hashP,String s,String p,int i) {
//		int pos = 0;
		if(hashS == hashP) {
			
			for(int k = i;k<(i+p.length());k++) {
				
				if(s.charAt(k) != p.charAt(k-i)) {
					
					return -1;
				}
				
			}	
		
	 }else {
		 return -1;
	 }
	   return 1;	
	}
	
	
	public int KMPAlgo(String s, String p) {
		
		int i = 1,j = 0;
		int[] piTable = new int[p.length()];
		piTable[0] = 0;
		
		/* constructing lps table */
		
		while(i<p.length()) {
			if(p.charAt(i) == p.charAt(j)) {
				j++;
				piTable[i] = j;
				i++;
			}else {
				
				if(j!=0) {
					j = piTable[j-1];
				}else {
					piTable[i] = 0;
					i++;
				}
			}
		}
		
		/* searching the pattern*/
		
		for(int k = 0;k<p.length();k++) {
			System.out.print(piTable[k]+" ");
		}
		System.out.println(" ");
		
		i = 0;j = 0;
		
		
		while(i<s.length()) {
			if(s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				
				if(j == p.length() || j == s.length()) {
					return i - j;
				}
				
			}else {
				if(j!=0)
					j = piTable[j-1];
				else
					i++;
			}
		}
	
		
		return -1;
		
	}
	

}
