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

    private void match(char c) {
    if (c == peek()) {
        current++;
    } else {
        throw new Error("syntax error");
    }
}
}

