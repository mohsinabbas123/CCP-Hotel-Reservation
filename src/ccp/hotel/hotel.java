package ccp.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Hotel {

    private final String name;
    private final List<Room> rooms;
    private final List<Reservation> reservations;

    public Hotel(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException("Hotel name is required");
        }
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /* -------------------- Room management -------------------- */

    public void addRoom(Room room) {
        if (room == null) {
            throw new InvalidInputException("Room cannot be null");
        }
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    /* -------------------- Reservation management -------------------- */

    public Reservation createReservation(Customer customer,
                                         RoomType roomType,
                                         LocalDate checkIn,
                                         LocalDate checkOut) {

        if (!isRoomTypeAvailable(roomType)) {
            throw new IllegalStateException("Requested room type is not available");
        }

        Reservation reservation =
                new Reservation(customer, roomType, checkIn, checkOut);

        reservations.add(reservation);
        return reservation;
    }

    public void cancelReservation(Reservation reservation) {
        if (reservation == null) {
            throw new InvalidInputException("Reservation cannot be null");
        }
        reservation.cancel();
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }

    /* -------------------- Availability logic -------------------- */

    public boolean isRoomTypeAvailable(RoomType roomType) {
        Objects.requireNonNull(roomType, "RoomType is required");

        return rooms.stream()
                .anyMatch(room ->
                        room.getRoomType().equals(roomType)
                                && !room.isOccupied());
    }
}
