package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {
    private MapDirection direction;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.direction = MapDirection.NORTH;
        this.map = map;
    }

    public MapDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return direction.toString();
    }

    private void changePosition(boolean moveForward) {
        Vector2d newPosition;
        if (moveForward) {
            newPosition = position.add(this.direction.toUnitVector());
        } else {
            newPosition = position.subtract(this.direction.toUnitVector());
        }
        if (map.canMoveTo(newPosition)) {
            position = newPosition;
        }
    }

    public Animal move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> changePosition(true);
            case BACKWARD -> changePosition(false);
        }
        return this;
    }
}
