
import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.xpath.*;

public class MyParser {
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName(args[0]);
        Lexer lexer = new CSharpLexer(input);
        TokenStream stream = new CommonTokenStream(lexer);
        CSharpParser parser = new CSharpParser(stream);
        ParseTree tree = parser.compilation_unit();
        MyListener listener = new MyListener(args[1]);
        ParseTreeWalker.DEFAULT.walk(listener, tree);

/*
        String xpath = "//class_member_declaration";
        Collection<ParseTree> matches = XPath.findAll(tree, xpath, parser);
        System.out.println(matches);
*/
    }
}

