import java.util.ArrayList;

public class Utility {

    public ArrayList<String> DFS(Node c, String s, ArrayList<String> sArr) {
        for (Node n : c.next) {
            if (n != null) {
                if (n.isWordEnd)
                    sArr.add(s  + n.c);
                
                sArr = DFS(n, s + n.c, sArr);
            }
        }
        return sArr;
    }
}