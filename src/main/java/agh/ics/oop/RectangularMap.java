package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d initMap = new Vector2d(0, 0);
    public Vector2d[] mapBounds = new Vector2d[]{initMap, initMap};

    public RectangularMap(int width, int height) {
        super();
        mapBounds[1] = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(mapBounds[0]) && position.precedes(mapBounds[1]);
    }
}
