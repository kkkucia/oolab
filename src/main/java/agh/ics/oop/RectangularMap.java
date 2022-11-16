package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height) {
        super();
        mapBounds[0] = new Vector2d(0, 0);
        mapBounds[1] = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return isOccupiedByAnimal(position) && position.follows(mapBounds[0]) && position.precedes(mapBounds[1]);
    }
}
