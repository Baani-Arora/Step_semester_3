package oop.assignment_problems;

import java.util.Arrays;

public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {

        String[] copy = Arrays.copyOf(bookIds, bookIds.length);

        if (index >= 0 && index < copy.length) {
            copy[index] = newId;
        }

        return new LoanReceipt(memberId, copy);
    }
}