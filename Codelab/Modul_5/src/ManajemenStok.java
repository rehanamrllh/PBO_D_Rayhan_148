import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        // Data awal untuk pengujian
        daftarBarang.add(new Barang("Pensil", 50));
        daftarBarang.add(new Barang("Buku", 30));
        daftarBarang.add(new Barang("Penghapus", 20));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi;
            try {
                opsi = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Input opsi harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            if (opsi == 1) {
                // Tambah Barang Baru
                System.out.print("Masukkan nama barang: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan stok awal: ");
                try {
                    int stok = scanner.nextInt();
                    scanner.nextLine();
                    daftarBarang.add(new Barang(nama, stok));
                    System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                } catch (InputMismatchException e) {
                    System.out.println("Input stok harus berupa angka!");
                    scanner.nextLine();
                }
            } else if (opsi == 2) {
                // Tampilkan Semua Barang
                if (daftarBarang.isEmpty()) {
                    System.out.println("Stok barang kosong.");
                } else {
                    System.out.println("--- Daftar Barang ---");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                    }
                    System.out.println("----------------------");
                }
            } else if (opsi == 3) {
                // Kurangi Stok Barang
                if (daftarBarang.isEmpty()) {
                    System.out.println("Stok barang kosong.");
                    continue;
                }
                System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                for (int i = 0; i < daftarBarang.size(); i++) {
                    Barang b = daftarBarang.get(i);
                    System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                }
                System.out.print("Masukkan nomor indeks barang: ");
                try {
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    Barang barang = daftarBarang.get(idx);
                    if (barang.getStok() == 0) {
                        System.out.println("Stok barang '" + barang.getNama() + "' sudah habis.");
                        continue;
                    }
                    System.out.print("Masukkan jumlah stok yang akan diambil: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    if (jumlah > barang.getStok()) {
                        throw new StokTidakCukupException("Tidak bisa dikurangi karena stok untuk '" + barang.getNama()
                                + "' hanya tersisa " + barang.getStok());
                    }
                    barang.setStok(barang.getStok() - jumlah);
                    System.out.println("Stok barang '" + barang.getNama() + "' berhasil dikurangi. Sisa stok: "
                            + barang.getStok());
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka!");
                    scanner.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Nomor indeks barang tidak valid!");
                } catch (StokTidakCukupException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opsi == 0) {
                System.out.println("Terima kasih! Program berakhir.");
                break;
            } else {
                System.out.println("Opsi tidak valid!");
            }
            System.out.println();
        }
        scanner.close();
    }
}