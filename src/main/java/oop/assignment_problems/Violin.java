package oop.class_problems;

class Violin extends StringInstrument {

    public Violin() {
        super();
    }

    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}