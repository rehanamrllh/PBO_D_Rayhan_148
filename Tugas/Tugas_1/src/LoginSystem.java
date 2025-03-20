import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 3) {
                System.out.println("Terima kasih telah menggunakan sistem login.");
                break;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    Admin admin = new Admin("Admin System", "ADMIN001", username, password);
                    if (admin.login(username, password)) {
                        admin.displayInfo();
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    Mahasiswa mahasiswa = new Mahasiswa(nama, nim);
                    if (mahasiswa.login(nama, nim)) {
                        mahasiswa.displayInfo();
                    }
                    break;

                default:
                    System.out.println("\nPilihan tidak valid! Silakan pilih 1-3.");
            }
        }

        scanner.close();
    }
}