class ManagementEvent {
    String eventName;
    String eventDate;
    String eventLocation;
    ManagementEvent next; 

    public ManagementEvent(String eventName, String eventDate, String eventLocation) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.next = null;
    }
    class EventLinkedList {
        private ManagementEvent head;
    
        public EventLinkedList() {
            this.head = null;
        }
    
        public void addEvent(String eventName, String eventDate, String eventLocation) {
            ManagementEvent newNode = new ManagementEvent(eventName, eventDate, eventLocation);
            if (head == null) {
                head = newNode;
            } else {
                ManagementEvent current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Event berhasil ditambahkan!");
        }
    
        public void displayEvents() {
            if (head == null) {
                System.out.println("Tidak ada event yang tersedia.");
                return;
            }
            ManagementEvent current = head;
            System.out.println("\nDaftar Event:");
            while (current != null) {
                System.out.println("- " + current.eventName + " | " + current.eventDate + " | " + current.eventLocation);
                current = current.next;
            }
        }
    
        public void deleteEvent(String eventName) {
            if (head == null) {
                System.out.println("Tidak ada event untuk dihapus.");
                return;
            }
    
            if (head.eventName.equals(eventName)) {
                head = head.next;
                System.out.println("Event \"" + eventName + "\" berhasil dihapus.");
                return;
            }
    
            ManagementEvent current = head;
            while (current.next != null && !current.next.eventName.equals(eventName)) {
                current = current.next;
            }
    
            if (current.next == null) {
                System.out.println("Event \"" + eventName + "\" tidak ditemukan.");
            } else {
                current.next = current.next.next;
                System.out.println("Event \"" + eventName + "\" berhasil dihapus.");
            }
        }
    
        public void editEvent(String eventName, String newDate, String newLocation) {
            if (head == null) {
                System.out.println("Tidak ada event untuk diedit.");
                return;
            }
    
            ManagementEvent current = head;
            while (current != null && !current.eventName.equals(eventName)) {
                current = current.next;
            }
    
            if (current == null) {
                System.out.println("Event \"" + eventName + "\" tidak ditemukan.");
            } else {
                current.eventDate = newDate;
                current.eventLocation = newLocation;
                System.out.println("Event \"" + eventName + "\" berhasil diedit.");
            }
        }
    }
    
}