package nl.sjoerdlangkemper.funcgrep;

public class RootNode extends Node {
    private NodeList files;

    public RootNode() {
        super("root");
        this.files = new NodeList();
    }

    public void add(FileNode file) {
        this.files.add(file);
    }

    public NodeList getFiles() {
        return files;
    }
}
