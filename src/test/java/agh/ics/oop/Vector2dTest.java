package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {
    @Test
    public void testVector2Equals() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(2, 1);

        assertEquals(vector2, vector1);
        assertNotEquals(vector3, vector1);
    }

    @Test
    public void testVector2ToString() {
        Vector2d vector = new Vector2d(1, 2);

        assertEquals("(1,2)", vector.toString());
    }

    @Test
    public void testVector2Precedes() {
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(3, 4);

        assertTrue(vector1.precedes(vector2));
        assertFalse(vector2.precedes(vector1));
    }

    @Test
    public void testVector2Follows() {
        Vector2d vector1 = new Vector2d(3, 6);
        Vector2d vector2 = new Vector2d(3, 4);

        assertTrue(vector1.follows(vector2));
        assertFalse(vector2.follows(vector1));
    }

    @Test
    public void testVector2UpperRight() {
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(3, 4);
        Vector2d vector3 = new Vector2d(3, 1);

        assertEquals(vector2, vector1.upperRight(vector2));
        assertNotEquals(vector1, vector2.upperRight(vector1));
        assertNull(vector1.upperRight(vector3));
    }

    @Test
    public void testVector2LowerLeft() {
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(3, 4);
        Vector2d vector3 = new Vector2d(3, 1);

        assertEquals(vector1, vector1.lowerLeft(vector2));
        assertNotEquals(vector2, vector2.lowerLeft(vector1));
        assertNull(vector1.lowerLeft(vector3));
    }

    @Test
    public void testVector2Add() {
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(3, 7);

        assertEquals(new Vector2d(5, 8), vector1.add(vector2));
    }

    @Test
    public void testVector2Subtract() {
        Vector2d vector1 = new Vector2d(7, 3);
        Vector2d vector2 = new Vector2d(1, 5);

        assertEquals(new Vector2d(6, -2), vector1.subtract(vector2));
    }

    @Test
    public void testVector2Opposite() {
        Vector2d vector = new Vector2d(1, -2);

        assertEquals(new Vector2d(-1, 2), vector.opposite());
    }
}
