// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep9 {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersStep9() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            //noinspection removal
            list.add(new Integer(i));
        }
    }

    // IndexOutOfBoundsException is an unchecked exception; including it in the throws clause is not mandatory.
    public void writeList() throws IOException  {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
        out.close();
    }
}
