package oop.assignment_problems;

class GymMember {

    private static int membersEnrolled = 0;

    protected String memberId;
    protected int monthlyFee;

    private final String membershipNumber;

    private int sessionsAttended = 0;
    private int feesPaid = 0;

    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    public GymMember(String memberId, int monthlyFee) {

        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId.trim();
        this.monthlyFee = monthlyFee;

        membersEnrolled++;
        membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    public GymMember(int monthlyFee) {

        this.memberId = "TEMP" + (membersEnrolled + 1);
        this.monthlyFee = monthlyFee;

        membersEnrolled++;
        membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }

    protected void chargeLateFee(int amount) {

        if (feeCount < lateFeeHistory.length)
            lateFeeHistory[feeCount++] = amount;
    }

    public int[] getLateFeeHistory() {

        int[] copy = new int[feeCount];

        for (int i = 0; i < feeCount; i++)
            copy[i] = lateFeeHistory[i];

        return copy;
    }

    public int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < feeCount; i++)
            total += lateFeeHistory[i];

        return total;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {

        int signed = 0;
        int rejected = 0;

        for (String id : memberIds) {

            try {
                new GymMember(id, monthlyFee);
                signed++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signed + " | Rejected: " + rejected;
    }
}