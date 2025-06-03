package main.java.com.experiment;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MyHBox extends HBox {
    public MyHBox() {
        super(10);
        setPadding(new Insets(20));
        Label hboxLabel = new Label("This is HBox");
        getChildren().add(hboxLabel);
    }
}
