package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {

    public Grass(Vector2d initialPosition) {
        super(initialPosition);
    }

    @Override
    public String toString() {
        return "*";
    }
}
