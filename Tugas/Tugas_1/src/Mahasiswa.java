import java.util.Scanner;

public class Mahasiswa {
    String namaMahasiswa= "Rayhan Amrullah";
    String nimMahasiswa = "202410370110148";
    String nama, nim;

    Scanner input = new Scanner(System.in);

    void login(){
        System.out.println("Masukkan Nama: ");
        nama = input.nextLine();
        System.out.println("Masukkan NIM: ");
        nim = input.nextLine();

        if (nama.equals(namaMahasiswa) && nim.equals(nimMahasiswa)) {
            System.out.println(":Login mahasiswa berhasil");
        } else {
            System.out.println("Login gagal! Nama atau NIM salah");
        }

    }
}
