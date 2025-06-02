package main.java.com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.property.SimpleStringProperty;
import main.java.com.praktikum.data.Item;
import main.java.com.praktikum.users.*;
import main.java.com.praktikum.main.LoginSystem;
import main.java.com.praktikum.data.DataStore;

public class AdminDashboard extends VBox {
    private TableView<Item> itemsTable;
    private TableView<Mahasiswa> mahasiswaTable;
    private TextField namaMhsField, nimField;
    private Button addMhsButton, deleteMhsButton, markAsFoundButton, logoutButton;

    public AdminDashboard(Admin admin) {
        setPadding(new Insets(15)); 
        setSpacing(10);

        Label welcomeLabel = new Label("Halo, Administrator ");
        welcomeLabel.setStyle("-fx-font-size: 20px;");
        welcomeLabel.setPadding(new Insets(0, 0, 5, 8)); 

        VBox leftPane = new VBox(10);
        leftPane.setPadding(new Insets(8)); 
        HBox.setHgrow(leftPane, Priority.ALWAYS); 

        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(8));
        HBox.setHgrow(rightPane, Priority.ALWAYS); 

        HBox mainContentLayout = new HBox(15); 
        mainContentLayout.getChildren().addAll(leftPane, rightPane);
        VBox.setVgrow(mainContentLayout, Priority.ALWAYS);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        leftPane.prefWidthProperty().bind(mainContentLayout.widthProperty().multiply(0.47));
        rightPane.prefWidthProperty().bind(mainContentLayout.widthProperty().multiply(0.47));

        Label laporanLabel = new Label("Laporan Barang");
        laporanLabel.setStyle("-fx-font-size: 18px;");
        
        itemsTable = new TableView<>();
        itemsTable.setPrefHeight(500);
        itemsTable.setMinWidth(200);
        itemsTable.prefWidthProperty().bind(leftPane.widthProperty());
        VBox.setVgrow(itemsTable, Priority.ALWAYS); // Make table fill vertical space
        itemsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN); // Make columns fill
        setupItemsTable();

        markAsFoundButton = new Button("Tandai Claimed");
        markAsFoundButton.setStyle("-fx-font-size: 16px; ");
        markAsFoundButton.setPrefHeight(40);
        markAsFoundButton.setPrefWidth(200);

        leftPane.getChildren().addAll(laporanLabel, itemsTable, markAsFoundButton);

        Label mahasiswaLabel = new Label("Data Mahasiswa");
        mahasiswaLabel.setStyle("-fx-font-size: 18px; ");

        mahasiswaTable = new TableView<>();
        mahasiswaTable.setPrefHeight(500);
        mahasiswaTable.setMinWidth(200);
        mahasiswaTable.prefWidthProperty().bind(rightPane.widthProperty());
        VBox.setVgrow(mahasiswaTable, Priority.ALWAYS); 
        mahasiswaTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN); 
        setupMahasiswaTable();

        HBox inputBox = new HBox(10);
        namaMhsField = new TextField();
        namaMhsField.setPromptText("Nama Mahasiswa");
        namaMhsField.setPrefWidth(200);
        namaMhsField.setStyle("-fx-font-size: 16px;");
        nimField = new TextField();
        nimField.setPromptText("NIM");
        nimField.setPrefWidth(150);
        nimField.setStyle("-fx-font-size: 16px;");
        addMhsButton = new Button("Tambah");
        addMhsButton.setStyle("-fx-font-size: 16px; ");
        addMhsButton.setPrefHeight(40);
        addMhsButton.setPrefWidth(120);
        deleteMhsButton = new Button("Hapus");
        deleteMhsButton.setStyle("-fx-font-size: 16px; ");
        deleteMhsButton.setPrefHeight(40);
        deleteMhsButton.setPrefWidth(120);
        inputBox.getChildren().addAll(namaMhsField, nimField, addMhsButton, deleteMhsButton);

        rightPane.getChildren().addAll(mahasiswaLabel, mahasiswaTable, inputBox);

        logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-font-size: 18px; ");
        logoutButton.setPrefHeight(45);
        logoutButton.setPrefWidth(220);
        logoutButton.setPadding(new Insets(0, 0, 0, 5)); 

        HBox logoutBox = new HBox(logoutButton);
        logoutBox.setPadding(new Insets(5, 0, 0, 8)); 

        getChildren().addAll(welcomeLabel, mainContentLayout, logoutBox);

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

        nameCol.setStyle("-fx-font-size: 16px;");
        descCol.setStyle("-fx-font-size: 16px;");
        locCol.setStyle("-fx-font-size: 16px;");
        statusCol.setStyle("-fx-font-size: 16px;");

        itemsTable.getColumns().addAll(nameCol, descCol, locCol, statusCol);
        refreshItemsTable();
    }

    @SuppressWarnings("unchecked")
    private void setupMahasiswaTable() {
        TableColumn<Mahasiswa, String> namaCol = new TableColumn<>("Nama");
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");

        namaCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        nimCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNim()));

        namaCol.setStyle("-fx-font-size: 16px;");
        nimCol.setStyle("-fx-font-size: 16px;");

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
            scene.getWindow().setWidth(1200);
            scene.getWindow().setHeight(800);
        });
    }
}
