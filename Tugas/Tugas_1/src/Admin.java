public class Admin {
    private String username;
    private String password;

    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metode untuk verifikasi login
    public void login(String inputUsername, String inputPassword) {
        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Username atau password salah!");
        }
    }
}