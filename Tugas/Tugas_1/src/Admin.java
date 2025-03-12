import java.util.Scanner;

public class Admin {
    String usernameAdmin= "Admin148";
    String passwordAdmin = "Password148";
    String username, password;

    Scanner input = new Scanner(System.in);

    void login(){
        System.out.println("Masukkan Username: ");
        username = input.nextLine();
        System.out.println("Masukkan Password: ");
        password = input.nextLine();

        if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
            System.out.println(":Login admin berhasil");
        } else {
            System.out.println("Login gagal! Username atau Passwrod salah");
        }

    }
    
}
