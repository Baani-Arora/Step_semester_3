package oop.class_problems;

abstract class Toy {

    private static int counter = 1000;
    private final String toyId;
    protected String name;

    public Toy(String name) {
        this.name = name;
        toyId = "TOY-" + (++counter);
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}
