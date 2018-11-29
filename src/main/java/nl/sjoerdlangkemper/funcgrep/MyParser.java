package nl.sjoerdlangkemper.funcgrep;

import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.xpath.*;
import nl.sjoerdlangkemper.funcgrep.csharp.*;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.BOMInputStream;

public class MyParser {
    private MyParser() {
    }

    public static void main(String[] args) throws IOException {
        RootNode tree = new RootNode();
        for (int i = 1; i < args.length; i++) {
            String filename = args[i];
            CharStream input = openFile(filename);
            NodeList ast = parse_code(input);
            tree.add(new FileNode(filename, ast));
        }

        String xpath = args[0];
        Iterator results = JXPathContext.newContext(tree).iterate(xpath);
        while (results.hasNext()){
            System.out.println(results.next());
        }
    }

    public static CharStream openFile(String filename) throws IOException {
        InputStream stream = FileUtils.openInputStream(new File(filename));
        InputStream bomless = new BOMInputStream(stream);
        return CharStreams.fromStream(bomless);
    }

    public static NodeList parse_code(CharStream input) {
        Lexer lexer = new CSharpLexer(input);
        TokenStream stream = new CommonTokenStream(lexer);
        CSharpParser parser = new CSharpParser(stream);
        ParseTree tree = parser.compilation_unit();

        Visitor visitor = new Visitor();
        NodeList ast = visitor.visit(tree);
        return ast;
    }
}

