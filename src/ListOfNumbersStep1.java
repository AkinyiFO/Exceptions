//// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html
//
//// Note: This class will not compile yet.
//
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//// Note: java.io classes used in this code will be covered later
//
//public class ListOfNumbersStep1 {
//
//    private List<Integer> list;
//    private static final int SIZE = 10;
//
//    public ListOfNumbersStep1() {
//        list = new ArrayList<Integer>(SIZE);
//        for (int i = 0; i < SIZE; i++) {
//            //noinspection removal
//            list.add(new Integer(i));
//        }
//    }
//
//    public void writeList() {
//
//        // First step in creating an exception handler is to enclose it in a try block.
//        // try {
//        //   one or more legal lines of code that could throw an exception
//        // }
//        // catch and finally blocks - Explained in next steps
//
//        // You can put each line of code that might throw an exception within its own try block with separate exception handlers each
//        // Or, you can put all the method code within a single try block if it is short and associate multiple handlers
//
//        PrintWriter out = null;
//
//        // If an exception occurs within the try block, that exception is handled by an exception handler associated with it.
//        try {
//            System.out.println("Entered try statement");
//            FileWriter f = new FileWriter("OutFile.txt");
//            out = new PrintWriter(f); // IOException
//            for (int i = 0; i < SIZE; i++) {
//                out.println("Value at: " + i + " = " + list.get(i)); // IndexOutOfBoundsException
//            }
//        } // catch and finally blocks - Explained in next steps
//        out.close();
//    }
//}