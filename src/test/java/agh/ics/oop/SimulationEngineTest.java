package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SimulationEngineTest {
    @Test
    public void worldSimulationTest() {
        String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

        MoveDirection[] directions = OptionsParser.parse(moves);
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertEquals(new Vector2d(2, 0), engine.animals.get(0).getPosition());
        assertEquals(new Vector2d(3, 5), engine.animals.get(1).getPosition());

        assertNotEquals(new Vector2d(4, 2), engine.animals.get(0).getPosition());
        assertNotEquals(new Vector2d(1, 3), engine.animals.get(0).getPosition());
    }
}
