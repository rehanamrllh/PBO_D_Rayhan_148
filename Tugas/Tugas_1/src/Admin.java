public class Admin extends User {
    private String username;
    private String password;
    private final String validUsername = "admin148";
    private final String validPassword = "password148";

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        if (!validUsername.equals(inputUsername) || !validPassword.equals(inputPassword)) {
            System.out.println("Login Gagal: Username atau Password salah!");
            return false;
        }
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nLogin Admin Berhasil!");
        System.out.println("\nInformasi Admin:");
        System.out.println("Username: " + validUsername);
        System.out.println("Password: " + validPassword);
    }
}