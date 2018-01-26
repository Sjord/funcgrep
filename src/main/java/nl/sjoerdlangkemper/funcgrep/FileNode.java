package nl.sjoerdlangkemper.funcgrep;

public class FileNode extends Node {
    private NodeList tree;

    public FileNode(String filename, NodeList subtree) {
        super(filename);
        this.tree = subtree;
    }

    public NodeList getClasses() {
        // There are currently possible other things in here than classes, but we'll ignore that for now.
        return tree;
    }
}
