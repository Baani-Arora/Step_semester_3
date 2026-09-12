public package oop.class_problems;

import java.util.Arrays;

public final class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {

        this.bookingId = bookingId;
        this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public String getBookingId() {

        return bookingId;
    }

    public String[] getSeatNumbers() {

        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {

        String[] copy = Arrays.copyOf(seatNumbers, seatNumbers.length);

        if (index >= 0 && index < copy.length)
            copy[index] = newSeat;

        return new BookingReceipt(bookingId, copy);
    }
} BookingReceipt {
    
}
