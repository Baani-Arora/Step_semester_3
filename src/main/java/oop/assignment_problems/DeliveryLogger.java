package oop.class_problems;

class DeliveryLogger {

    static void logAll(DeliveryNote[] notes) {

        for (DeliveryNote note : notes)
            System.out.println(note.confirmDelivery());
    }
}