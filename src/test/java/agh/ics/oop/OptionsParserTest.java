package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
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
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"b", "left", "f", "unexpected", "r", "x", "right", "y", "z", "backward"};
            OptionsParser.parse(toParse);
        });
        Assertions.assertEquals("unexpected is not legal move specification.", exeption.getMessage());
    }

    @Test
    public void testMoveParserWithAlIncorrectInput() {
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"x", "unexpected", "y", "z", "surprise"};
            OptionsParser.parse(toParse);
        });
        Assertions.assertEquals("x is not legal move specification.", exeption.getMessage());
    }

    @Test
    public void testMoveParserWithEmptyInput() {
        String[] toParse = {};

        MoveDirection[] expected = {};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }
}
