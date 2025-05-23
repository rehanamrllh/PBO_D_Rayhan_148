package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.models.Item;
import java.util.*;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        userList.add(new Admin("Rayhan Amrullah", "202410370110148", "admin148", "admin148"));
        userList.add(new Admin("Daffa Ichsanudin", "202410370110158", "admin158", "admin158"));

        userList.add(new Mahasiswa("Rayhan Amrullah", "202410370110148"));
        userList.add(new Mahasiswa("Daffa Ichsanudin", "202410370110158"));

        reportedItems.add(new Item("Laptop", "Laptop hilang di kampus", "Kampus", "Reported"));
        reportedItems.add(new Item("Buku", "Buku hilang di perpustakaan", "Perpustakaan", "Reported"));
        reportedItems.add(new Item("Kunci", "Kunci hilang di parkiran", "Parkiran", "Claimed"));

        User user = null;
        boolean keluar = false;
        while (user == null && !keluar) {
            System.out.println("== SISTEM LOGIN ==");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih jenis login (1/2): ");

            String pilihan = scanner.nextLine();

            try {
                switch (pilihan) {
                    case "0" -> {
                        keluar = true;
                        System.out.println("Terima kasih, program selesai.");
                        break;
                    }
                    case "1" -> {
                        System.out.print("\nUsername: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        user = cariUser(username, password, true);
                        if (user == null)
                            throw new LoginFailedException("Username atau password salah!\n");
                    }
                    case "2" -> {
                        System.out.print("\nNama: ");
                        String nama = scanner.nextLine();
                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();
                        user = cariUser(nama, nim, false);
                        if (user == null)
                            throw new LoginFailedException("Nama atau NIM salah!\n");
                    }
                    default -> throw new LoginFailedException("Pilihan tidak valid!\n");
                }
            } catch (LoginFailedException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input. Silakan coba lagi.");
            }
        }

        
        user.displayAppMenu();
        
        scanner.close();
    }

    public static User cariUser(String input1, String input2, boolean isAdmin) {
        for (User usr : userList) {
            if (isAdmin && usr instanceof Admin) {
                if (((Admin) usr).login(input1, input2))
                    return usr;
            } else if (!isAdmin && usr instanceof Mahasiswa) {
                if (((Mahasiswa) usr).login(input1, input2))
                    return usr;
            }
        }
        return null;
    }
}