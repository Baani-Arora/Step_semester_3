package oop.assignment_problems;

class RingManager {

    static void ringAll(Ringable[] devices) {

        for (Ringable device : devices)
            System.out.println(device.ring());
    }
}