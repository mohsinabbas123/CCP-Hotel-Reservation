package ccp.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HotelChain {

    private final String name;
    private final List<Hotel> hotels;

    public HotelChain(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException("Hotel chain name is required");
        }
        this.name = name;
        this.hotels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /* -------------------- Hotel management -------------------- */

    public void addHotel(Hotel hotel) {
        if (hotel == null) {
            throw new InvalidInputException("Hotel cannot be null");
        }
        hotels.add(hotel);
    }

    public List<Hotel> getHotels() {
        return List.copyOf(hotels);
    }

    /* -------------------- Reservation rules -------------------- */

    public boolean canMakeReservation(Hotel hotel, RoomType roomType) {
        validateHotel(hotel);
        Objects.requireNonNull(roomType, "RoomType is required");

        return hotel.isRoomTypeAvailable(roomType);
    }

    public Reservation makeReservation(Hotel hotel,
                                       Customer customer,
                                       RoomType roomType,
                                       java.time.LocalDate checkIn,
                                       java.time.LocalDate checkOut) {

        validateHotel(hotel);

        if (!canMakeReservation(hotel, roomType)) {
            throw new IllegalStateException("Reservation cannot be made");
        }

        return hotel.createReservation(customer, roomType, checkIn, checkOut);
    }

    public boolean canCancelReservation(Reservation reservation) {
        Objects.requireNonNull(reservation, "Reservation is required");
        return reservation.canBeCancelled();
    }

    public void cancelReservation(Reservation reservation) {
        if (!canCancelReservation(reservation)) {
            throw new IllegalStateException("Reservation cannot be cancelled");
        }
        reservation.cancel();
    }

    /* -------------------- Check-in / Check-out -------------------- */

    public boolean canCheckIn(Room room) {
        Objects.requireNonNull(room, "Room is required");
        return !room.isOccupied();
    }

    public void checkIn(Room room, Customer customer) {
        if (!canCheckIn(room)) {
            throw new IllegalStateException("Check-in not allowed");
        }
        room.assignGuest(customer);
    }

    public boolean canCheckOut(Room room) {
        Objects.requireNonNull(room, "Room is required");
        return room.isOccupied();
    }

    public void checkOut(Room room) {
        if (!canCheckOut(room)) {
            throw new IllegalStateException("Check-out not allowed");
        }
        room.removeGuest();
    }

    /* -------------------- Helpers -------------------- */

    private void validateHotel(Hotel hotel) {
        if (hotel == null || !hotels.contains(hotel)) {
            throw new InvalidInputException("Hotel is not part of this chain");
        }
    }
}
