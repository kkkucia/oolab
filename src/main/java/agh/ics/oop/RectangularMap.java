package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private final Vector2d upperCorner;
    private final Vector2d lowerCorner = new Vector2d(0, 0);
    protected final ArrayList<Animal> animals;

    public RectangularMap(int width, int height) {
        this.animals = new ArrayList<>();
        upperCorner = new Vector2d(width, height);
    }

    @Override
    public String toString() {
        return new MapVisualiser(this).draw(lowerCorner, upperCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(lowerCorner) && position.precedes(upperCorner);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }
}
