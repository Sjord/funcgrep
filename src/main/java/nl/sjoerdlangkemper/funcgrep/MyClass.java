package nl.sjoerdlangkemper.funcgrep;
import java.util.*;

public class MyClass {
    private String name;
    private List<MyMethod> methods;

    MyClass(String className) {
        this.name = className;
        this.methods = new ArrayList<MyMethod>();
    }

    public String toString() {
        return this.name;
    }

    public List<MyMethod> getMethods() {
        return this.methods;
    }

    public void addMethod(MyMethod method) {
        this.methods.add(method);
    }
}
