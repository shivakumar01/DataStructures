package string;

public class TerenarySearchTrie {
	
	private Node root;
	
	private class Node{
		
		char data;
		boolean isEndOfWord;
		Node left;
		Node right;
		Node middle;
		
		Node(char c){
			this.data = c;
		}
		
	}
	
	
	public void insert(String s) {
		
		root = insertUtil(s,root,0);
		
	}
	
	private Node insertUtil(String s,Node currentNode,int index) {
		
		if(index == s.length()) {
			return currentNode;
		}

		
		if(currentNode == null) {
			currentNode = new Node(s.charAt(index));
			currentNode.middle = insertUtil(s,null,++index);
			
			if(currentNode.middle == null) {
				currentNode.isEndOfWord = true;
				System.out.println(currentNode.data+" "+currentNode.isEndOfWord);;
			}
		}else{
			if(currentNode.data == s.charAt(index)) {
				currentNode.middle = insertUtil(s,currentNode.middle,++index);
			}
			else if(currentNode.data > s.charAt(index)) {
				currentNode.left = insertUtil(s,currentNode.left,index);
			}else if(currentNode.data < s.charAt(index)) {
				currentNode.right = insertUtil(s,currentNode.right,index);
			}
		}
				
		
		return currentNode;
		
	}
	
	public boolean search(String s) {
		
		Node currentNode = root;
		int index = 0;

		while(index<s.length()) {
			
			if(currentNode == null) {
				return false;
			}
			else if(currentNode.data == s.charAt(index)) {

				currentNode = currentNode.middle;
				index++;
				
				if(index == s.length()) {
					return true;
				}
				
			}else if(currentNode.data > s.charAt(index)) {
				currentNode = currentNode.left;
			}else {
				currentNode = currentNode.right;
			}
	   }
		
		
		return false;
	}
}
