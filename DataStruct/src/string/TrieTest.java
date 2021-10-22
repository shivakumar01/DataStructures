package string;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trie T = new Trie();
		
		T.insert("abc");
		T.insert("abb");
		T.insert("def");
		T.insert("shiva");
		
		T.delete("shiva");
		System.out.println(T.search("abc"));
		
		
	}

}
