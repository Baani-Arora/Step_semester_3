package oop.assignment_problems;

class CirculationLedger {

    static String branchCode;

    static {
        branchCode = "SRM-CENTRAL";
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {

        int processed = 0;
        int skipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                skipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + skipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }

    public static void main(String[] args) {

        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        1),
                null,
                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"})
        };

        System.out.println(processNightlyCirculation(receipts));
    }
}