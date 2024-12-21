public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("=== TAMPILAN MENU LOGIN ===");
            System.out.print("Masukkan username: ");
            String username = Menu.readInput();

            System.out.print("Masukkan password: ");
            String password = Menu.readInput();

            String role = username.equalsIgnoreCase("admin") ? "admin" : "user";

            Menu menu = new Menu(role);
            menu.showMenu();
        }
    }
}