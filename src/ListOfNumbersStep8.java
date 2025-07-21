// Source - https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Note: java.io classes used in this code will be covered later

public class ListOfNumbersStep8 {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbersStep8() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            //noinspection removal
            list.add(new Integer(i));
        }
    }

    // If you were providing the ListOfNumbers class as part of a package of classes, you probably couldn't anticipate the needs of all the users of your package.
    // In this case, it's better to not catch the exception and to allow a method further up the call stack to handle it.
    // If these are checked exceptions, the writeList method MUST specify that it can throw these exceptions.
    // The modified original writeList method to specify the exceptions it can throw instead of catching them:
    public void writeList() throws IOException, IndexOutOfBoundsException  {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
        out.close();
    }
}
