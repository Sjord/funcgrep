package nl.sjoerdlangkemper.funcgrep;

import java.io.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite; 
import nl.sjoerdlangkemper.funcgrep.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public class MyParserTest extends TestCase
{
    public MyParserTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(MyParserTest.class);
    }

    public void testParseOneClass() throws IOException
    {
        InputStream input = this.getClass().getResourceAsStream("AccountController.cs");
        CharStream stream = CharStreams.fromStream(input);
        NodeList ast = MyParser.parse_code(stream);

        assert ast.one() instanceof ClassNode;
    }
}
