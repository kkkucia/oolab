package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("Start");
        Direction[] moves = change(args);
        run(moves);
        System.out.println("Stop");
    }
    public static Direction[] change(String[] args){
        int len = args.length;
        Direction[] moves = new Direction[len];
        for (int i = 0; i < len; i++){
            Direction move = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.FAIL;
            };
                moves[i] = move;
        }
        return moves;
    }
    public static void run(Direction [] moves){
        for (Direction argument : moves){
            String move = switch (argument){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                default -> "";
            };
            System.out.println(move);
        }
    }
}
