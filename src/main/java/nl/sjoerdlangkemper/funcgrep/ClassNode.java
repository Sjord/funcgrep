package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class ClassNode extends Node {
    Nodes methods;

    ClassNode(String className) {
        super(className);
    }

    public Nodes getMethods() {
        return this.methods;
    }
}
