package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.property.SimpleStringProperty;
import com.praktikum.data.Item; // Change from models to data
import com.praktikum.users.*;
import com.praktikum.main.LoginSystem;
import javafx.geometry.Orientation;
import com.praktikum.data.DataStore;

public class AdminDashboard extends VBox {
    private TableView<Item> itemsTable;
    private TableView<Mahasiswa> mahasiswaTable;
    private TextField namaMhsField, nimField;
    private Button addMhsButton, deleteMhsButton, markAsFoundButton, logoutButton;
    public AdminDashboard(Admin admin) {
        setPadding(new Insets(10));
        setSpacing(10);

        // Welcome message
        Label welcomeLabel = new Label("Halo, Administrator " + admin.getNama());
        welcomeLabel.setStyle("-fx-font-size: 14px;");

        // Create split pane
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);

        // Left side - Items
        VBox leftPane = new VBox(10);
        leftPane.setPadding(new Insets(5));

        Label laporanLabel = new Label("Laporan Barang");
        laporanLabel.setStyle("-fx-font-weight: bold");

        itemsTable = new TableView<>();
        setupItemsTable();

        markAsFoundButton = new Button("Tandai Claimed");

        leftPane.getChildren().addAll(laporanLabel, itemsTable, markAsFoundButton);

        // Right side - Student Data
        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(5));

        Label mahasiswaLabel = new Label("Data Mahasiswa");
        mahasiswaLabel.setStyle("-fx-font-weight: bold");

        mahasiswaTable = new TableView<>();
        setupMahasiswaTable();

        // Student management controls
        HBox inputBox = new HBox(5);
        namaMhsField = new TextField();
        namaMhsField.setPromptText("Nama Mahasiswa");
        nimField = new TextField();
        nimField.setPromptText("NIM");
        addMhsButton = new Button("Tambah");
        deleteMhsButton = new Button("Hapus");
        inputBox.getChildren().addAll(namaMhsField, nimField, addMhsButton, deleteMhsButton);

        rightPane.getChildren().addAll(mahasiswaLabel, mahasiswaTable, inputBox);

        // Add panes to split pane
        splitPane.getItems().addAll(leftPane, rightPane);

        // Logout button
        logoutButton = new Button("Logout");

        getChildren().addAll(welcomeLabel, splitPane, logoutButton);

        setupEventHandlers();
    }

    @SuppressWarnings("unchecked")
    private void setupItemsTable() {
        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");
        TableColumn<Item, String> statusCol = new TableColumn<>("Status");

        nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));
        descCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));
        locCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocation()));
        statusCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        itemsTable.getColumns().addAll(nameCol, descCol, locCol, statusCol);
        refreshItemsTable();
    }

    @SuppressWarnings("unchecked")
    private void setupMahasiswaTable() {
        TableColumn<Mahasiswa, String> namaCol = new TableColumn<>("Nama");
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");

        namaCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        nimCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNim()));

        mahasiswaTable.getColumns().addAll(namaCol, nimCol);
        refreshMahasiswaTable();
    }

    private void refreshItemsTable() {
        itemsTable.getItems().clear();
        for (Item item : DataStore.reportedItems) {
            itemsTable.getItems().add(item);
        }
    }

    private void refreshMahasiswaTable() {
        mahasiswaTable.getItems().clear();
        for (User user : DataStore.userList) {
            if (user instanceof Mahasiswa) {
                mahasiswaTable.getItems().add((Mahasiswa) user);
            }
        }
    }

    private void setupEventHandlers() {
        markAsFoundButton.setOnAction(_ -> {
            Item selected = itemsTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Claimed");
                refreshItemsTable();
            }
        });

        addMhsButton.setOnAction(_ -> {
            String nama = namaMhsField.getText();
            String nim = nimField.getText();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                DataStore.userList.add(new Mahasiswa(nama, nim));
                refreshMahasiswaTable();
                namaMhsField.clear();
                nimField.clear();
            }
        });

        deleteMhsButton.setOnAction(_ -> {
            Mahasiswa selected = mahasiswaTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                DataStore.userList.remove(selected);
                refreshMahasiswaTable();
            }
        });

        logoutButton.setOnAction(_ -> {
            Scene scene = getScene();
            scene.setRoot(new LoginPane(new LoginSystem()));
        });
    }
}
