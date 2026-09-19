package oop.assignment_problems;

abstract class ArtPiece {

    private static int counter = 1000;
    private final String pieceId;
    protected String title;

    public ArtPiece(String title) {

        this.title = title;
        pieceId = "ART-" + (++counter);
    }

    public String getPieceId() {
        return pieceId;
    }

    public abstract String describe();
}