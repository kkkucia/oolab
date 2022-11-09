package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void testCorrectDirectionRight() {
        Animal animal = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        assertEquals(MapDirection.NORTH, animal.getDirection());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getDirection());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal.getDirection());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal.getDirection());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }

    @Test
    public void testCorrectDirectionLeft() {
        Animal animal = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        assertEquals(MapDirection.NORTH, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getDirection());
    }


    @Test
    public void testCorrectPosition() {
        Animal animal = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        assertEquals(new Vector2d(2, 2), animal.getPosition());

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());

        animal.move(MoveDirection.RIGHT).move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 3), animal.getPosition());

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 3), animal.getPosition());

        animal.move(MoveDirection.LEFT).move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 4), animal.getPosition());

        animal.move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(4, 1), animal.getPosition());
    }

    @Test
    public void testGoOutsideTheMap() {
        Animal animal1 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        animal1.move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 0), animal1.getPosition());

        animal1.move(MoveDirection.LEFT).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0, 0), animal1.getPosition());

        animal1.move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(4, 0), animal1.getPosition());


        Animal animal2 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        animal2.move(MoveDirection.FORWARD).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 4), animal2.getPosition());

        animal2.move(MoveDirection.LEFT).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0, 4), animal2.getPosition());

        animal2.move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(4, 4), animal2.getPosition());


        Animal animal3 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        animal3.move(MoveDirection.LEFT).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0, 2), animal3.getPosition());

        animal3.move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD).move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(4, 2), animal3.getPosition());
    }
}
