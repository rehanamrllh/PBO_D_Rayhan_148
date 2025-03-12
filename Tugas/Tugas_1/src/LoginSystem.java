import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Selamat datang di Sistem Login");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String inputPassword = scanner.nextLine();
                admin.login(inputUsername, inputPassword); 
                break;

            case 2:
                System.out.print("Masukkan nama: ");
                String inputNama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = scanner.nextLine();
                mahasiswa.login(inputNama, inputNim);
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}