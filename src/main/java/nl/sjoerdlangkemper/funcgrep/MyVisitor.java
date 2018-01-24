package nl.sjoerdlangkemper.funcgrep;

import nl.sjoerdlangkemper.funcgrep.csharp.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyVisitor extends CSharpParserBaseVisitor<Nodes> {
	@Override public Nodes visitClass_definition(CSharpParser.Class_definitionContext ctx) { 
        String className = ctx.identifier().getText();
        ClassNode classNode = new ClassNode(className);
        classNode.methods = visitChildren(ctx); 
        return classNode.toNodes();
    }

    // Class member declaration. This thing holds both the attributes and the method declaration.
	@Override public Nodes visitClass_member_declaration(CSharpParser.Class_member_declarationContext ctx) { 
        Nodes declaration = visit(ctx.common_member_declaration());
    
        ParseTree attrs = ctx.attributes();
        if (attrs != null && declaration != null) {
            ((MethodNode)declaration.get(0)).attributes = visit(ctx.attributes());
        }

        return declaration;
    }

	@Override public Nodes visitAttribute(CSharpParser.AttributeContext ctx) { 
        String attrName = ctx.namespace_or_type_name().identifier().get(0).getText();
        assert attrName != null;
        return new AttributeNode(attrName).toNodes();
    }

	@Override public Nodes visitMethod_declaration(CSharpParser.Method_declarationContext ctx) { 
        String methodName = ctx.method_member_name().identifier().get(0).getText();
        assert methodName != null;
        return new MethodNode(methodName).toNodes();
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
