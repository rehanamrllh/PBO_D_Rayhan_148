public class Admin {
    private final String validUsername = "admin148";
    private final String validPassword = "password148";

    public void login(String inputUsername, String inputPassword) {
        if (validUsername.equals(inputUsername) && validPassword.equals(inputPassword)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Username atau password salah!");
        }
    }
}