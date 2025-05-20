import java.util.HashMap;
import java.util.Map;

public class Scanner {

    private byte[] input;
    private int current; 

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("let", TokenType.LET);
    }

    public Scanner(byte[] input) {
        this.input = input;
    }

    private char peek() {
        if (current < input.length)
            return (char) input[current];
        return '\0';
    }

    private void advance() {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    private Token number() {
        int start = current;
        while (Character.isDigit(peek())) {
            advance();
        }
        String n = new String(input, start, current - start);
        return new Token(TokenType.NUMBER, n);
    }

    private void skipWhitespace() {
    char ch = peek();
    while (ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n') {
        advance();
        ch = peek();
    }
    }

    private boolean isAlphaNumeric(char ch) {
    return Character.isLetterOrDigit(ch);
    }

    private Token identifier() {
    int start = current;
    while (isAlphaNumeric(peek())) advance();

    String id = new String(input, start, current - start);
    TokenType type = keywords.get(id);
    if (type == null) type = TokenType.IDENT;
    return new Token(type, id);
    }

public Token nextToken() {
    skipWhitespace();

    char ch = peek();

    if (ch == '\0') {
        return new Token(TokenType.EOF, "EOF");
    }

    if (Character.isLetter(ch)) {
        return identifier();
    }

    if (Character.isDigit(ch)) {
        return number();
    }

    switch (ch) {
        case '+':
            advance();
            return new Token(TokenType.PLUS, "+");
        case '-':
            advance();
            return new Token(TokenType.MINUS, "-");
        case '=':
            advance();
            return new Token(TokenType.EQ, "=");
        case ';':
            advance();
            return new Token(TokenType.SEMICOLON, ";");
        default:
            throw new Error("lexical error at " + ch);
    }
}

    public static void main(String[] args) {
        String input = "289-85+0+69";
        Scanner scan = new Scanner(input.getBytes());
        System.out.println(scan.nextToken());
        System.out.println(scan.nextToken());
        System.out.println(scan.nextToken());
        System.out.println(scan.nextToken());
        System.out.println(scan.nextToken());
        System.out.println(scan.nextToken());
        System.out.println(scan.nextToken());
    }
}
