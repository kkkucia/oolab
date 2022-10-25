package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapDirectionTest {
    @Test
    public void testNext() {
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;
        MapDirection east = MapDirection.EAST;

        assertEquals(MapDirection.EAST, north.next());
        assertEquals(MapDirection.WEST, south.next());
        assertEquals(MapDirection.NORTH, west.next());
        assertEquals(MapDirection.SOUTH, east.next());
    }

    @Test
    public void testPreviousNorth() {
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;
        MapDirection east = MapDirection.EAST;

        assertEquals(MapDirection.WEST, north.previous());
        assertEquals(MapDirection.EAST, south.previous());
        assertEquals(MapDirection.SOUTH, west.previous());
        assertEquals(MapDirection.NORTH, east.previous());
    }
}
