package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class ClassNode extends NamedNode {
    private List<MethodNode> methods;

    ClassNode(String className) {
        super(className);
        this.methods = new ArrayList<MethodNode>();
    }

    public List<MethodNode> getMethods() {
        return this.methods;
    }

    public void addMethod(MethodNode method) {
        this.methods.add(method);
    }
}
