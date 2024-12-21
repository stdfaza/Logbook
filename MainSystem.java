import java.util.*;

class Event {
    String name;
    String date;
    String location;
    String artists;
    int popularity;
    Event next;

    public Event(String name, String date, String location, String artists, int popularity) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.artists = artists;
        this.popularity = popularity;
        this.next = null;
    }
}

class EventLinkedList {
    private Event head;

    public void addEvent(String name, String date, String location, String artists, int popularity) {
        Event newEvent = new Event(name, date, location, artists, popularity);
        if (head == null) {
            head = newEvent;
        } else {
            Event current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEvent;
        }
    }

    public void displayEvents() {
        if (head == null) {
            System.out.println("Tidak ada event yang tersedia.");
            return;
        }
        Event current = head;
        System.out.println("Daftar Event:");
        while (current != null) {
            System.out.println(current.name + " | " + current.date + " | " + current.location + " | Artis: " + current.artists);
            current = current.next;
        }
    }

    public void sortEventsByName() {
        if (head == null || head.next == null) {
            return;
        }
        Event current;
        boolean swapped;
        do {
            swapped = false;
            current = head;
            while (current.next != null) {
                if (current.name.compareToIgnoreCase(current.next.name) > 0) {
                    // Swap
                    String tempName = current.name;
                    String tempDate = current.date;
                    String tempLocation = current.location;
                    String tempArtists = current.artists;
                    int tempPopularity = current.popularity;

                    current.name = current.next.name;
                    current.date = current.next.date;
                    current.location = current.next.location;
                    current.artists = current.next.artists;
                    current.popularity = current.next.popularity;

                    current.next.name = tempName;
                    current.next.date = tempDate;
                    current.next.location = tempLocation;
                    current.next.artists = tempArtists;
                    current.next.popularity = tempPopularity;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public Event searchEventByName(String name) {
        Event current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Event getMostPopularEvent() {
        if (head == null) {
            return null;
        }
        Event mostPopular = head;
        Event current = head.next;
        while (current != null) {
            if (current.popularity > mostPopular.popularity) {
                mostPopular = current;
            }
            current = current.next;
        }
        return mostPopular;
    }
}

class EventTree {
    static class TreeNode {
        String name;
        String date;
        String location;
        String artists;
        TreeNode left;
        TreeNode right;

        public TreeNode(String name, String date, String location, String artists) {
            this.name = name;
            this.date = date;
            this.location = location;
            this.artists = artists;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public void addSubEvent(String mainEvent, String subEvent, String date, String location, String artists) {
        if (root == null) {
            root = new TreeNode(mainEvent, "", "", "");
            root.left = new TreeNode(subEvent, date, location, artists);
        } else {
            TreeNode mainNode = search(root, mainEvent);
            if (mainNode != null) {
                if (mainNode.left == null) {
                    mainNode.left = new TreeNode(subEvent, date, location, artists);
                } else if (mainNode.right == null) {
                    mainNode.right = new TreeNode(subEvent, date, location, artists);
                } else {
                    System.out.println("Sub-event tidak bisa ditambahkan, slot penuh.");
                }
            } else {
                System.out.println("Main event tidak ditemukan.");
            }
        }
    }

    private TreeNode search(TreeNode node, String name) {
        if (node == null || node.name.equals(name)) {
            return node;
        }
        TreeNode leftSearch = search(node.left, name);
        return (leftSearch != null) ? leftSearch : search(node.right, name);
    }

    public void displayHierarchy(TreeNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.name + " | " + node.date + " | " + node.location + " | Artis/Pemateri: " + node.artists);
            displayHierarchy(node.left, indent + "    ");
            displayHierarchy(node.right, indent + "    ");
        }
    }
    

    public void displayTree() {
        if (root == null) {
            System.out.println("Event tree kosong.");
        } else {
            displayHierarchy(root, "");
        }
    }
}

class TicketQueue {
    private Queue<String> queue;

    public TicketQueue() {
        queue = new LinkedList<>();
    }

    public void addBooking(String userName, String eventName) {
        queue.offer(userName + " - " + eventName);
        System.out.println("Booking berhasil untuk: " + userName + " pada event: " + eventName);
    }

    public void displayAllBookings() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada booking dalam antrean.");
        } else {
            System.out.println("Daftar antrean booking:");
            for (String booking : queue) {
                System.out.println(booking);
            }
        }
    }
}

class User {
    String username;
    String password;
    boolean isAdmin;
    User next;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.next = null;
    }
}

class UserLinkedList {
    private User head;

    public void register(String username, String password, boolean isAdmin) {
        if (searchUser(username) != null) {
            System.out.println("Username sudah terdaftar.");
            return;
        }
        User newUser = new User(username, password, isAdmin);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("Registrasi berhasil!");
    }

    public User login(String username, String password) {
        User user = searchUser(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login berhasil! Selamat datang, " + username);
            return user;
        } else {
            System.out.println("Login gagal! Username atau password salah.");
            return null;
        }
    }

    private User searchUser(String username) {
        User current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}


public class MainSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventLinkedList eventList = new EventLinkedList();
        EventTree eventTree = new EventTree();
        TicketQueue ticketQueue = new TicketQueue();
        UserLinkedList userList = new UserLinkedList();

        userList.register("admin", "admin123", true);   
        
        while (true) {
            System.out.print("\033c");
            System.out.println("\nMenu:");
            System.out.println("1. Login");
            System.out.println("2. Register Akun");
            System.out.println("3. Exit");
            System.out.print(">> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("\033c");
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                User loggedInUser = userList.login(username, password);
                if (loggedInUser != null) {
                    if (loggedInUser.isAdmin) {
                        adminMenu(scanner, eventList, eventTree);
                    } else {
                        userMenu(scanner, eventList, ticketQueue);
                    }
                }
                break;
            case 2:
            System.out.print("\033c");
                System.out.print("Masukkan username baru: ");
                String newUsername = scanner.nextLine();
                System.out.print("Masukkan password baru: ");
                String newPassword = scanner.nextLine();          
                boolean isAdmin = false;
                userList.register(newUsername, newPassword, isAdmin);
                break;
            case 3:
                System.out.println("Terima kasih, sampai jumpa!");
                return;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }
}
 

    private static void adminMenu(Scanner scanner, EventLinkedList eventList, EventTree eventTree) {
        while (true) {
            System.out.print("\033c");
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tambah Event");
            System.out.println("2. Edit Event");
            System.out.println("3. Hapus Event");
            System.out.println("4. Lihat Event");
            System.out.println("5. Logout");
            System.out.print(">> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\033c");
                    System.out.println("Pilih jenis event:");
                    System.out.println("1. Konser");
                    System.out.println("2. Seminar");
                    System.out.println("3. Workshop");
                    System.out.print(">> ");
                    int eventType = scanner.nextInt();
                    scanner.nextLine();

                    switch (eventType) {
                        case 1: // Konser
                            System.out.print("\033c");
                            System.out.print("Masukkan nama event: ");
                            String concertName = scanner.nextLine();
                            System.out.print("Masukkan lokasi event: ");
                            String concertLocation = scanner.nextLine();
                            System.out.print("Masukkan hari, tanggal event: ");
                            String concertDate = scanner.nextLine();
                            System.out.print("Masukkan artis: ");
                            String concertArtists = scanner.nextLine();
                            System.out.print("Masukkan popularitas (angka): ");
                            int concertPopularity = scanner.nextInt();
                            scanner.nextLine();
                            eventList.addEvent(concertName, concertDate, concertLocation, concertArtists, concertPopularity);
                            eventTree.addSubEvent("Konser", concertName, concertDate, concertLocation, concertArtists);
                            System.out.println("Event konser berhasil ditambahkan.");
                            break;
                        case 2: // Seminar
                            System.out.print("\033c");
                            System.out.print("Masukkan nama event: ");
                            String seminarName = scanner.nextLine();
                            System.out.print("Masukkan lokasi event: ");
                            String seminarLocation = scanner.nextLine();
                            System.out.print("Masukkan hari, tanggal event: ");
                            String seminarDate = scanner.nextLine();
                            System.out.print("Masukkan pemateri: ");
                            String seminarSpeakers = scanner.nextLine();
                            System.out.print("Masukkan popularitas (angka): ");
                            int seminarPopularity = scanner.nextInt();
                            scanner.nextLine();
                            eventList.addEvent(seminarName, seminarDate, seminarLocation, seminarSpeakers, seminarPopularity);
                            eventTree.addSubEvent("Seminar", seminarName, seminarDate, seminarLocation, seminarSpeakers);
                            System.out.println("Event seminar berhasil ditambahkan.");
                            break;
                        case 3: // Workshop
                            System.out.print("\033c");
                            System.out.print("Masukkan nama event: ");
                            String workshopName = scanner.nextLine();
                            System.out.print("Masukkan lokasi event: ");
                            String workshopLocation = scanner.nextLine();
                            System.out.print("Masukkan hari, tanggal event: ");
                            String workshopDate = scanner.nextLine();
                            System.out.print("Masukkan pemateri: ");
                            String workshopSpeakers = scanner.nextLine();
                            System.out.print("Masukkan popularitas (angka): ");
                            int workshopPopularity = scanner.nextInt();
                            scanner.nextLine();
                            eventList.addEvent(workshopName, workshopDate, workshopLocation, workshopSpeakers, workshopPopularity);
                            eventTree.addSubEvent("Workshop", workshopName, workshopDate, workshopLocation, workshopSpeakers);
                            System.out.println("Event workshop berhasil ditambahkan.");
                            break;
                        default:
                            System.out.println("Jenis event tidak valid.");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("\033c");
                    System.out.print("Masukkan nama event yang ingin diedit: ");
                    String editName = scanner.nextLine();
                    Event eventToEdit = eventList.searchEventByName(editName);
                    if (eventToEdit != null) {
                        System.out.print("Masukkan lokasi baru: ");
                        eventToEdit.location = scanner.nextLine();
                        System.out.print("Masukkan hari, tanggal baru: ");
                        eventToEdit.date = scanner.nextLine();
                        System.out.print("Masukkan artis baru: ");
                        eventToEdit.artists = scanner.nextLine();
                        System.out.println("Event berhasil diedit.");
                    } else {
                        System.out.println("Event tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("\033c");
                    System.out.print("Masukkan nama event yang ingin dihapus: ");
                    String deleteName = scanner.nextLine();
                    if (eventList.searchEventByName(deleteName) != null) {
                        eventList.searchEventByName(deleteName).popularity = 0;  // Optional cleanup
                        System.out.println("Event berhasil dihapus.");
                    } else {
                        System.out.println("Event tidak ditemukan.");
                    }
                    break;
                case 4:
                    eventTree.displayTree();
                    break;
                case 5:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void userMenu(Scanner scanner, EventLinkedList eventList, TicketQueue ticketQueue) {
        while (true) {
            System.out.print("\033c");
            System.out.println("\nMenu User:");
            System.out.println("1. Lihat Event");
            System.out.println("2. Cari Event");
            System.out.println("3. Rekomendasi Event");
            System.out.println("4. Tambah Booking Tiket");
            System.out.println("5. Lihat Semua Booking");
            System.out.println("6. Logout");
            System.out.print(">> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\033c"); 
                    eventList.sortEventsByName();
                    eventList.displayEvents();
                    break;
                case 2:
                    System.out.print("\033c");
                    System.out.print("Masukkan nama event yang dicari: ");
                    String searchName = scanner.nextLine();
                    Event foundEvent = eventList.searchEventByName(searchName);
                    if (foundEvent != null) {
                        System.out.println("Event ditemukan: " + foundEvent.name + " | " + foundEvent.date + " | " + foundEvent.location + " | Artis: " + foundEvent.artists);
                    } else {
                        System.out.println("Event tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("\033c");
                    Event popularEvent = eventList.getMostPopularEvent();
                    if (popularEvent != null) {
                        System.out.println("Event Paling Populer: " + popularEvent.name + " | " + popularEvent.date + " | " + popularEvent.location + " | Artis: " + popularEvent.artists);
                    } else {
                        System.out.println("Tidak ada event yang tersedia.");
                    }
                    break;
                case 4:
                    System.out.print("\033c");
                    eventList.displayEvents();
                    System.out.print("Pilih event yang ingin di-booking (masukkan nama event): ");
                    String eventName = scanner.nextLine();
                    Event selectedEvent = eventList.searchEventByName(eventName);
                    if (selectedEvent != null) {
                        System.out.print("Masukkan nama user untuk booking tiket: ");
                        String userName = scanner.nextLine();
                        ticketQueue.addBooking(userName, selectedEvent.name);
                    } else {
                        System.out.println("Event tidak ditemukan.");
                    }
                    break;
                case 5:
                    ticketQueue.displayAllBookings();
                    break;
                case 6:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
