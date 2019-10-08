public class Node {
    char c;
    boolean isWordEnd;
    Node next[] = new Node[26];

    public Node(char ch, boolean b) {
        c = ch;
        isWordEnd = b;
    }


}