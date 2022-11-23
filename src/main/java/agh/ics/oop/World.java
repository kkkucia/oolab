package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            GrassField map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
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
