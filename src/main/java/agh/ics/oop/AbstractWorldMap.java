package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animalList = new HashMap<>();
    protected Map<Vector2d, Grass> grassList = new HashMap<>();


    protected MapVisualiser map = new MapVisualiser(this);

    protected MapBoundary mapBoundary = new MapBoundary();


    @Override
    public String toString() {
        return map.draw(mapBoundary.mapBounds[0], mapBoundary.mapBounds[1]);
    }

    public Map<Vector2d, Animal> getAnimalList() {
        return animalList;
    }

    public Map<Vector2d, Grass> getGrassList() {
        return grassList;
    }

    public MapBoundary getMapBoundary() {
        return mapBoundary;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalList.get(oldPosition);
        animalList.put(newPosition, animal);
        animalList.remove(oldPosition, animal);
        grassIsEating(oldPosition);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        Vector2d currentPosition = animal.getPosition();
        if (!canMoveTo(currentPosition)) {
            throw new IllegalArgumentException(currentPosition + " is not legal move specification.");
        }
        grassIsEating(currentPosition);
        mapBoundary.addPosition(currentPosition);
        animalList.put(currentPosition, animal);

        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        grassIsEating(position);
        return !(objectAt(position) instanceof Animal);

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
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

    public void grassIsEating(Vector2d position) {
    }
}
