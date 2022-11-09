package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    final ArrayList<Animal> animals;
    private final IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();
        addAnimalsToMap(positions);
    }

    private void addAnimalsToMap(Vector2d[] positions) {
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            animals.add(animal);
            map.place(animal);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }
}
