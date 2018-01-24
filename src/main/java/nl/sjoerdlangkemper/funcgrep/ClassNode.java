package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class ClassNode extends NamedNode {
    NodeList methods;

    ClassNode(String className) {
        super(className);
    }

    public NodeList getMethods() {
        return this.methods;
    }
}
