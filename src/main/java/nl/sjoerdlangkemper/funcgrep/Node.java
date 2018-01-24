package nl.sjoerdlangkemper.funcgrep;

public abstract class Node {
    protected String name;

    public Node(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public Nodes toNodes() {
        Nodes nodes = new Nodes();
        nodes.add(this);
        return nodes;
    }
}
