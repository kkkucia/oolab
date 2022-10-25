package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;

    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return   "Pozycja = " + position.toString() + ", Orientacja = " + direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction) {
        Vector2d topCorner = new Vector2d(4, 4);
        Vector2d downCorner = new Vector2d(0, 0);
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(this.direction.toUnitVector());
                if (newPosition.follows(downCorner) && newPosition.precedes(topCorner)) {
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(this.direction.toUnitVector());
                if (newPosition.follows(downCorner) && newPosition.precedes(topCorner)) {
                    position = newPosition;
                }
            }
        }
        return this;
    }
}
