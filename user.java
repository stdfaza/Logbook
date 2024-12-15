import java.util.Scanner;

public class user {
    private String SavedUsername = "";
    private String SavedPassword = "";

    public void register(Scanner scanner) {
        System.out.print("Masukkan username: ");
        SavedUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        SavedPassword = scanner.nextLine();
        System.out.println("Registrasi berhasil!");
    }

    public void login(Scanner scanner) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (username.equals(SavedUsername) && password.equals(SavedPassword)) {
            System.out.println("Login Berhasil!");
        } else {
            System.out.println("username atau password salah!");
        }
    }
}
