package main.java.com.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.praktikum.main.LoginSystem;

public class MainApp extends Application {
    private LoginSystem loginSystem;

    @Override
    public void start(Stage primaryStage) {
        loginSystem = new LoginSystem();

        LoginPane loginPane = new LoginPane(loginSystem);
        Scene scene = new Scene(loginPane, 1200, 800);

        primaryStage.setTitle("Project PBO - Sistem Pelaporan Barang Hilang/Temuan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
