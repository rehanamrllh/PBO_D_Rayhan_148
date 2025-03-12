public class Mahasiswa {
    private String nama;
    private String nim;

    // Constructor
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Metode untuk verifikasi login
    public void login(String inputNama, String inputNim) {
        if (this.nama.equals(inputNama) && this.nim.equals(inputNim)) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo(); // Menampilkan informasi mahasiswa setelah login berhasil
        } else {
            System.out.println("Nama atau NIM salah!");
        }
    }

    // Metode untuk menampilkan informasi mahasiswa
    private void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.nim);
    }
}