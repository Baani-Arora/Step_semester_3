package oop.assignment_problems;

class FleetTracker {

    static String getLocationIfTrackable(Object o) {

        if (o instanceof Trackable) {

            Trackable t = (Trackable) o;
            return t.getLocation();
        }

        return "Tracking not available";
    }
}