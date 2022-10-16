package agh.ics.oop;

import java.util.Objects;

public record Vector2d(int x, int y) {

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        return x <= other.x && y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return x >= other.x && y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        if (other.x == x || other.y == y) {
            return null;
        } else if (x < other.x && y < other.y) {
            return other;
        }
        return this;
    }

    public Vector2d lowerLeft(Vector2d other) {
        if (other.x == x || other.y == y) {
            return null;
        } else if (x > other.x && y > other.y) {
            return other;
        }
        return this;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Vector2d vector2d = (Vector2d) other;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }
}
