package nl.sjoerdlangkemper.funcgrep;

import java.util.ArrayList;
import java.util.List;
import java.lang.Class;

public class Nodes extends ArrayList<Node> implements List<Node> {
    @Override public boolean add(Node node) {
        assert node != null;
        return super.add(node);
    }
}
