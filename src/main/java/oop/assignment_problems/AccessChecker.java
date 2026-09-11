package oop.assignment_problems;

import java.util.LinkedHashMap;

class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        switch (fieldModifier) {

            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

            case "default":
                return (accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE"))
                        ? "ALLOWED" : "DENIED";

            case "protected":

                switch (accessorContext) {

                    case "SAME_CLASS":
                    case "SAME_PACKAGE":
                    case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                        return "ALLOWED";

                    default:
                        return "DENIED";
                }

            case "public":
                return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {"private", "default", "protected", "public"};

        LinkedHashMap<String, int[]> map = new LinkedHashMap<>();

        for (String m : modifiers)
            map.put(m, new int[2]);

        for (String[] attempt : attempts) {

            String result = classifyAccess(attempt[0], attempt[1]);

            if (result.equals("ALLOWED"))
                map.get(attempt[0])[0]++;
            else
                map.get(attempt[0])[1]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < modifiers.length; i++) {

            String m = modifiers[i];
            int[] c = map.get(m);

            sb.append(m)
                    .append(": ")
                    .append(c[0])
                    .append(" allowed / ")
                    .append(c[1])
                    .append(" denied");

            if (i != modifiers.length - 1)
                sb.append(" | ");
        }

        return sb.toString();
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            if (classifyAccess(attempts[i][0], attempts[i][1]).equals("DENIED")) {

                return attempts[i][0] + " via " + attempts[i][1]
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {

        System.out.println(classifyAccess("private", "SAME_CLASS"));

        String[][] sample = {
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeByModifier(sample));

        String[][] sample2 = {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(firstDeniedAttempt(sample2));
    }
}