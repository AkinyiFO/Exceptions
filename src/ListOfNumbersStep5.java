// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep5 {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersStep5() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            //noinspection removal
            list.add(new Integer(i));
        }
    }

    public void writeList() throws IOException { // throws IOException added in the method instead of a catch block

        // A try statement that declares one or more resources is try-with-resources statement
        // A resource is an object that must be closed after the program is finished with it
        // It ensures that each resource is closed at the end of the statement
        // Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource
        try (FileWriter f = new FileWriter("OutFile.txt"); PrintWriter out = new PrintWriter(f)) {
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i)); // IndexOutOfBoundsException
            }
        }

//        PrintWriter out = null;
//        FileWriter f = null;
//
//        try { // Use a try-with-resources statement, when closing a file or recovering resource
//            System.out.println("Entered try statement");
//            f = new FileWriter("OutFile.txt");
//            out = new PrintWriter(f); // IOException
//            for (int i = 0; i < SIZE; i++) {
//                out.println("Value at: " + i + " = " + list.get(i)); // IndexOutOfBoundsException
//            }
//        } catch (IndexOutOfBoundsException | IOException e) { // e is  implicitly final (cannot be reassigned withing the catch block)
//            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
//            System.err.println("Caught IOException: " + e.getMessage());
//        } finally {
//            if (out != null) {
//                System.out.println("Closing PrintWriter");
//                out.close();
//            } else {
//                System.out.println("PrintWriter not open");
//            }
//            if (f != null) {
//                System.out.println("Closing FileWriter");
//                f.close();
//            }
//        }
    }
    public static void main(String[] args) {
        ListOfNumbersStep2 listOfNumbersStep2 = new ListOfNumbersStep2();
        listOfNumbersStep2.writeList();
    }
}
