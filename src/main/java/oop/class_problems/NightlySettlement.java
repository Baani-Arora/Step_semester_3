package oop.class_problems;

class NightlySettlement {

    static String processNightlySettlement(BookingReceipt[] receipts) {

        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {

                skipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt)
                group++;
            else
                individual++;
        }

        return processed + " processed | "
                + skipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt[] receipts = {

                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2),

                null,

                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"})
        };

        System.out.println(processNightlySettlement(receipts));
    }
}