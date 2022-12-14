package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void placeTest() {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(map, new Vector2d(4, 4));
        Animal animal2 = new Animal(map, new Vector2d(2, 4));
        Animal animal3 = new Animal(map, new Vector2d(10, 41));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertTrue(map.animalList.containsValue(animal1));
        assertTrue(map.animalList.containsValue(animal2));
        assertTrue(map.animalList.containsValue(animal3));
    }

    @Test
    public void isOccupiedTest() {
        GrassField map = new GrassField(0);
        Animal animal = new Animal(map, new Vector2d(4, 4));
        map.place(animal);

        assertTrue(map.isOccupied(animal.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void canMoveToTest() {
        GrassField map = new GrassField(100);
        Animal animal = new Animal(map, new Vector2d(4, 4));
        map.place(animal);

        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(21, 37)));
        assertFalse(map.canMoveTo(new Vector2d(4, 4)));
    }

    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(0);
        Animal animal = new Animal(map, new Vector2d(4, 4));
        map.place(animal);

        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNull(map.objectAt(new Vector2d(2, 2)));
    }
}
