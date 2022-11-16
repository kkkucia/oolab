package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final ArrayList<Animal> animals = new ArrayList<>();
    protected final ArrayList<Grass> grassList = new ArrayList<>();
    private final Vector2d initMap = new Vector2d(0, 0);
    protected Vector2d[] mapBounds = new Vector2d[]{initMap, initMap};
    protected MapVisualiser map = new MapVisualiser(this);


    @Override
    public String toString() {
        return map.draw(mapBounds[0], mapBounds[1]);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            changeMapBounds(animal.getPosition());
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return isOccupiedByAnimal(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animalAt(position) == null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        for (Grass grass : grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    public Object animalAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    public void changeMapBounds(Vector2d elementPosition) {
        mapBounds[0] = mapBounds[0].lowerLeft(elementPosition);
        mapBounds[1] = mapBounds[1].upperRight(elementPosition);
    }
}
