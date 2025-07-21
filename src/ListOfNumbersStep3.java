// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep3 {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersStep3() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            //noinspection removal
            list.add(new Integer(i));
        }
    }

    public void writeList() {

        PrintWriter out = null;

        // Catching More Than One Type of Exception with One Exception Handler
        // If a catch block handles more than one exception type, then the catch parameter is implicitly final
        try {
            System.out.println("Entered try statement");
            FileWriter f = new FileWriter("OutFile.txt");
            out = new PrintWriter(f); // IOException
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i)); // IndexOutOfBoundsException
            }
        } catch (IndexOutOfBoundsException | IOException e) { // e is  implicitly final (cannot be reassigned withing the catch block)
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
            System.err.println("Caught IOException: " + e.getMessage());
        }  // finally blocks - Explained in next steps
        out.close();
    }

    public static void main(String[] args) {
        ListOfNumbersStep2 listOfNumbersStep2 = new ListOfNumbersStep2();
        listOfNumbersStep2.writeList();
    }
}
