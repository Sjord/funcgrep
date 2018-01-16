import java.util.*;

public class MyMethod {
    String name;
    List<String> attributes;

    public MyMethod(String methodName) {
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
