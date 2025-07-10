//// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html
//
//// Note: This class will not compile yet.
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//// Note: java.io classes used in this code will be covered later
//
//public class ListOfNumbersStep4 {
//
//    private List<Integer> list;
//    private static final int SIZE = 10;
//
//    public ListOfNumbersStep4() {
//        list = new ArrayList<Integer>(SIZE);
//        for (int i = 0; i < SIZE; i++) {
//            //noinspection removal
//            list.add(new Integer(i));
//        }
//    }
//
//    public void writeList()  {
//
//        PrintWriter out = null;
//        FileWriter f = null;
//
//        // The finally block ALWAYS executes when the try block exits
//        // Besides exception handling — it allows the programmer to avoid having cleanup code accidentally bypassed by
//        //      branching statements (return, continue, or break)
//        try {
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
//            // finally blocks - Explained in next steps
//            // As best practice,put cleanup code in a finally block, even when no exceptions are anticipated
//            // Because the code above may exit without closing when:
//            // 1. The new FileWriter statement fails and throws an IOException.
//            // 2. The list.get(i) statement fails and throws an IndexOutOfBoundsException.
//            // 3. Everything succeeds and the try block exits normally.
//            if (out != null) {
//                System.out.println("Closing PrintWriter");
//                out.close();
//            } else {
//                System.out.println("PrintWriter not open");
//            }
//
//            if (f != null) {
//                System.out.println("Closing FileWriter");
//                f.close(); // Use a try-with-resources statement (Covered in the next steps) instead, when closing a file,
//                           // or recovering resource to avoid resource leak
//                // A resource is an object that must be closed after the program is finished with it
//            }
//        }
//    }
//}