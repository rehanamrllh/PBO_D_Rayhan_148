package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;
    int pilihan;
    private Scanner scanner;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    @Override
    public void displayAppMenu() {
        do {
            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
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
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 0 -> System.out.println("Logout berhasil.");
                default -> {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageItems() {
        int pilihan = 0;
        do {
            System.out.println("\n== Kelola Laporan Barang ==");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
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
                case 1 -> {
                    if (LoginSystem.reportedItems.isEmpty()) {
                        System.out.println("Belum ada laporan barang.");
                    } else {
                        int idx = 0;
                        for (Item item : LoginSystem.reportedItems) {
                            System.out.println(idx++ + ". " + item.getItemName() + " | " + item.getDescription()
                            + " | Lokasi: " + item.getLocation() + " | Status: " + item.getStatus());
                        }
                    }
                }
                case 2 -> {
                    int idx = 0;
                    boolean ada = false;
                    System.out.println("\n== Daftar Laporan Barang ==");
                    for (Item item : LoginSystem.reportedItems) {
                        if ("Reported".equals(item.getStatus())) {
                            System.out.println(idx + ". " + item.getItemName() + " | " + item.getDescription()
                                    + " | Lokasi: " + item.getLocation());
                            ada = true;
                        }
                        idx++;
                    }
                    if (!ada) {
                        System.out.println("Tidak ada barang dengan status 'Reported'.");
                        break;
                    }
                    System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");
                    try {
                        int pilih = scanner.nextInt();
                        scanner.nextLine();
                        Item item = LoginSystem.reportedItems.get(pilih);
                        if ("Claimed".equals(item.getStatus())) {
                            System.out.println("Barang sudah di-claim.");
                        } else {
                            item.setStatus("Claimed");
                            System.out.println(
                                    "Barang '" + item.getItemName() + "' berhasil ditandai sebagai 'Claimed'.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Nomor indeks barang tidak valid!");
                    } catch (Exception e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    }
                }
                case 0 -> {
                }
                default -> {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageUsers() {
        int pilihan = 0;
        do {
            System.out.println("\n== Kelola Data Mahasiswa ==");
            System.out.println("1. Lihat daftar Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("0. Kembali");
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
                case 1 -> {
                    System.out.println("\n== Daftar Mahasiswa ==");
                    boolean ketemu = false;
                    for (User usr : LoginSystem.userList) {
                        if (usr instanceof Mahasiswa) {
                            System.out.println("- " + usr.getNama() + " | NIM: " + usr.getNim());
                            ketemu = true;
                        }
                    }
                    if (!ketemu) {
                        System.out.println("Belum ada data mahasiswa.");
                    }
                }
                case 2 -> {
                    System.out.print("Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();
                    LoginSystem.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                }
                case 3 -> {
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nim = scanner.nextLine();
                    boolean ketemu = false;
                    for (int i = 0; i < LoginSystem.userList.size(); i++) {
                        User usr = LoginSystem.userList.get(i);
                        if (usr instanceof Mahasiswa && usr.getNim().equals(nim)) {
                            LoginSystem.userList.remove(i);
                            System.out.println("Mahasiswa berhasil dihapus.");
                            ketemu = true;
                            break;
                        }
                    }
                    if (!ketemu) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                }
                case 0 -> {
                }
                default -> {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }
            }
        } while (pilihan != 0);
    }

}