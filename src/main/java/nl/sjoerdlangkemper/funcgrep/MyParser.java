package nl.sjoerdlangkemper.funcgrep;

import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.xpath.*;
import nl.sjoerdlangkemper.funcgrep.csharp.*;
import org.apache.commons.jxpath.JXPathContext;

public class MyParser {
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName(args[0]);
        Lexer lexer = new CSharpLexer(input);
        TokenStream stream = new CommonTokenStream(lexer);
        CSharpParser parser = new CSharpParser(stream);
        ParseTree tree = parser.compilation_unit();

        MyVisitor visitor = new MyVisitor();
        Nodes ast = visitor.visit(tree);
        System.out.println("ast: " + ast);
        System.out.println("ast0: " + ast.get(0));

        String xpath = args[1];
        System.out.println("Results for " + xpath);
        Iterator results = JXPathContext.newContext(ast).iterate(xpath);
        while (results.hasNext()){
            System.out.println("result:" + results.next());
        }
    }
}

