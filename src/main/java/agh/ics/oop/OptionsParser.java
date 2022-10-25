package agh.ics.oop;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {
        int moveCounter = 0;
        int trashCounter = 0;

        for (String argument : args) {
            switch (argument) {
                case "f", "forward", "b", "backward", "r", "right", "l", "left" -> {
                    moveCounter += 1;
                }
                default -> trashCounter += 1;
            }
        }
        MoveDirection[] moves = new MoveDirection[moveCounter];
        int j = 0;
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> moves[j] = MoveDirection.FORWARD;
                case "b", "backward" -> moves[j] = MoveDirection.BACKWARD;
                case "r", "right" -> moves[j] = MoveDirection.RIGHT;
                case "l", "left" -> moves[j] = MoveDirection.LEFT;
                default -> j -= 1;
            }
            j += 1;
        }
        return moves;
    }
}
