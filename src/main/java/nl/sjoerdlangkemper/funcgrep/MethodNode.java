package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class MethodNode extends NamedNode {
    List<String> attributes;

    public MethodNode(String methodName) {
        super(methodName);
        this.attributes = new ArrayList<String>();
    }

    public List<String> getAttributes() {
        return this.attributes;
    }
}
