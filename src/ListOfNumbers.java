//// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html
//
//// Note: This class will not compile yet.
//import java.io.*;
//import java.util.List;
//import java.util.ArrayList;
//
//// Note: java.io classes used in this code will be covered later
//
//public class ListOfNumbers {
//
//    private List<Integer> list;
//    private static final int SIZE = 10;
//
//    public ListOfNumbers () {
//        list = new ArrayList<Integer>(SIZE);
//        for (int i = 0; i < SIZE; i++) {
//            //noinspection removal
//            list.add(new Integer(i));
//        }
//    }
//
//    public void writeList() {
//        // Call to the FileWriter constructor
//        // This constructor throws IOException if the file cannot be opened
//        // The IOException is a checked exception (MUST honor Catch or Specified required), hence it must be caught
//        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
//
//        for (int i = 0; i < SIZE; i++) {
//            // The get(int) is a call to the ArrayList class's get method
//            // That method throws an IndexOutOfBoundsException if the value of its argument is too small (less than 0)
//            // or too large (more than the number of elements currently contained by the ArrayList)
//            // The IndexOutOfBoundsException, is an unchecked RuntimeException (honoring Catch or Specified is NOT a must)
//            out.println("Value at: " + i + " = " + list.get(i));
//        }
//        out.close();
//    }
//}