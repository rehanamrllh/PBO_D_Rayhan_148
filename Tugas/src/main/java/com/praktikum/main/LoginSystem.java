package main.java.com.praktikum.main;

import main.java.com.praktikum.users.*;
import main.java.com.praktikum.data.*;

public class LoginSystem {
    public LoginSystem() {
        initializeData();
    }

    private void initializeData() {
        DataStore.userList.add(new Admin("Rayhan Amrullah", "202410370110148", "admin148", "admin148"));
        DataStore.userList.add(new Admin("Daffa Ichsanudin", "202410370110158", "admin158", "admin158"));
        DataStore.userList.add(new Admin("", "", "a", "a"));
       
        DataStore.userList.add(new Mahasiswa("Rayhan Amrullah", "202410370110148"));
        DataStore.userList.add(new Mahasiswa("Daffa Ichsanudin", "202410370110158"));
        DataStore.userList.add(new Mahasiswa("Asep Kurniawan", "202410370110122"));
        DataStore.userList.add(new Mahasiswa("a", "a"));

        DataStore.reportedItems.add(new Item("Laptop", "Laptop hilang di kampus", "Kampus", "Reported"));
        DataStore.reportedItems.add(new Item("Buku", "Buku hilang di perpustakaan", "Perpustakaan", "Reported"));
        DataStore.reportedItems.add(new Item("Kunci", "Kunci hilang di parkiran", "Parkiran", "Claimed"));
        DataStore.reportedItems.add(new Item("Tas", "Tas hilang di kantin", "Kantin", "Reported"));
        DataStore.reportedItems.add(new Item("Handphone", "Handphone hilang di kelas", "Kelas", "Claimed"));
        DataStore.reportedItems.add(new Item("Jam Tangan", "Jam tangan hilang di ruang dosen", "Ruang Dosen", "Reported"));
        DataStore.reportedItems.add(new Item("Sepatu", "Sepatu hilang di lapangan", "Lapangan", "Reported"));
    }

    public static User cariUser(String input1, String input2, boolean isAdmin) {
        for (User usr : DataStore.userList) {
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