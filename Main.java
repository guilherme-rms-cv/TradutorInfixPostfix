public class Main {
    public static void main(String[] args) throws Exception {
        // String input = "8+5-7+9";
        String input = "8+5*2-4/2";
        Parser p = new Parser(input.getBytes());
        p.parse();
    }
}