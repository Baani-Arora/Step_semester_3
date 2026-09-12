package oop.class_problems;

class MovieTicket {

    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}

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
                return (accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE"))
                        ? "ALLOWED" : "DENIED";

            case "public":
                return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {

            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {

        System.out.println(classifyAccess("private", "SAME_CLASS"));

        String[][] sample = {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(sample));
    }
}