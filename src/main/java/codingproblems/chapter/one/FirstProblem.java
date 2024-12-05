package codingproblems.chapter.one;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstProblem {

    private static final String newLine = System.getProperty("line.separator");

    public static void main(String[] args) {
        printSqlCommandWithSimpleConcatenation();
        printJsonWithStringBuilder();
        printHtmlWithStringBuffer();
        printSqlCommandWithStringConcat();
        printJsonWithPrintWriter();
        printHtmlWithJoin();
        printSqlWithFormat();
        printJsonWithStringJoiner();
        printHtmlWithCollectorsJoining();
        printSqlUsingTextBlocks();
    }

    private static void printSqlCommandWithSimpleConcatenation() {
        // compiler transforms + into StringBuilder or Buffer internally
        String sqlCommand = "SELECT * FROM table" + newLine + " WHERE column = value" + newLine + " ORDER BY column" + null;
        System.out.println(sqlCommand);
    }

    private static void printJsonWithStringBuilder() {
        // non thread-safe
        String jsonResponse = new StringBuilder()
            .append("{")
            .append("\n  \"message\": \"This is a multi-line string.\"")
            .append("\n}\n")
            //.append(null) // NullPointerException
            .toString();

        System.out.println(jsonResponse);
    }

    private static void printHtmlWithStringBuffer() {
        // thread safe
        StringBuffer htmlPage = new StringBuffer();
        htmlPage.append("<html>").append(newLine);
        htmlPage.append("  <head>").append(newLine);
        htmlPage.append("    <title>Page Title</title>").append(newLine);
        htmlPage.append("  </head>").append(newLine);
        htmlPage.append("  <body>").append(newLine);
        htmlPage.append("    <h1>This is a multi-line string.</h1>").append(newLine);
        htmlPage.append("  </body>").append(newLine);
        htmlPage.append("</html>").append(newLine);
        //htmlPage.append(null); // NullPointerException

        System.out.println(htmlPage.toString());
    }

    private static void printSqlCommandWithStringConcat() {
        String sqlCommand = "SELECT * FROM table"
            .concat(newLine)
            .concat(" WHERE column = value")
            .concat(newLine)
            .concat(" ORDER BY column");
            //.concat(null); // NullPointerException
        System.out.println(sqlCommand);
    }

    private static void printHtmlWithJoin() {
        String htmlPage = String.join(newLine,
            newLine,
            null,
            "<html>",
            "  <head>",
            "    <title>Page Title</title>",
            "  </head>",
            "  <body>",
            "    <h1>This is a multi-line string.</h1>",
            "  </body>",
            "</html>"
        );

        System.out.println(htmlPage);
    }

    private static void printJsonWithPrintWriter() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        writer.println(newLine);
        writer.println("{");
        writer.println("  \"message\": \"This is a multi-line string using StringWriter.\"");
        writer.println("}");
        //writer.println(null);

        System.out.println(stringWriter.toString());
    }

    private static void printSqlWithFormat() {
        String sqlCommand = String.format("SELECT * FROM %s%n WHERE column = %s%n ORDER BY %s%n%s", "table", "value", "column", null);
        System.out.println(sqlCommand);
    }

    private static void printJsonWithStringJoiner() {
        StringJoiner json = new StringJoiner(newLine, "{", "}");
        json.add(newLine);
        json.add("  \"message\": \"This is a multi-line string using StringJoiner.\"");
        json.add("}");
        json.add(null);

        System.out.println(json.toString());
    }

    private static void printHtmlWithCollectorsJoining() {
        String htmlPage = Stream.of(
            "<html>",
            "  <head>",
            "    <title>Page Title</title>",
            "  </head>",
            "  <body>",
            "    <h1>This is a multi-line string.</h1>",
            "  </body>",
            "</html>"
        ).collect(Collectors.joining(newLine));
        System.out.println(htmlPage);
    }

    private static void printSqlUsingTextBlocks() {
        String sqlCommand = """
            SELECT * FROM table
             WHERE column = value
             ORDER BY column
            """;
        System.out.println(sqlCommand);
    }
}
