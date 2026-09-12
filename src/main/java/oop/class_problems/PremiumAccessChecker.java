package oop.class_problems;

class PremiumAccessChecker {

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

                    case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                    case "DIFFERENT_PACKAGE":
                        return "DENIED";
                }

            case "public":
                return "ALLOWED";
        }

        return "DENIED";
    }

    public static void main(String[] args) {

        System.out.println(
                classifyAccess("protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println(
                classifyAccess("protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}