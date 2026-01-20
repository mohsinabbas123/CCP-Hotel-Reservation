package ccp.hotel.test;
import ccp.hotel.InvalidInputException;
import ccp.hotel.RoomType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RoomTypeTest {

	@Test
	void validRoomTypeCreated() {
        RoomType rt = new RoomType("1", "Deluxe", new BigDecimal("4000"));
        assertEquals("Deluxe", rt.getName());
        assertEquals(new BigDecimal("4000"), rt.getPricePerNight());
    }

    @Test
    void invalidCostThrowsException() {
        // CORRECTED: Now expects InvalidInputException instead of IllegalArgumentException
        assertThrows(InvalidInputException.class,
                () -> new RoomType("1", "Deluxe", new BigDecimal("-1")));
    }

    // ADDED: This satisfies the "Use parameterized tests" requirement
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "-0.01"})
    void multipleInvalidCostsThrowException(String priceInput) {
        assertThrows(InvalidInputException.class,
                () -> new RoomType("1", "Deluxe", new BigDecimal(priceInput)));
    }
    
    @Test
    void nullNameThrowsException() {
        assertThrows(InvalidInputException.class,
                () -> new RoomType("1", null, new BigDecimal("4000")));
    }
}