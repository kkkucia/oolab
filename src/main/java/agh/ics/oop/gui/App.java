package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.FileNotFoundException;
import java.util.Map;


public class App extends Application {
    private final GridPane grid = new GridPane();
    private AbstractWorldMap map;
    private final int size = 40;
    private final int moveDelay = 300;
    private Stage stage;
    private SimulationEngine engine;
    private Button button;
    private TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        try {
            button = new Button("Start");
            textField = new TextField();
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            engine = new SimulationEngine(map, positions, this, moveDelay);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init();
        this.stage = primaryStage;
        this.stage.setTitle("Animals");

        Vector2d lowerCorner = map.getMapBoundary().getMapBounds()[0];
        Vector2d upperCorner = map.getMapBoundary().getMapBounds()[1];

        int width = (upperCorner.x() - lowerCorner.x() + 2) * size;
        int height = (upperCorner.y() - lowerCorner.y() + 3) * size;

        HBox input = new HBox(button, textField);
        VBox verticalBox = new VBox(grid, input);
        verticalBox.setAlignment(Pos.CENTER);
        input.setAlignment(Pos.CENTER);

        button.setOnAction(event -> {
            MoveDirection[] directions = OptionsParser.parse(textField.getText().split(" "));
            engine.setDirections(directions);
            Thread thread = new Thread(engine);
            thread.start();
        });
        drawMap();

        Scene scene = new Scene(verticalBox, width, height);
        stage.setScene(scene);
        stage.show();
    }

    public void drawMap() throws FileNotFoundException {
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.setGridLinesVisible(true);

        Label label = new Label("y / x");
        grid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(size));
        grid.getRowConstraints().add(new RowConstraints(size));

        Map<Vector2d, Animal> animalList = map.getAnimalList();
        Map<Vector2d, Grass> grassList = map.getGrassList();
        Vector2d lowerCorner = map.getMapBoundary().getMapBounds()[0];
        Vector2d upperCorner = map.getMapBoundary().getMapBounds()[1];

        for (int i = lowerCorner.y(); i <= upperCorner.y(); i++) {
            Label numberY = new Label("" + i);
            grid.add(numberY, 0, upperCorner.y() - i + 1);
            grid.getRowConstraints().add(new RowConstraints(size));
            GridPane.setHalignment(numberY, HPos.CENTER);
        }

        for (int i = lowerCorner.x(); i <= upperCorner.x(); i++) {
            Label numberX = new Label("" + i);
            grid.add(numberX, i - lowerCorner.x() + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(size));
            GridPane.setHalignment(numberX, HPos.CENTER);
        }

        for (Grass grass : grassList.values()) {
            VBox element = new GuiElementBox(grass, MapDirection.NORTH).getVerticalBox();
            Vector2d position = grass.getPosition();
            grid.add(element, position.x() - lowerCorner.x() + 1, upperCorner.y() - position.y() + 1);
            GridPane.setHalignment(element, HPos.CENTER);
        }

        for (Animal animal : animalList.values()) {
            VBox element = new GuiElementBox(animal, animal.getDirection()).getVerticalBox();
            Vector2d position = animal.getPosition();
            grid.add(element, position.x() - lowerCorner.x() + 1, upperCorner.y() - position.y() + 1);
            GridPane.setHalignment(element, HPos.CENTER);
        }
        stage.show();
    }

    public void draw() {
        Platform.runLater(() -> {
            try {
                drawMap();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
