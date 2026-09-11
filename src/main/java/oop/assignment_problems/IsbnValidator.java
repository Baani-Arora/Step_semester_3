package oop.assignment_problems;

class IsbnValidator {

    static String normalizeCode(String raw) {

        raw = raw.trim();

        if (raw.length() >= 3) {
            raw = raw.substring(0, 3).toUpperCase() + raw.substring(3);
        }

        return raw;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(pub)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        String code = normalizeCode(" pen2026004251 ");

        System.out.println(validateAndFormat(code));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
