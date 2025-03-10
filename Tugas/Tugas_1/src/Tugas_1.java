import java.util.Scanner; 

public class Tugas_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Pilih Jenis Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int pilihan = scanner.nextInt(); 
        scanner.nextLine();

        if (pilihan == 1) { 
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine(); 
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine(); // Input password admin

            String usernameValid = "Admin148"; // Username yang valid untuk admin
            String passwordValid = "Password148"; // Password yang valid untuk admin

            if (username.equals(usernameValid) && password.equals(passwordValid)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) { 
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine(); 
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine(); 

            String namaValid = "Rayhan Amrullah"; 
            String nimValid = "202410370110148"; 

            if (nama.equals(namaValid) && nim.equals(nimValid)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak vali."); 
        }

        scanner.close(); 
    }
}