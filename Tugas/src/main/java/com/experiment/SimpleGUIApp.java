package main.java.com.experiment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SimpleGUIApp extends Application {

    private MyVBox myVBox;
    private MyHBox myHBox;

    @Override
    public void start(Stage primaryStage) {
        myVBox = new MyVBox();
        myHBox = new MyHBox();

        Button switchButtonHBox = new Button("Switch to HBox");
        Button switchButtonVBox = new Button("Switch to VBox");

        myVBox.getChildren().add(switchButtonHBox);
        myHBox.getChildren().add(switchButtonVBox);

        switchButtonHBox.setOnAction(_ -> {
            primaryStage.getScene().setRoot(myHBox);
        });

        switchButtonVBox.setOnAction(_ -> {
            primaryStage.getScene().setRoot(myVBox);
        });

        Scene scene = new Scene(myVBox, 300, 250);

        primaryStage.setTitle("Simple GUI App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
