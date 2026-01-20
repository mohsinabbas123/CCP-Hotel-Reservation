package ccp.hotel;
import java.util.Optional;
import java.util.UUID;

public class Room {

	private final String id;
    private final int roomNumber;
    private final RoomType roomType;
    private Customer occupant;

    public Room(int roomNumber, RoomType roomType) {
        if (roomNumber <= 0)
            throw new InvalidInputException("Invalid room number");

        if (roomType == null)
            throw new InvalidInputException("RoomType required");

        this.id = UUID.randomUUID().toString();
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return occupant != null;
    }

    public void assignGuest(Customer customer) {
        if (customer == null)
            throw new InvalidInputException("Customer required");

        if (isOccupied())
            throw new IllegalStateException("Room already occupied");

        this.occupant = customer;
    }

    public void removeGuest() {
        if (!isOccupied())
            throw new IllegalStateException("Room not occupied");

        this.occupant = null;
    }

    public Optional<Customer> getOccupant() {
        return Optional.ofNullable(occupant);
    }
}