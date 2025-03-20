public class Admin extends User {
    private String username;
    private String password;
    private static final String VALID_USERNAME = "admin148";
    private static final String VALID_PASSWORD = "password148";

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        if (!VALID_USERNAME.equals(inputUsername) || !VALID_PASSWORD.equals(inputPassword)) {
            System.out.println("Login Gagal: Username atau Password salah!");
            return false;
        }
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nLogin Admin Berhasil!");
        System.out.println("Informasi Admin:");
        System.out.println("Username: " + VALID_USERNAME);
        System.out.println("Password: " + VALID_PASSWORD);
    }
}