package string;

public class terenarySearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TerenarySearchTrie T = new TerenarySearchTrie();
		T.insert("abc");
		T.insert("abb");
		T.insert("dtf");
		
		System.out.println(T.search("dtf"));

	}

}
