package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin148", "ADM001", "admin148", "admin148");
        Mahasiswa mahasiswa = new Mahasiswa("Rayhan Amrullah", "202410370110148");

        System.out.println("== SISTEM LOGIN ==");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih jenis login (1/2): ");

        String pilihan = scanner.nextLine();
        User user = null;

        switch (pilihan) {
            case "1" -> {
                System.out.print("\nUsername: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    user = admin;
                } else {
                    System.out.println("\nUsername atau password salah!");
                }
            }
            case "2" -> {
                System.out.print("\nNama: ");
                String nama = scanner.nextLine();
                System.out.print("NIM: ");
                String nim = scanner.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    user = mahasiswa;
                } else {
                    System.out.println("\nNama atau NIM salah!");
                }
            }
            default -> System.out.println("\nPilihan tidak valid!");
        }

        if (user != null) {
            user.displayAppMenu();
        }

        scanner.close();
    }
}