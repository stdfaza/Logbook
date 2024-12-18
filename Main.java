import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        user userManager = new user();
        
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                userManager.register(scanner);
            } else if (choice == 2) {
                userManager.login(scanner);
            } else if (choice == 3) {
                System.out.println("Selamat Tinggal!");
                break;
            } else {
                System.out.println("Pilihan anda salah!, Silahkan ulang input");
            }
        }
    }
}
