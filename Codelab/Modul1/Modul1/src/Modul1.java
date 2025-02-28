import java.time.LocalDate;
import java.util.Scanner;

public class Modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt();

        scanner.close();

        LocalDate sekarang = LocalDate.now();
        int umur = sekarang.getYear() - tahunLahir;

        String jenisKelaminStr;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') {
            jenisKelaminStr = "Laki-laki";
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            jenisKelaminStr = "Perempuan";
        } else {
            jenisKelaminStr = "Tidak Valid";
        }
        
        System.out.println("\nData Diri:");
        System.out.println("Nama    : " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminStr);
        System.out.println("Umur    : " + umur + " tahun");

    }
}