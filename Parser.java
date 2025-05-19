public class Parser {
    private byte[] input;
    private int current;

    public Parser(byte[] input) {
        this.input = input;
    }

    public void parse() {
        // será implementado depois
    }
    private char peek() {
        if (current < input.length)
            return (char) input[current];
        return '\0';
    }
}

