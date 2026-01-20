package ccp.hotel.test;

import ccp.hotel.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

class HotelTest {

	@Test
	 void hotelCreatesReservation() {
        Hotel h = new Hotel("Test Hotel");
        RoomType rt = new RoomType("1", "Deluxe", new BigDecimal("3000"));
        h.addRoom(new Room(101, rt));

        Customer c = new Customer("Ali", "Lahore");

        Reservation r = h.createReservation(
                c, rt,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3)
        );

        assertNotNull(r);
    }
}
