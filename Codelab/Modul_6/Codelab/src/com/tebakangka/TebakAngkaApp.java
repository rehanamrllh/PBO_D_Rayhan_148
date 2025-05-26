package com.tebakangka;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.Random;

public class TebakAngkaApp extends Application {
    private int angkaRandom;
    private int percobaan;
    private final Random rand = new Random();

    private TextField inputField;
    private Button tebakButton;
    private Label feedbackLabel;
    private Label percobaanLabel;

    @Override
    public void start(Stage primaryStage) {
        angkaRandom = rand.nextInt(100) + 1;
        percobaan = 0;

        // Judul
        Label title = new Label("\uD83D\uDD2E Tebak Angka 1–100");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        title.setTextFill(Color.web("#2233bb"));

        // Feedback
        feedbackLabel = new Label("Masukkan tebakanmu!");
        feedbackLabel.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 16));
        feedbackLabel.setTextFill(Color.web("#3399bb"));

        // Input dan tombol
        inputField = new TextField();
        inputField.setPromptText(" ");
        inputField.setPrefWidth(180);
        inputField.setFont(Font.font("Segoe UI", 16));

        tebakButton = new Button("\uD83C\uDFB2 Coba Tebak!");
        tebakButton.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 14));
        tebakButton.setStyle("-fx-background-color: #43b36a; -fx-text-fill: white;");

        HBox inputBox = new HBox(10, inputField, tebakButton);
        inputBox.setAlignment(Pos.CENTER);

        // Percobaan label
        percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setFont(Font.font("Segoe UI", 14));
        percobaanLabel.setTextFill(Color.web("#888"));

        VBox root = new VBox(18, title, feedbackLabel, inputBox, percobaanLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30, 40, 30, 40));
        root.setStyle("-fx-background-color: #f3f8ff;");

        // Event handler
        tebakButton.setOnAction(e -> prosesTebakan());
        inputField.setOnAction(e -> prosesTebakan());

        Scene scene = new Scene(root, 420, 260);
        primaryStage.setTitle("Aplikasi Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void prosesTebakan() {
        if (tebakButton.getText().equals("Main Lagi")) {
            angkaRandom = rand.nextInt(100) + 1;
            percobaan = 0;
            feedbackLabel.setText("Masukkan tebakanmu!");
            feedbackLabel.setTextFill(Color.web("#3399bb"));
            inputField.setDisable(false);
            inputField.clear();
            tebakButton.setText("\uD83C\uDFB2 Coba Tebak!");
            percobaanLabel.setText("Jumlah percobaan: 0");
            return;
        }

        String input = inputField.getText().trim();
        int tebakan;
        try {
            tebakan = Integer.parseInt(input);
        } catch (Exception ex) {
            feedbackLabel.setText("Masukkan angka valid!");
            feedbackLabel.setTextFill(Color.ORANGE);
            return;
        }

        percobaan++;
        percobaanLabel.setText("Jumlah percobaan: " + percobaan);

        if (tebakan < angkaRandom) {
            feedbackLabel.setText("\u25BC Terlalu kecil!!"); // ▼
            feedbackLabel.setTextFill(Color.web("#ffb300"));
            inputField.clear();
        } else if (tebakan > angkaRandom) {
            feedbackLabel.setText("\u25B2 Terlalu besar!"); // ▲
            feedbackLabel.setTextFill(Color.web("#ffb300"));
            inputField.clear();
        } else {
            feedbackLabel.setText("\uD83C\uDF89 Tebakan benar!");
            feedbackLabel.setTextFill(Color.web("#43b36a"));
            tebakButton.setText("Main Lagi");
            inputField.setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}