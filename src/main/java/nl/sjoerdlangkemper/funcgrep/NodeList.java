package nl.sjoerdlangkemper.funcgrep;

import java.util.ArrayList;

public class NodeList extends ArrayList<Node> {
    public Node one() {
        if (size() != 1) {
            throw new IndexOutOfBoundsException();
        }
        return get(0);
    }

    public NodeList getType(Class nodeType) {
        NodeList result = new NodeList();
        for (Node node : this) {
            if (nodeType.isInstance(node)) {
                result.add(node);
            }
        }
        return result;
    }
}
