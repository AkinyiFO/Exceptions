// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep7 {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersStep7() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            //noinspection removal
            list.add(new Integer(i));
        }
    }

    // 1. If code in the try statement fails and throws an exception.

    // 2. Everything succeeds and the try statement exits normally.
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering" + " try statement");

            out = new PrintWriter(new FileWriter("OutFile.txt")); // 1. The FileWriter throws an IOException if the program cannot create or write to the file indicated
            for (int i = 0; i < SIZE; i++) {
                out.println("Value at: " + i + " = " + list.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: "
                    +  e.getMessage());

        } catch (IOException e) { // 1. Runtime system search from: FileWriter Constructor > writeList() > IndexOutOfBoundsException > IOException
            System.err.println("Caught IOException: " +  e.getMessage());

        } finally { // 1. In this scenario, the FileWriter was never opened and doesn't need to be closed.
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            }
            else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public static void main(String[] args) {
        ListOfNumbersStep7 listOfNumbersStep7 = new ListOfNumbersStep7();
        listOfNumbersStep7.writeList();
    }
}
