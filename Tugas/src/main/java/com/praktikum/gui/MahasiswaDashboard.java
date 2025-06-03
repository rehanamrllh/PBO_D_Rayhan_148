package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.property.SimpleStringProperty;
import main.java.com.praktikum.data.Item;
import main.java.com.praktikum.users.Mahasiswa;
import main.java.com.praktikum.main.LoginSystem;
import main.java.com.praktikum.data.DataStore;

public class MahasiswaDashboard extends VBox {
    private TextField itemNameField;
    private TextField descField;
    private TextField locationField;
    private TableView<Item> itemsTable;
    private Button reportButton;
    private Button logoutButton;

    public MahasiswaDashboard(Mahasiswa mahasiswa) {
        setPadding(new Insets(15)); 
        setSpacing(10);

        Label welcomeLabel = new Label("Selamat datang, " + mahasiswa.getNama());
        welcomeLabel.setStyle("-fx-font-size: 22px;");
        welcomeLabel.setPadding(new Insets(0, 0, 5, 8)); 

        Label laporanLabel = new Label("Laporkan Barang Hilang/Temuan");
        laporanLabel.setStyle("-fx-font-size: 18px;");
        laporanLabel.setPadding(new Insets(0, 0, 0, 8)); 

        HBox inputBox = new HBox(16);
        inputBox.setPadding(new Insets(0, 0, 0, 8)); 

        itemNameField = new TextField();
        itemNameField.setPromptText("Nama barang");
        itemNameField.setPrefWidth(200);
        itemNameField.setStyle("-fx-font-size: 16px;");

        descField = new TextField();
        descField.setPromptText("Deskripsi barang");
        descField.setPrefWidth(260);
        descField.setStyle("-fx-font-size: 16px;");

        locationField = new TextField();
        locationField.setPromptText("Lokasi barang");
        locationField.setPrefWidth(180);
        locationField.setStyle("-fx-font-size: 16px;");

        reportButton = new Button("Laporkan");
        reportButton.setStyle("-fx-font-size: 16px;");
        reportButton.setPrefHeight(40);
        reportButton.setPrefWidth(140);
        

        Label daftarLabel = new Label("Daftar Laporan Anda");
        daftarLabel.setStyle("-fx-font-size: 18px;");
        daftarLabel.setPadding(new Insets(5, 0, 5, 8)); 

        itemsTable = new TableView<>();
        itemsTable.setPrefHeight(500);
        VBox.setVgrow(itemsTable, Priority.ALWAYS);
        itemsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        HBox.setHgrow(itemsTable, Priority.ALWAYS);

        setupTable();

        logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-font-size: 18px;");
        logoutButton.setPrefHeight(45);
        logoutButton.setPrefWidth(220);

        getChildren().addAll(welcomeLabel, laporanLabel, inputBox, daftarLabel, itemsTable, logoutButton);

        setupEventHandlers();
    }

    @SuppressWarnings("unchecked")
    private void setupTable() {
        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));
        nameCol.setStyle("-fx-font-size: 16px;");
        nameCol.prefWidthProperty().bind(itemsTable.widthProperty().multiply(0.3));

        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        descCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));
        descCol.setStyle("-fx-font-size: 16px;");
        descCol.prefWidthProperty().bind(itemsTable.widthProperty().multiply(0.4));

        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");
        locCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocation()));
        locCol.setStyle("-fx-font-size: 16px;");
        locCol.prefWidthProperty().bind(itemsTable.widthProperty().multiply(0.3));

        itemsTable.getColumns().addAll(nameCol, descCol, locCol);
        refreshTable();
    }

    private void refreshTable() {
        itemsTable.getItems().clear();
        DataStore.reportedItems.stream()
                .filter(item -> "Reported".equals(item.getStatus()))
                .distinct() // Memastikan tidak ada duplikat
                .forEach(item -> itemsTable.getItems().add(item));
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
            scene.getWindow().setWidth(1200);
            scene.getWindow().setHeight(800);
        });
    }
}
