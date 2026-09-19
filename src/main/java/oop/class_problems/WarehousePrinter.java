package oop.class_problems;

class WarehousePrinter {

    static void printAll(Printable[] items) {

        for (Printable item : items)
            System.out.println(item.printLabel());
    }
}