package nl.sjoerdlangkemper.funcgrep;

public abstract class Node {
    protected String name;

    protected Node(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public NodeList toList() {
        NodeList result = new NodeList();
        result.add(this);
        return result;
    }
}
