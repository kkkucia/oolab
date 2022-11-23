package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;
import static java.util.Collections.shuffle;

public class GrassField extends AbstractWorldMap {

    private final int grassQuantity;
    private final int grassRange;

    public GrassField(int grassQuantity) {
        this.grassQuantity = grassQuantity;
        this.grassRange = (int) sqrt(grassQuantity * 10);
        addGrassToMapRandomly();
    }

    private void addGrassToMapRandomly() {
        if (grassQuantity < grassRange) {
            ArrayList<Integer> grassCoordinatesListX = generateGrassCoordinates();
            ArrayList<Integer> grassCoordinatesListY = generateGrassCoordinates();
            for (int j = 0; j < grassQuantity; j++) {
                Vector2d grassPosition = new Vector2d(grassCoordinatesListX.get(j), grassCoordinatesListY.get(j));
                changeMapBounds(grassPosition);
                grassList.put(grassPosition, new Grass(grassPosition));
            }
        } else {
            int i = 0;
            while (i < grassQuantity) {
                Vector2d grassPosition = randomPositionGenerator();
                if (!isOccupied(grassPosition)) {
                    changeMapBounds(grassPosition);
                    grassList.put(grassPosition, new Grass(grassPosition));
                    i++;
                }
            }
        }
    }

    private ArrayList<Integer> generateGrassCoordinates() {
        ArrayList<Integer> grassCoordinatesList = new ArrayList<>();
        for (int i = 0; i < grassRange; i++) {
            grassCoordinatesList.add(i);
        }
        shuffle(grassCoordinatesList);
        return grassCoordinatesList;
    }

    private Vector2d randomPositionGenerator() {
        Random generator = new Random();
        int x = generator.nextInt((int) Math.sqrt(grassQuantity * 10) + 1);
        int y = generator.nextInt((int) Math.sqrt(grassQuantity * 10) + 1);
        return new Vector2d(x, y);
    }
}
