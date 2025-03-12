public class Admin {
    private final String validUsername = "admin";
    private final String validPassword = "admin123";

    public void login(String inputUsername, String inputPassword) {
        if (validUsername.equals(inputUsername) && validPassword.equals(inputPassword)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Username atau password salah!");
        }
    }
}