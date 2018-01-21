
Parse C# code and run XPath queries on the abstract syntax tree.

## Usage

Build with Maven:

    mvn package

This will create `target/funcgrep-0.1.0-SNAPSHOT-jar-with-dependencies.jar`. Run like this:

    java -cp target/funcgrep-0.1.0-SNAPSHOT-jar-with-dependencies.jar nl.sjoerdlangkemper.funcgrep.MyParser AccountController.cs "//methods[attributes='HttpPost']"

## Limitations

* Unicode BOMs will trigger the error "line 1:0 token recognition error at: ''".
* Preprocessor directives (e.g. `#region`) are currently not supported.

## Model

The current model looks like this:

* class
    * name
    * methods
        * name
        * attributes
