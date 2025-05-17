package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private final Scanner scanner;
    int pilihan;

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayAppMenu() {
        do {
            System.out.println("\n== Menu Mahasiswa ==");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }
            switch (pilihan) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logout berhasil.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void reportItem() {
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();
        Item item = new Item(namaBarang, deskripsi, lokasi, "Reported");
        LoginSystem.reportedItems.add(item);
        System.out.println("Laporan berhasil dibuat untuk barang: " + namaBarang);
    }

    @Override
    public void viewReportedItems() {
        boolean ada = false;
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                ada = true;
                System.out.println(
                        "- " + item.getItemName() + " | " + item.getDescription() + " | Lokasi: " + item.getLocation());
            }
        }
        if (!ada) {
            System.out.println(">> Belum ada laporan barang. <<");
        }
    }
}