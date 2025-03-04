import java.time.LocalDate; // Mengimpor kelas LocalDate untuk mendapatkan informasi tanggal dan waktu
import java.util.Scanner; // Mengimpor Scanner untuk input dari user

public class Modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input dari user
        
        System.out.print("Masukkan nama: "); 
        String nama = scanner.nextLine(); // Meminta input nama dari user

        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0); // Meminta input jenis kelamin p/l dari user

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = scanner.nextInt(); // Meminta input tahun lahir dari user

        scanner.close(); // Menutup objek scanner setelah input selesai

        LocalDate sekarang = LocalDate.now(); // Mendapatkan tahun sekarang menggunakan LocalDate.now
        int umur = sekarang.getYear() - tahunLahir; // Menghitung umur berdasarkan tahun sekarang dan tahun lahir

        
        String jenisKelaminStr;
        if (jenisKelamin == 'L' || jenisKelamin == 'l') {
            jenisKelaminStr = "Laki-laki";  // Jika input L/l maka laki-laki
        } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
            jenisKelaminStr = "Perempuan"; // Jika input P/p maka perempuan
        } else {
            jenisKelaminStr = "Tidak Valid"; // Jika input selain P/p atau L/l maka maka tidak valid
        }

        // Menampilkan hasil input
        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis kelamin: " + jenisKelaminStr);
        System.out.println("Umur: " + umur + " tahun"); 
    }
}
