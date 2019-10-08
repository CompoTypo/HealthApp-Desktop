import java.util.ArrayList;

public class Trie {
    private Node root = new Node('/', false);

    public Trie() {}

    public Node getRoot() {
        return root;
    }

    public void insertEntry(String w) {
        Node cur = root;
        for (int i = 0; i < w.length(); i++) {

            // System.out.println(w.charAt(i) - 97 + " " + w.charAt(i)); 

            boolean tempB;
            if (i != w.length() - 1) tempB = false; 
            else tempB = true;

            if (cur.next[w.charAt(i) - 97] == null) 
                cur.next[w.charAt(i) - 97] = new Node(w.charAt(i), tempB);

            cur = cur.next[w.charAt(i) - 97];
        }
    }

    public ArrayList<String> searchTrie(String s) {
        Node cur = root;
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            if (cur.next[s.charAt(i) - 97] != null && cur.next[s.charAt(i) - 97].c == s.charAt(i))
                cur = cur.next[s.charAt(i) - 97];
        }
        Utility u = new Utility();
        return u.DFS(cur, s, resultList);
    }
} 