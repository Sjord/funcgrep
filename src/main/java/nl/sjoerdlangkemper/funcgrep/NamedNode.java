package nl.sjoerdlangkemper.funcgrep;

public abstract class NamedNode {
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
}
