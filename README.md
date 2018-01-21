
Parse C# code and run XPath queries on the abstract syntax tree.

## Usage

Build with Maven:

    mvn package

This will create `target/funcgrep-0.1.0-SNAPSHOT-jar-with-dependencies.jar`. Run like this:

    java -cp target/funcgrep-0.1.0-SNAPSHOT-jar-with-dependencies.jar nl.sjoerdlangkemper.funcgrep.MyParser AccountController.cs "//methods[attributes='HttpPost']"

## Limitations

* Unicode BOMs will trigger the error "line 1:0 token recognition error at: ''".
* Preprocessor directives (e.g. `#region`) are currently not supported.
* Only one file at a time is supported.

## Model

The current model looks like this:

* class
    * name
    * methods
        * name
        * attributes

## Project structure

The Maven ANTLR plugin generates code for the grammars under [src/main/antlr4/nl/sjoerdlangkemper/funcgrep](src/main/antlr4/nl/sjoerdlangkemper/funcgrep). This code includes the CSharpLexer, CSharpParser and CSharpParserBaseListener. In MyParser the lexer and parser are used to create a parse tree, on which MyListener is called. MyListener creates a model and calls JXPath to print the matching nodes.
