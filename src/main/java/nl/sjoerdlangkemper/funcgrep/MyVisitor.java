package nl.sjoerdlangkemper.funcgrep;

import nl.sjoerdlangkemper.funcgrep.csharp.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyVisitor extends CSharpParserBaseVisitor<Nodes> {
	@Override public Nodes visitClass_definition(CSharpParser.Class_definitionContext ctx) { 
        String className = ctx.identifier().getText();
        System.out.println(className);
        return visitChildren(ctx); 
    }

    // Class member declaration. This thing holds both the attributes and the method declaration.
	@Override public Nodes visitClass_member_declaration(CSharpParser.Class_member_declarationContext ctx) { 
    
        ParseTree attrs = ctx.attributes();
        if (attrs!=null) {
            Object res= visit(ctx.attributes());
            System.out.println("Res: " + res);
        }
        return visitChildren(ctx);


/*
        Object declaration = visit(ctx.common_member_declaration());
        if (declaration instanceof MethodNode) {
            System.out.println("Found method: "+declaration);
        }

        ParseTree attributes = ctx.attributes();
        if (attributes != null) {
            System.out.println("===============");
            Object result = visit(attributes);
            System.out.println("Res: " + result);
            System.out.println("^^^^^^^^^^^^^^^");
        }
        return declaration;
        */
    }

	@Override public Nodes visitAttribute(CSharpParser.AttributeContext ctx) { 
        String attrName = ctx.namespace_or_type_name().identifier().get(0).getText();
        System.out.println("Attr: " + attrName);
        return new AttributeNode(attrName).toNodes();
    }

	@Override public Nodes visitMethod_declaration(CSharpParser.Method_declarationContext ctx) { 
        String methodName = ctx.method_member_name().identifier().get(0).getText();
        System.out.println("method: "+methodName);
        MethodNode method = new MethodNode(methodName);
        return method.toNodes();
    }

    @Override protected Nodes aggregateResult(Nodes aggregate, Nodes nextResult) {
        if (aggregate == null) {
            return nextResult;
        }
        if (nextResult == null) {
            return aggregate;
        }
        aggregate.addAll(nextResult);
        return aggregate;
    }
}
