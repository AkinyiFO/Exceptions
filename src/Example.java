public class Example {

    void methodExample(){
        int demo = 6;
        System.out.println("Seen when methodExample() is called: " + demo);
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.methodExample(); // Method call
    }
}
