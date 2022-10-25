package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void testMoveParserWithCorrectInput() {
        String[] toParse = {"f", "left", "forward", "r", "b", "right"};

        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.RIGHT};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithIncorrectInput() {
        String[] toParse = {"b", "left", "x", "f", "unexpected", "right", "y", "z", "backward"};

        MoveDirection[] expected = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.BACKWARD};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithAlIncorrectInput() {
        String[] toParse = {"x", "unexpected", "y", "z", "surprise"};

        MoveDirection[] expected = {};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithEmptyInput() {
        String[] toParse = {};

        MoveDirection[] expected = {};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }
}
