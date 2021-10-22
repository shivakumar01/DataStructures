package string;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private TrieNode root = new TrieNode();
	
	class TrieNode{
		
		private Map<Character,TrieNode> map;
		private boolean isEndOfWord;
		
		public TrieNode() {
			this.map = new HashMap<Character, TrieNode>();
			this.isEndOfWord = false;
		}
		
		public TrieNode(boolean isEndOfWord) {
			this.map = new HashMap<Character, TrieNode>();
			this.isEndOfWord = isEndOfWord;
		}
		
	}
	
	public void insert(String s) {
		
		int i = 0;
		TrieNode currentNode = root;
		
		
	while(i < s.length()) {	
		if(!currentNode.map.containsKey(s.charAt(i))) {
			if(i == s.length()-1)
				currentNode.map.put(s.charAt(i),new TrieNode(true));
			else
				currentNode.map.put(s.charAt(i),new TrieNode());
		}
		currentNode = currentNode.map.get(s.charAt(i));
		i++;
	}
	
  }
	
	
    public boolean search(String s) {
    	
    	int i = 0;
    	TrieNode currentNode = root;
    	
    	while(i<s.length()) {
    		System.out.println(currentNode.map.keySet());
    		if(currentNode.map.containsKey(s.charAt(i))) {
    			currentNode = currentNode.map.get(s.charAt(i));
    			i++;
    		}else {
    			return false;
    		}

    	}
    
    	return currentNode.isEndOfWord;
    }
    
    
 public boolean searchPrefix(String s) {
    	
    	int i = 0;
    	TrieNode currentNode = root;
    	
    	while(i<s.length()) {
    		System.out.println(currentNode.map.keySet());
    		if(currentNode.map.containsKey(s.charAt(i))) {
    			currentNode = currentNode.map.get(s.charAt(i));
    			i++;
    		}else {
    			return false;
    		}

    	}
    	
    	return true;
    }
    
    
   public void delete(String s) {
	   if(delete(s,root,0)) {
		   root = null;
	   }
   }
	
   private boolean delete(String s,TrieNode currentNode,int i) {
	   
	   if(i == s.length()) {
		   if(currentNode.map.isEmpty()) {
			   currentNode.isEndOfWord = false;
			   return true;   
		   }else {
			   currentNode.isEndOfWord = false;
			   return false;
		   }
	   }
	   
	   if(currentNode.map.containsKey(s.charAt(i))) {
		   if(delete(s,currentNode.map.get(s.charAt(i++)),i)) {
			   i--;
			   currentNode.map.remove(s.charAt(i));
			   if(currentNode.map.size() > 0) {
				   return false;
			   }else {
				   return true;
			   }
		   }
	   }else {
		   return false;
	   }
	   
	  return false; 
   }
	
}
