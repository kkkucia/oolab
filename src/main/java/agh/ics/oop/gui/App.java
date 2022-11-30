package agh.ics.oop.gui;

import agh.ics.oop.*;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.Map;


public class App extends Application {
    GridPane grid = new GridPane();
    AbstractWorldMap map;
    final int width = 40;
    final int height = 40;

    @Override
    public void init() throws Exception {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Animals");
        drawMap();
        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawMap() {
        grid.setGridLinesVisible(true);

        Map<Vector2d, Animal> animalsList = map.getAnimalList();
        Map<Vector2d, Grass> grassList = map.getGrassList();

        Vector2d lowerCorner = map.getMapBoundary().getMapBounds()[0];
        Vector2d upperCorner = map.getMapBoundary().getMapBounds()[1];

        Label label = new Label("y / x");
        grid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));

        for (int i = lowerCorner.y(); i <= upperCorner.y(); i++) {
            Label numberY = new Label("" + i);
            grid.add(numberY, 0, upperCorner.y() - i + 1);
            grid.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(numberY, HPos.CENTER);
        }

        for (int i = lowerCorner.x(); i <= upperCorner.x(); i++) {
            Label numberX = new Label("" + i);
            grid.add(numberX, i - lowerCorner.x() + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(numberX, HPos.CENTER);
        }

        for (Grass grass : grassList.values()) {
            Label element = new Label(grass.toString());
            Vector2d position = grass.getPosition();
            grid.add(element, position.x() - lowerCorner.x() + 1, upperCorner.y() - position.y() + 1);
            GridPane.setHalignment(element, HPos.CENTER);
        }

        for (Animal animal : animalsList.values()) {
            Label element = new Label(animal.toString());
            Vector2d position = animal.getPosition();
            grid.add(element, position.x() - lowerCorner.x() + 1, upperCorner.y() - position.y() + 1);
            GridPane.setHalignment(element, HPos.CENTER);
        }
    }

}
