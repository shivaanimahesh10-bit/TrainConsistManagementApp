import java.util.*;

// Room Domain Model
class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public void displayDetails() {
        System.out.println("Type: " + type);
        System.out.println("Price: ₹" + price);
        System.out.println("Amenities: " + amenities);
    }
}

// Inventory (State Holder)
class Inventory {
    private Map<String, Integer> availability;

    public Inventory() {
        availability = new HashMap<>();
    }

    // Initialize availability
    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    // Read-only access
    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    public Set<String> getRoomTypes() {
        return availability.keySet();
    }
}

// Search Service (Read-Only Logic)
class SearchService {
    private Inventory inventory;
    private Map<String, Room> roomCatalog;

    public SearchService(Inventory inventory, Map<String, Room> roomCatalog) {
        this.inventory = inventory;
        this.roomCatalog = roomCatalog;
    }

    // Search available rooms (READ-ONLY)
    public void searchAvailableRooms() {
        System.out.println("\n🔍 Available Rooms:");

        for (String type : inventory.getRoomTypes()) {

            int count = inventory.getAvailability(type);

            // Defensive Programming: filter invalid/unavailable
            if (count <= 0) {
                continue;
            }

            Room room = roomCatalog.get(type);

            if (room != null) {
                room.displayDetails();
                System.out.println("Available: " + count);
                System.out.println("----------------------");
            }
        }
    }
}

// Main Class
public class HotelAppUC_Search {
    public static void main(String[] args) {

        // Step 1: Setup Inventory
        Inventory inventory = new Inventory();
        inventory.setAvailability("Single", 5);
        inventory.setAvailability("Double", 0); // unavailable
        inventory.setAvailability("Suite", 2);

        // Step 2: Setup Room Catalog
        Map<String, Room> roomCatalog = new HashMap<>();
        roomCatalog.put("Single", new Room("Single", 2000, "WiFi, AC"));
        roomCatalog.put("Double", new Room("Double", 3500, "WiFi, AC, TV"));
        roomCatalog.put("Suite", new Room("Suite", 6000, "WiFi, AC, TV, Mini Bar"));

        // Step 3: Search Service
        SearchService searchService = new SearchService(inventory, roomCatalog);

        // Step 4: Guest searches rooms
        searchService.searchAvailableRooms();
    }
}