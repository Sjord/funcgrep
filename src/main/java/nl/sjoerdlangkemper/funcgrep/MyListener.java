package nl.sjoerdlangkemper.funcgrep;

import java.util.*;
import org.apache.commons.jxpath.JXPathContext;
import nl.sjoerdlangkemper.funcgrep.csharp.*;

public class MyListener extends CSharpParserBaseListener {
    private String xpath;

    MyListener(String xpath) {
        this.xpath = xpath;
    }

    private ClassNode currentClass;
    private List<String> attributes;
    private MethodNode currentMethod;

	@Override public void enterClass_definition(CSharpParser.Class_definitionContext ctx) { 
        String className = ctx.identifier().getText();
        this.currentClass = new ClassNode(className);
    }

    // Class member declaration. This thing holds both the attributes and the method declaration.
	@Override public void enterClass_member_declaration(CSharpParser.Class_member_declarationContext ctx) { 
        this.attributes = new ArrayList<String>();
    }


	@Override public void exitClass_member_declaration(CSharpParser.Class_member_declarationContext ctx) { 
        if (this.currentMethod != null) {
            this.currentMethod.attributes = this.attributes;
            this.attributes = null;
        }
    }

	@Override public void enterAttribute(CSharpParser.AttributeContext ctx) { 
        if (this.attributes != null) {
            String attrName = ctx.namespace_or_type_name().identifier().get(0).getText();
            this.attributes.add(attrName);
        }
    }

	@Override public void enterMethod_declaration(CSharpParser.Method_declarationContext ctx) { 
        String methodName = ctx.method_member_name().identifier().get(0).getText();
        MethodNode method = new MethodNode(methodName);
        this.currentMethod = method;
        this.currentClass.addMethod(method);
    }

	@Override public void exitClass_definition(CSharpParser.Class_definitionContext ctx) {
        Iterator results = JXPathContext.newContext(this.currentClass).iterate(this.xpath);
        while (results.hasNext()){
            System.out.println(results.next());
        }
    }   
}
