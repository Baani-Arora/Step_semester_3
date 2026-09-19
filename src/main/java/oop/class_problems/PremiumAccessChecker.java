package oop.class_problems;

class PremiumAccessChecker extends AccessChecker {

    static String classifyAccess(String modifier,
                                 String context) {

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (modifier.equals("protected")
                    || modifier.equals("public"))
                return "ALLOWED";

            return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (modifier.equals("public"))
                return "ALLOWED";

            return "DENIED";
        }

        return AccessChecker.classifyAccess(modifier, context);
    }
}