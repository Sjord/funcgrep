package nl.sjoerdlangkemper.funcgrep;

import java.util.ArrayList;
import java.util.List;
import java.lang.Class;

public class Nodes extends ArrayList<Node> {
    @Override public boolean add(Node node) {
        assert node != null;
        return super.add(node);
    }

    public Node one() {
        if (size() != 1) {
            throw new IndexOutOfBoundsException();
        }
        return get(0);
    }
}
