package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        MoveDirection[] moves = OptionsParser.parse(args);
        run(moves);
        System.out.println("Stop");

        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        Animal animal = new Animal();
        System.out.println(animal);

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal);
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
