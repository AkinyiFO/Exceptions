// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep2 {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersStep2() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            //noinspection removal
            list.add(new Integer(i));
        }
    }

    public void writeList() {

        // Second step in creating an exception handler is to associate a try block with catch block(s).
        // try {
        //   one or more legal lines of code that could throw an exception
        // } catch (ExceptionType name) {
        //   code that is executed if and when the exception handler is invoked
        // } catch (ExceptionType name) {
        //   code that is executed if and when the exception handler is invoked
        // }

        PrintWriter out = null;

        // If an exception occurs within the try block, that exception is handled by an exception handler associated with it via catch blocks
        // Each catch block is an exception handler that handles the type of exception indicated by its argument,
        //      which MUST be the name of a class that inherits from the Java's Throwable class
        // A match occurs if the thrown object can legally be assigned to an argument
        try {
            System.out.println("Entered try statement");
            FileWriter f = new FileWriter("OutFile.txt");
            out = new PrintWriter(f); // IOException
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i)); // IndexOutOfBoundsException
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }  // finally blocks - Explained in next steps
        out.close();
    }

    public static void main(String[] args) {
        ListOfNumbersStep2 listOfNumbersStep2 = new ListOfNumbersStep2();
        listOfNumbersStep2.writeList();
    }
}
