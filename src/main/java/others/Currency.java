package others;

public class Currency {
    private static final char DOT = 46;
    private static final char COMMA = 44;
    private static final char FIVE = 53;

    /*
     * This solution is not correct.
     */
    public String printCurrency(String input) {
        int dot = input.indexOf(DOT);
        if (dot == -1) {
            dot = input.length();
        }

        // The string builder used to build the result.
        StringBuilder builder = new StringBuilder();

        // First makes sure we could separate the integer part using comma.
        for (int i = 0; i < dot % 3; i++) {
            builder.append(input.charAt(i));
        }
        if (dot % 3 != 0) {
            builder.append(COMMA);
        }

        for (int i = dot % 3; i < dot; i++) {
            builder.append(input.charAt(i));
            if (i % 3 == dot % 3 && i != dot % 3) {
                builder.append(COMMA);
            }
        }

        // Appends the dot.
        if (dot == input.length()) {
            return builder.toString();
        }
        builder.append(DOT);

        // Deals with the fractional part.
        if (dot + 1 < input.length()) {
            char first = input.charAt(dot + 1);

            if (dot + 2 < input.length()) {
                int second = Character.getNumericValue(input.charAt(dot + 2));
                if (dot + 3 < input.length()) {
                    second += (input.charAt(dot + 3) >= FIVE ? 1 : 0);
                }
                if (second == 10) {
                    builder.append((char) (first + 1));
                } else {
                    builder.append(first);
                }
                builder.append(Integer.toString(second % 10));
            } else {
                builder.append(first);
            }
        }

        return builder.toString();
    }
}
