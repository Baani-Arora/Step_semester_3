package oop.assignment_problems;

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final int referenceCount;

    public ReferenceOnlyLoanReceipt(String memberId,
                                    String[] bookIds,
                                    int referenceCount) {

        super(memberId, bookIds);
        this.referenceCount = referenceCount;
    }

    public int getReferenceCount() {
        return referenceCount;
    }
}