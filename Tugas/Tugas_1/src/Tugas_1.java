import java.util.Scanner; // Import Scanner untuk input user

public class Tugas_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input

        // Menampilkan menu pilihan login
        System.out.println("Pilih Jenis Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int pilihan = scanner.nextInt(); // Input plihan 1 atau 2


        if (pilihan == 1) { // Jika user memilih no1
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine(); // Input username admin
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine(); // Input password admin

            
            String usernameValid = "Admin148"; // Username yang valid untuk admin
            String passwordValid = "Password148"; // Password yang valid untuk admin

            // Mengecek apakah username dan password sesuai
            if (username.equals(usernameValid) && password.equals(passwordValid)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) { // Jika user memilih no2
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine(); // Input nama mahasiswa
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine(); // Input NIM mahasiswa

            String namaValid = "Rayhan Amrullah"; // Nama yang valid untuk mahasiswa
            String nimValid = "202410370110148"; // NIM yang valid untuk mahasiswa

            // Mengecek apakah nama dan NIM sesuai
            if (nama.equals(namaValid) && nim.equals(nimValid)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid."); // Jika input pilihan bukan 1 atau 2 maka tidak valid
        }

        scanner.close(); // Menutup Scanner
    }
}