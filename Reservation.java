Public class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - $" + price + " - " + (isAvailable ? "Available" : "Booked");
    }
}
public class Guest {
    private String name;
    private String contactNumber;

    public Guest(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return name + " (" + contactNumber + ")";
    }
}
public class Reservation {
    private Room room;
    private Guest guest;
    private String reservationDate;

    public Reservation(Room room, Guest guest, String reservationDate) {
        this.room = room;
        this.guest = guest;
        this.reservationDate = reservationDate;
    }

    // Getters
    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation: " + guest.getName() + " - Room " + room.getRoomNumber() + " on " + reservationDate;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Add a room
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Book a room
    public void bookRoom(Guest guest, int roomNumber, String reservationDate) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                Reservation reservation = new Reservation(room, guest, reservationDate);
                reservations.add(reservation);
                System.out.println("Room " + roomNumber + " booked successfully for " + guest.getName());
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
    }

    // Cancel a reservation
    public void cancelReservation(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().getRoomNumber() == roomNumber) {
                reservation.getRoom().setAvailable(true);
                reservations.remove(reservation);
                System.out.println("Reservation for Room " + roomNumber + " canceled.");
                return;
            }
        }
        System.out.println("No reservation found for Room " + roomNumber);
    }

    // Display all rooms
    public void displayRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // Display all reservations
    public void displayReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
 i();
        Scanner scanner = new Scanner(System.in);

        // Add some rooms
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(103, "Suite", 250.0));

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Display Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Display Reservations");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hotel.displayRooms();
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter reservation date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    hotel.bookRoom(new Guest(name, contact), roomNumber, date);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel reservation: ");
                    int cancelRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    hotel.cancelReservation(cancelRoomNumber);
                    break;
                case 4:
                    hotel.displayReservations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
