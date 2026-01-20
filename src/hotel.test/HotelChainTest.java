package ccp.hotel.test;
import ccp.hotel.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

class HotelChainTest {

	@Test
	void fullFlowWorks() {
        HotelChain chain = new HotelChain("Chain");
        Hotel hotel = new Hotel("Hotel");
        chain.addHotel(hotel);

        RoomType rt = new RoomType("1", "Deluxe", new BigDecimal("3000"));
        Room room = new Room(101, rt);
        hotel.addRoom(room);

        Customer c = new Customer("Ali", "Lahore");

        Reservation r = chain.makeReservation(
                hotel, c, rt,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2)
        );

        assertNotNull(r);
        chain.checkIn(room, c);
        assertTrue(room.isOccupied());
    }
}