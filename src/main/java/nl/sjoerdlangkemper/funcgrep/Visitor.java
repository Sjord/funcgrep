package nl.sjoerdlangkemper.funcgrep;

import nl.sjoerdlangkemper.funcgrep.csharp.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class Visitor extends CSharpParserBaseVisitor<NodeList> {
	@Override public NodeList visitClass_definition(CSharpParser.Class_definitionContext ctx) { 
        String className = ctx.identifier().getText();
        ClassNode classNode = new ClassNode(className);
        classNode.methods = visitChildren(ctx); 
        return classNode.toList();
    }

    // Class member declaration. This thing holds both the attributes and the method declaration.
	@Override public NodeList visitClass_member_declaration(CSharpParser.Class_member_declarationContext ctx) { 
        NodeList declaration = visit(ctx.common_member_declaration());
    
        ParseTree attrs = ctx.attributes();
        if (attrs != null && declaration != null) {
            ((MethodNode)declaration.one()).attributes = visit(attrs);
        }

        return declaration;
    }

	@Override public NodeList visitAttribute(CSharpParser.AttributeContext ctx) { 
        String attrName = ctx.namespace_or_type_name().identifier().get(0).getText();
        return new AttributeNode(attrName).toList();
    }

	@Override public NodeList visitMethod_declaration(CSharpParser.Method_declarationContext ctx) { 
        String methodName = ctx.method_member_name().identifier().get(0).getText();
        return new MethodNode(methodName).toList();
    }

    @Override protected NodeList aggregateResult(NodeList aggregate, NodeList nextResult) {
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
