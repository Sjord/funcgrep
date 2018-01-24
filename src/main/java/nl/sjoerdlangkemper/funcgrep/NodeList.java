package nl.sjoerdlangkemper.funcgrep;

import java.util.ArrayList;

public class NodeList extends ArrayList<Node> {
    public Node one() {
        if (size() != 1) {
            throw new IndexOutOfBoundsException();
        }
        return get(0);
    }
}
