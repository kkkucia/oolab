package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement {
    private MapDirection direction;
    private final IWorldMap map;
    private final ArrayList<IPositionChangeObserver> observerList;


    public Animal(IWorldMap map, Vector2d initialPosition) {
        super(initialPosition);
        this.direction = MapDirection.NORTH;
        this.observerList = new ArrayList<>();
        this.map = map;
        addObserver((IPositionChangeObserver) map);
    }

    public MapDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return direction.toString();
    }

    @Override
    public String getTexture() {
        return "src/main/resources/animal.png";
    }

    private void changePosition(boolean moveForward) {
        Vector2d newPosition;
        if (moveForward) {
            newPosition = position.add(this.direction.toUnitVector());
        } else {
            newPosition = position.subtract(this.direction.toUnitVector());
        }
        if (map.canMoveTo(newPosition)) {
            positionChanged(position, newPosition);
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

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observerList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        this.observerList.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observerList.remove(observer);
    }
}
