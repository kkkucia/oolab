package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;

public class SimulationEngine implements IEngine,  Runnable {
    private MoveDirection[] directions;
    final ArrayList<Animal> animals;
    private final IWorldMap map;
    private final int moveDelay;
    private final App application;

    public SimulationEngine(IWorldMap map, Vector2d[] positions, App application, int moveDelay) {
        this.map = map;
        this.animals = new ArrayList<>();
        this.application = application;
        this.moveDelay = moveDelay;
        addAnimalsToMap(positions);
    }


    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
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
            try {
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            animals.get(i % animals.size()).move(directions[i]);
            application.draw();
        }
    }
}
