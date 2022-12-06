package agh.ics.oop.gui;

import agh.ics.oop.*;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private final VBox verticalBox;
    private ImageView imageView;


    public GuiElementBox(IMapElement element, MapDirection direction) {
        verticalBox = new VBox();
        try {
            Image image = new Image(new FileInputStream(element.getTexture()));
            imageView = new ImageView(image);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            imageView.setRotate(direction.getRotation());
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.exit(1);
        }

        Label label;
        if (element instanceof Animal) {
            label = new Label((element.getPosition().toString()));
        } else {
            label = new Label("Grass");
        }
        verticalBox.getChildren().addAll(imageView, label);
        verticalBox.setAlignment(Pos.CENTER);
    }

    public VBox getVerticalBox() {
        return verticalBox;
    }
}