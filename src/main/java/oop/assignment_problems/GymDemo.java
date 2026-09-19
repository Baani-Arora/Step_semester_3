package oop.assignment_problems;

class GymDemo {

    public static void main(String[] args) {

        PremiumMember premium =
                new PremiumMember("MEM01", 2000, "Coach Riya");

        EliteMember elite =
                new EliteMember("MEM02", 3000, "Coach Arjun", "L12");

        GroupClassMember group =
                new GroupClassMember("MEM03", 1500, "Zumba");

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();

        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        System.out.println(GymMember.signUpBatch(
                new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"},
                1000));

        premium.displayInfo();
        elite.displayInfo();
        group.displayInfo();

        System.out.println(GymMembershipUtils.classifyGeneration(elite));
        System.out.println(GymMembershipUtils.classifyGeneration(group));

        GymMember[] members = {premium, elite, group};

        System.out.println("Total Sessions: " +
                GymMembershipUtils.getTotalSessionsAttended(members));

        premium.chargeLateFee(200);
        System.out.println("Late Fee Total: " +
                premium.getTotalLateFees());

        System.out.println(GymMembershipUtils.batchPrint(members));

        GymMember temp = new GymMember(1000);

        temp.payFee(500);
        temp.payFee(500, "UPI");

        System.out.println(temp.getMembershipNumber());
        System.out.println(temp.getFeesPaid());

        System.out.println(GymMember.isValidReferralCode("G45B"));

        GymMember[] weekly = {group, null, temp};

        System.out.println(GymMembershipUtils.processWeeklyCheckIn(weekly));
    }
}