package oop.class_problems;

class FeePayment {

    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }

    static void processPayment(FeePayment account, double amount) {

        if (account instanceof HostelFeeAccount) {
            ((HostelFeeAccount) account).payInInstallments(amount);
        } else {
            account.pay(amount);
        }
    }

    public static void main(String[] args) {

        FeePayment[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeePayment(),
            new FeePayment()
        };

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeePayment account : accounts) {

            processPayment(account, 60000);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: " + hostelCount +
                " | Day-scholar accounts processed: " + dayScholarCount);
    }
}

class HostelFeeAccount extends FeePayment {

    void payInInstallments(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}