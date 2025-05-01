package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Harry Potter and the Philosopher's Stone", "\tJ. K. Rowling", "Fantasy");

        buku1.displayInfo();
        buku2.displayInfo();

        Anggota anggota1 = new Anggota("Rayhan Amrullah", "148");
        Anggota anggota2 = new Anggota("Daffa Ichsanudin", "158");

        anggota1.displayInfo();
        anggota2.displayInfo();

        anggota1.pinjamBuku("Madilog", 5);
        anggota2.pinjamBuku("Harry Potter and the Philosopher's Stone", 10);

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Harry Potter and the Philosopher's Stone");
    }
}