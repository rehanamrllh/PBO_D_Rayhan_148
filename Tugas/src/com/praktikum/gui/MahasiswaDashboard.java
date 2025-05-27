package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.property.SimpleStringProperty;
import com.praktikum.data.Item; // Changed from models to data
import com.praktikum.users.Mahasiswa;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.DataStore;

public class MahasiswaDashboard extends VBox {
    private TextField itemNameField;
    private TextField descField;
    private TextField locationField;
    private TableView<Item> itemsTable;
    private Button reportButton;
    private Button logoutButton;
    public MahasiswaDashboard(Mahasiswa mahasiswa) {
        setPadding(new Insets(10));
        setSpacing(10);

        // Welcome message
        Label welcomeLabel = new Label("Selamat datang, Mahasiswa");
        welcomeLabel.setStyle("-fx-font-size: 14px;");

        // Report section
        Label laporanLabel = new Label("Laporkan Barang Hilang/Temuan");

        // Input area with horizontal layout
        HBox inputBox = new HBox(10);
        itemNameField = new TextField();
        itemNameField.setPromptText("Dompet");
        itemNameField.setPrefWidth(150);

        descField = new TextField();
        descField.setPromptText("Deskripsi barang");
        descField.setPrefWidth(200);

        locationField = new TextField();
        locationField.setPromptText("Meja B-19");
        locationField.setPrefWidth(150);

        reportButton = new Button("Laporkan");
        reportButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        inputBox.getChildren().addAll(itemNameField, descField, locationField, reportButton);

        // Table section
        Label daftarLabel = new Label("Daftar Laporan Anda");
        itemsTable = new TableView<>();
        setupTable();

        // Logout at bottom
        logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

        getChildren().addAll(welcomeLabel, laporanLabel, inputBox,
                daftarLabel, itemsTable, logoutButton);

        setupEventHandlers();
    }

    @SuppressWarnings("unchecked")
    private void setupTable() {
        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));

        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        descCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");
        locCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocation()));

        itemsTable.getColumns().addAll(nameCol, descCol, locCol);
        refreshTable();
    }

    private void refreshTable() {
        itemsTable.getItems().clear();
        for (Item item : DataStore.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                itemsTable.getItems().add(item);
            }
        }
    }

    private void setupEventHandlers() {
        reportButton.setOnAction(_ -> {
            String name = itemNameField.getText();
            String desc = descField.getText();
            String location = locationField.getText();
            if (!name.isEmpty() && !location.isEmpty()) {
                Item item = new Item(name, desc, location, "Reported");
                DataStore.reportedItems.add(item);
                refreshTable();
                itemNameField.clear();
                descField.clear();
                locationField.clear();
            }
        });

        logoutButton.setOnAction(_ -> {
            Scene scene = getScene();
            scene.setRoot(new LoginPane(new LoginSystem()));
        });
    }
}
