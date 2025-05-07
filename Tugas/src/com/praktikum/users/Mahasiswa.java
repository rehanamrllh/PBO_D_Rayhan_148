package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private final Scanner scanner; // Declare a single Scanner instance

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
        this.scanner = new Scanner(System.in); // Initialize Scanner
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayAppMenu() {
        int pilihan;
        do {
            System.out.println("\n== Menu Mahasiswa ==");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
        System.out.println("Laporan berhasil dibuat untuk barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}