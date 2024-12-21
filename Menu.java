public class Menu {
    private String role;
    public Menu(String role) {
        this.role = role;
    }

    public void showMenu() throws Exception {
        int choice;
        do {
            if (role.equalsIgnoreCase("admin")) {
                System.out.println("\n=== MENU ADMIN ===");
                System.out.println("1. Tambah event");
                System.out.println("2. Edit event");
                System.out.println("3. Hapus event");
                System.out.println("4. Logout");
            } else {
                System.out.println("\n=== MENU USER ===");
                System.out.println("1. Cari event");
                System.out.println("2. Pesan tiket event");
                System.out.println("3. Logout");
            }
            System.out.print("Pilih menu: ");
            choice = Integer.parseInt(readInput());

            if (role.equalsIgnoreCase("admin")) {
                handleAdminChoice(choice);
            } else {
                handleUserChoice(choice);
            }
        } while (!isLogout(choice));
    }

    private void handleAdminChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Fitur 'Tambah event' dipilih.");
                break;
            case 2:
                System.out.println("Fitur 'Edit event' dipilih.");
                break;
            case 3:
                System.out.println("Fitur 'Hapus event' dipilih.");
                break;
            case 4:
                System.out.println("Logout berhasil.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Fitur 'Cari event' dipilih.");
                break;
            case 2:
                System.out.println("Fitur 'Pesan tiket event' dipilih.");
                break;
            case 3:
                System.out.println("Logout berhasil.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private boolean isLogout(int choice) {
        return (role.equalsIgnoreCase("admin") && choice == 4) ||
               (role.equalsIgnoreCase("user") && choice == 3);
    }

    public static String readInput() throws Exception {
        StringBuilder input = new StringBuilder();
        int ch;
        while ((ch = System.in.read()) != '\n') {
            if (ch != '\r') {
                input.append((char) ch);
            }
        }
        return input.toString();
    }
}