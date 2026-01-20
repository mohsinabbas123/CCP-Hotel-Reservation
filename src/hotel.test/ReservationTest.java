package ccp.hotel.test;

import ccp.hotel.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

class ReservationTest {

	@Test
	 void reservationCanBeCancelled() {
        Customer c = new Customer("Ali", "Lahore");
        RoomType rt = new RoomType("1", "Standard", new BigDecimal("2000"));

        Reservation r = new Reservation(
                c, rt,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2)
        );

        assertTrue(r.canBeCancelled());
        r.cancel();
        assertEquals(BookingStatus.CANCELLED, r.getStatus());
    }
}