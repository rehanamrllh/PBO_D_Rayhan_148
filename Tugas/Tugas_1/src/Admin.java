class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("\nLogin Admin Berhasil!");
        System.out.println("Selamat datang, " + getNama() + "!");
        System.out.println("Password Anda: " + password);
    }
}

