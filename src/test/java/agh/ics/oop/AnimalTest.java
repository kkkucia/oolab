package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    MapDirection expectedNorth = MapDirection.NORTH;
    MapDirection expectedSouth = MapDirection.SOUTH;
    MapDirection expectedEast = MapDirection.EAST;
    MapDirection expectedWest = MapDirection.WEST;

    @Test
    public void testCorrectDirectionRight() {
        Animal animal = new Animal();

        assertEquals(animal.getDirection(), expectedNorth);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), expectedEast);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), expectedSouth);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), expectedWest);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), expectedNorth);
    }

    @Test
    public void testCorrectDirectionLeft() {
        Animal animal = new Animal();

        assertEquals(animal.getDirection(), expectedNorth);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), expectedWest);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), expectedSouth);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), expectedEast);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), expectedNorth);
    }


    @Test
    public void testCorrectPosition() {
        Animal animal = new Animal();

        assertEquals(animal.getPosition(), new Vector2d(2, 2));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(2, 3));

        animal.move(MoveDirection.RIGHT).move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(3, 3));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 3));

        animal.move(MoveDirection.LEFT).move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 4));

        animal.move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 1));


    }

    @Test
    public void testGoOutsideTheMap() {
        Animal animal = new Animal();

        animal.setPosition(new Vector2d(0, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(0, 0));

        animal.setPosition(new Vector2d(4, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 0));

        animal.setPosition(new Vector2d(0, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(0, 4));

        animal.setPosition(new Vector2d(4, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 4));

        animal.setPosition(new Vector2d(2, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(2, 4));

        animal.setPosition(new Vector2d(2, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(2, 0));

        animal.setPosition(new Vector2d(4, 2));
        animal.setDirection(MapDirection.EAST);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 2));

        animal.setPosition(new Vector2d(0, 2));
        animal.setDirection(MapDirection.WEST);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(0, 2));
    }

}
