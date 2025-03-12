public class Mahasiswa {
    private final String validNama = "Rayhan Amrullah";
    private final String validNim = "202410370110148";

    public void login(String inputNama, String inputNim) {
        if (validNama.equals(inputNama) && validNim.equals(inputNim)) {
            System.out.println("Login Mahasiswa berhasil!");
        } else {
            System.out.println("Nama atau NIM salah!");
        }
    }
}