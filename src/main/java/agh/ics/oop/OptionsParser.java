package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) throws IllegalArgumentException {
        ArrayList<MoveDirection> directionList = new ArrayList<>();

        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> directionList.add(MoveDirection.FORWARD);
                case "b", "backward" -> directionList.add(MoveDirection.BACKWARD);
                case "r", "right" -> directionList.add(MoveDirection.RIGHT);
                case "l", "left" -> directionList.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(arg + " is not legal move specification.");
            }
        }
        MoveDirection[] moves = new MoveDirection[directionList.size()];
        directionList.toArray(moves);
        return moves;
    }
}
