package main.java.com.experiment;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyVBox extends VBox {

    public MyVBox() {
        super(10);
        setPadding(new Insets(20));

        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Button button = new Button("Say Hello");
        Label greetingLabel = new Label();

        button.setOnAction(_ -> {
            String name = textField.getText();
            if (name != null && !name.isEmpty()) {
                greetingLabel.setText("Hello, " + name + "!");
            } else {
                greetingLabel.setText("Please enter your name.");
            }
        });

        getChildren().addAll(label, textField, button, greetingLabel);
    }
}
