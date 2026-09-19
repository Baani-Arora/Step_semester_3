package oop.class_problems;

class GroupBookingReceipt extends BookingReceipt {

    private int groupSize;

    public GroupBookingReceipt(String bookingId,
                               String[] seatNumbers,
                               int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {

        return groupSize;
    }
}