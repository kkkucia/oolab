package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private final Vector2d initMap = new Vector2d(0, 0);
    public Vector2d[] mapBounds = new Vector2d[]{initMap, initMap};

    private final SortedSet<Vector2d> xSet = new TreeSet<>(new Comparator<>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.x() == o2.x()) {
                return o1.y() - o2.y();
            }
            return o1.x() - o2.x();
        }
    });
    private final SortedSet<Vector2d> ySet = new TreeSet<>(new Comparator<>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.y() == o2.y()) {
                return o1.x() - o2.x();
            }
            return o1.y() - o2.y();
        }
    });

    public Vector2d[] getMapBounds() {
        return mapBounds;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removePosition(oldPosition);
        addPosition(newPosition);
    }

    public void removePosition(Vector2d position) {
        xSet.remove(position);
        ySet.remove(position);
    }

    public void addPosition(Vector2d position) {
        xSet.add(position);
        ySet.add(position);
        changeMapBounds();
    }

    public void changeMapBounds() {
        if (!xSet.isEmpty() && !ySet.isEmpty()) {
            mapBounds[0] = new Vector2d(xSet.first().x(), ySet.first().y());
            mapBounds[1] = new Vector2d(xSet.last().x(), ySet.last().y());
        }
    }
}
