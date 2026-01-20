package ccp.hotel.test;

import ccp.hotel.Customer;
import ccp.hotel.Room;
import ccp.hotel.RoomType;
import ccp.hotel.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	 void roomCanBeOccupiedAndVacated() {
        RoomType type = new RoomType("1", "Deluxe", new BigDecimal("3000"));
        Room room = new Room(101, type);
        Customer customer = new Customer("Ali", "Lahore");

        room.assignGuest(customer);
        assertTrue(room.isOccupied());

        room.removeGuest();
        assertFalse(room.isOccupied());
    }

    @Test
    void assigningNullGuestThrowsException() {
        RoomType type = new RoomType("1", "Deluxe", new BigDecimal("3000"));
        Room room = new Room(101, type);

        assertThrows(InvalidInputException.class,
                () -> room.assignGuest(null));
    }
}