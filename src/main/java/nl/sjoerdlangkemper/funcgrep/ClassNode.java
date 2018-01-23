package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class ClassNode {
    private String name;
    private List<MethodNode> methods;

    ClassNode(String className) {
        this.name = className;
        this.methods = new ArrayList<MethodNode>();
    }

    public String toString() {
        return this.name;
    }

    public List<MethodNode> getMethods() {
        return this.methods;
    }

    public void addMethod(MethodNode method) {
        this.methods.add(method);
    }
}
