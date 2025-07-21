// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep6 {

    // They will be closed regardless of whether the try statement completes normally or abruptly (as a result of the method BufferedReader.readLine throwing an IOException)
    //  Example 2 of the try-with-resources Statement
    //  if exceptions are thrown from both the try block and the try-with-resources statement,
    //  then the method readFirstLineFromFile throws the exception thrown from the try block;
    //  the exception thrown from the try-with-resources block is suppressed
    //  You can retrieve suppressed exceptions Java 7+ by calling the Throwable.getSuppressed method from the exception thrown by the try block
    static String readFirstLineFromFile(String path) throws IOException {
        try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        }
    }

    // A program MUST release a resource back to the operating system by calling the resource's close method
    // If a program fails to do this before the Garbage Collector reclaims the resource, information needed to release the resource is lost
    // resource, which is still considered by the operating system to be in use, is hereby LEAKED
    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        try {
            return br.readLine();
        } finally {
            br.close(); // If method readLine() and close() throws an exception,
                        // then readFirstLineFromFileWithFinallyBlock throws the exception thrown from the finally block;
                        // the exception thrown from the try block is suppressed.the FileReader has leaked
                        // You can retrieve suppressed exceptions Java 7+ by calling the Throwable.getSuppressed method from the exception thrown by the try block
            fr.close();
        }
    }

    // Example 3 of the try-with-resources Statement
    // Retrieves the names of the files packaged in the zip file
    static void writeToFileZipFileContents(String zipFileName, String outputFileName) throws java.io.IOException {

        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement
        try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
             java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((java.util.zip.ZipEntry)entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    // A try-with-resources statement can have catch and finally blocks
    // They run after the resources declared have been closed
    static void viewTable(Connection con) throws SQLException {

        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName + ", " + supplierID + ", " +
                        price + ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
           // To be covered later - JDBCTutorialUtilities.printSQLException(e);
        }
    }
    public static void main(String[] args) throws IOException {
//        Connection connection;
//        readFirstLineFromFile("some file path");
//        readFirstLineFromFileWithFinallyBlock("some file path");
//        writeToFileZipFileContents("someZipFileName", "someOutputFile");
//        viewTable(connection);
    }
}
