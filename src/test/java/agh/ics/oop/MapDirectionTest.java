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

        assertEquals(MapDirection.EAST, MapDirection.next(north));
        assertEquals(MapDirection.WEST, MapDirection.next(south));
        assertEquals(MapDirection.NORTH, MapDirection.next(west));
        assertEquals(MapDirection.SOUTH, MapDirection.next(east));
    }

    @Test
    public void testPreviousNorth() {
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;
        MapDirection east = MapDirection.EAST;

        assertEquals(MapDirection.WEST, MapDirection.previous(north));
        assertEquals(MapDirection.EAST, MapDirection.previous(south));
        assertEquals(MapDirection.SOUTH, MapDirection.previous(west));
        assertEquals(MapDirection.NORTH, MapDirection.previous(east));
    }
}
