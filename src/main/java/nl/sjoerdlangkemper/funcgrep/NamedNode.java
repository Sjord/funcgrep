package nl.sjoerdlangkemper.funcgrep;

public abstract class NamedNode implements Node {
    protected String name;

    protected NamedNode(String name) {
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
