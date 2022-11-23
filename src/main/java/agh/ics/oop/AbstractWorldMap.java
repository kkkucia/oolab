package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animalList = new HashMap<>();
    protected Map<Vector2d, Grass> grassList = new HashMap<>();
    private final Vector2d initMap = new Vector2d(0, 0);
    protected Vector2d[] mapBounds = new Vector2d[]{initMap, initMap};
    protected MapVisualiser map = new MapVisualiser(this);


    @Override
    public String toString() {
        return map.draw(mapBounds[0], mapBounds[1]);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalList.get(oldPosition);
        animalList.put(newPosition, animal);
        animalList.remove(oldPosition, animal);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        Vector2d currentPosition = animal.getPosition();
        if (!canMoveTo(currentPosition)) {
            throw new IllegalArgumentException(currentPosition + " is not legal move specification.");
        }
        changeMapBounds(currentPosition);
        animalList.put(currentPosition, animal);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animalAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animalList.containsKey(position)) {
            return animalList.get(position);
        }
        if (grassList.containsKey(position)) {
            return grassList.get(position);
        }
        return null;
    }

    public Object animalAt(Vector2d position) {
        if (animalList.containsKey(position)) {
            return animalList.get(position);
        }
        return null;
    }

    public void changeMapBounds(Vector2d elementPosition) {
        mapBounds[0] = mapBounds[0].lowerLeft(elementPosition);
        mapBounds[1] = mapBounds[1].upperRight(elementPosition);
    }
}
