package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class MethodNode extends Node {
    NodeList attributes;

    public MethodNode(String methodName) {
        super(methodName);
    }

    public NodeList getAttributes() {
        return this.attributes;
    }
}
