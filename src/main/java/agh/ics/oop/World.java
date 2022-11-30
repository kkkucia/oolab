package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    private static Direction[] change(String[] args) {
        Direction[] moves = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            moves[i] = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> null;
            };
        }
        return moves;
    }

    private static void run(MoveDirection[] moves) {
        for (MoveDirection argument : moves) {
            String move = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                default -> "Błędny ruch";
            };
            System.out.println(move);
        }
    }
}
