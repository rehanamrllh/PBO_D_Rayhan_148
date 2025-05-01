class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("\nLogin Mahasiswa Berhasil!");
        System.out.println("Selamat datang, " + getNama() + "!");
        System.out.println("NIM Anda: " + getNim());
    }
}

