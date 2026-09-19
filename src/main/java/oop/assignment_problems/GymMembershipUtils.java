package oop.assignment_problems;

class GymMembershipUtils {

    static String classifyGeneration(GymMember member) {

        if (member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";

        return "Standard/Premium";
    }

    static int getTotalSessionsAttended(GymMember[] members) {

        int total = 0;

        for (GymMember member : members)
            total += member.getSessionsAttended();

        return total;
    }

    static String batchPrint(GymMember[] members) {

        StringBuilder sb = new StringBuilder();

        for (GymMember member : members) {

            if (member instanceof PremiumMember premium) {

                sb.append("Premium | Trainer: ")
                        .append(premium.getTrainerName())
                        .append(" | Sessions: ")
                        .append(member.getSessionsAttended())
                        .append(" [Trainer via downcast: ")
                        .append(premium.getTrainerName())
                        .append("] | ");

            } else {

                sb.append("Standard | Sessions: ")
                        .append(member.getSessionsAttended())
                        .append(" | ");
            }
        }

        return sb.toString();
    }

    static String processWeeklyCheckIn(GymMember[] members) {

        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember)
                group++;
            else
                individual++;
        }

        return processed +
                " processed | " +
                skipped +
                " null skipped | " +
                group +
                " group | " +
                individual +
                " individual";
    }
}