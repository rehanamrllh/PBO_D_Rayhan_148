package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import main.java.com.praktikum.main.LoginSystem;
import main.java.com.praktikum.users.Admin;
import main.java.com.praktikum.users.Mahasiswa;
import main.java.com.praktikum.users.User;

public class LoginPane extends VBox {
    private ComboBox<String> userTypeCombo;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Text errorText;

    public LoginPane(LoginSystem loginSystem) {
        setPadding(new Insets(50));
        setSpacing(20);
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Login Sistem");
        titleLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");

        userTypeCombo = new ComboBox<>();
        userTypeCombo.getItems().addAll("Mahasiswa", "Admin");
        userTypeCombo.setValue("Mahasiswa");
        userTypeCombo.setPrefWidth(300);
        userTypeCombo.setStyle("-fx-font-size: 14px;");

        usernameField = new TextField();
        usernameField.setPromptText(userTypeCombo.getValue().equals("Admin") ? "Username" : "Nama");
        usernameField.setPrefWidth(200);
        usernameField.setMaxWidth(600); // Added max width
        usernameField.setPrefHeight(40);
        usernameField.setStyle("-fx-font-size: 14px;");

        passwordField = new PasswordField();
        passwordField.setPromptText(userTypeCombo.getValue().equals("Admin") ? "Password" : "NIM");
        passwordField.setPrefWidth(200);
        passwordField.setMaxWidth(600); // Added max width
        passwordField.setPrefHeight(40);
        passwordField.setStyle("-fx-font-size: 14px;");

        loginButton = new Button("Login");
        loginButton.setPrefWidth(300);
        loginButton.setPrefHeight(40);
        loginButton.setStyle("-fx-font-size: 14px;");

        errorText = new Text("");
        errorText.setStyle("-fx-fill: red; -fx-font-size: 14px;");

        userTypeCombo.setOnAction(_ -> {
            boolean isAdmin = userTypeCombo.getValue().equals("Admin");
            usernameField.setPromptText(isAdmin ? "Username" : "Nama");
            passwordField.setPromptText(isAdmin ? "Password" : "NIM");
        });

        loginButton.setOnAction(_ -> handleLogin());

        getChildren().addAll(titleLabel, userTypeCombo, usernameField,
                passwordField, loginButton, errorText);
    }

    private void handleLogin() {
        String input1 = usernameField.getText();
        String input2 = passwordField.getText();
        String userType = userTypeCombo.getValue();

        try {
            boolean isAdmin = userType.equals("Admin");
            User user = LoginSystem.cariUser(input1, input2, isAdmin);

            if (user != null) {
                Scene currentScene = getScene();
                if (user instanceof Admin) {
                    currentScene.setRoot(new AdminDashboard((Admin) user));
                } else if (user instanceof Mahasiswa) {
                    currentScene.setRoot(new MahasiswaDashboard((Mahasiswa) user));
                }
            } else {
                errorText.setText("Login gagal! Periksa kredensial anda.");
            }
        } catch (Exception e) {
            errorText.setText(e.getMessage());
        }
    }
}
