package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RectangularMapTest {
    @Test
    public void placeTest() {
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal1 = new Animal(map, new Vector2d(4, 4));
        Animal animal2 = new Animal(map, new Vector2d(2, 4));
        Animal animal3 = new Animal(map, new Vector2d(4, 4));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertTrue(map.animals.contains(animal1));
        assertTrue(map.animals.contains(animal2));
        assertFalse(map.animals.contains(animal3));
    }

    @Test
    public void isOccupiedTest() {
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal = new Animal(map, new Vector2d(4, 4));
        map.place(animal);

        assertTrue(map.isOccupied(animal.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void canMoveToTest() {
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal = new Animal(map, new Vector2d(4, 4));
        map.place(animal);

        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(4, 4)));
    }

    @Test
    public void objectAtTest() {
        RectangularMap map = new RectangularMap(8, 8);
        Animal animal = new Animal(map, new Vector2d(4, 4));
        map.place(animal);

        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNull(map.objectAt(new Vector2d(2, 2)));
    }
}
