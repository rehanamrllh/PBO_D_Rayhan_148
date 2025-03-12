import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data admin dan mahasiswa yang valid
        Admin admin = new Admin("admin", "admin123");
        Mahasiswa mahasiswa = new Mahasiswa("John Doe", "12345678");

        // Menu login
        System.out.println("Selamat datang di Sistem Login");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        switch (pilihan) {
            case 1:
                // Login sebagai Admin
                System.out.print("Masukkan username: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String inputPassword = scanner.nextLine();
                admin.login(inputUsername, inputPassword); // Memanggil metode login Admin
                break;

            case 2:
                // Login sebagai Mahasiswa
                System.out.print("Masukkan nama: ");
                String inputNama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = scanner.nextLine();
                mahasiswa.login(inputNama, inputNim); // Memanggil metode login Mahasiswa
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}