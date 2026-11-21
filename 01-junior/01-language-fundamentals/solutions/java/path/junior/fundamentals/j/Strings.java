package path.junior.fundamentals.j;

public final class Strings {
    private Strings() {}

    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input");
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input");
        }
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        int i = 0;
        int j = cleaned.length() - 1;
        while (i < j) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int wordCount(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input");
        }
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
