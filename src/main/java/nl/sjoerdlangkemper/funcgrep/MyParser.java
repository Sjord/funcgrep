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

        Visitor visitor = new Visitor();
        NodeList ast = visitor.visit(tree);

        String xpath = args[1];
        Iterator results = JXPathContext.newContext(ast).iterate(xpath);
        while (results.hasNext()){
            System.out.println(results.next());
        }
    }
}

