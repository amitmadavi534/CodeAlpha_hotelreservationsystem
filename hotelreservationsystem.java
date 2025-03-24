import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;
    String guestName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.guestName = "";
    }
}

class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();

    public Hotel(int totalRooms) {
        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void bookRoom(String guestName) {
        for (Room room : rooms) {
            if (!room.isBooked) {
                room.isBooked = true;
                room.guestName = guestName;
                System.out.println("Room " + room.roomNumber + " booked for " + guestName);
                return;
            }
        }
        System.out.println("No available rooms!");
    }

    public void displayBookings() {
        System.out.println("Room Bookings:");
        for (Room room : rooms) {
            if (room.isBooked) {
                System.out.println("Room " + room.roomNumber + " - Booked by " + room.guestName);
            } else {
                System.out.println("Room " + room.roomNumber + " - Available");
            }
        }
    }
}

public class hotelreservationsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(5); // Initialize with 5 rooms

        while (true) {
            System.out.println("\n1. Book a Room");
            System.out.println("2. View Bookings");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    hotel.bookRoom(name);
                    break;
                case 2:
                    hotel.displayBookings();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}