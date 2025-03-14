public class Main {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();
        Hewan hewan3 = new Hewan();
        Hewan hewan4 = new Hewan();
        Hewan hewan5 = new Hewan();

        hewan1.nama = "Kucing";
        hewan2.nama = "Anjing";
        hewan3.nama = "Ayam";
        hewan4.nama = "Buaya";
        hewan5.nama = "Bebek";

        hewan1.jenis = "Mamalia";
        hewan1.jenis = "Mamalia";
        hewan3.jenis = "Unggas";
        hewan4.jenis = "Reptil";
        hewan5.jenis = "Unggas";

        hewan1.suara = "Nyannn";
        hewan2.suara = "GukGukk";
        hewan3.suara = "Cukuryuk";
        hewan4.suara = "Kalo aku chat ada yang marah nggak";
        hewan5.suara = "Wek wekw wek"; 

        hewan1.tampilkaninfo();
        hewan2.tampilkaninfo();
        hewan3.tampilkaninfo();
        hewan4.tampilkaninfo();
        hewan5.tampilkaninfo();
    }
    
}
