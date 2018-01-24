package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class MethodNode extends Node {
    Nodes attributes;

    public MethodNode(String methodName) {
        super(methodName);
    }

    public Nodes getAttributes() {
        return this.attributes;
    }
}
