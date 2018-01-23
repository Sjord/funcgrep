package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class MethodNode {
    String name;
    List<String> attributes;

    public MethodNode(String methodName) {
        this.name = methodName;
        this.attributes = new ArrayList<String>();
    }

    public String toString() {
        return this.name;
    }
    
    public List<String> getAttributes() {
        return this.attributes;
    }
}
