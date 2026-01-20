package ccp.hotel.test;

import ccp.hotel.CreditCard;
import ccp.hotel.InvalidInputException;
import org.junit.jupiter.api.Test;
import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.*;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

class CreditCardTest {

	@Test
	void validCreditCardIsCreated() {
        CreditCard cc = new CreditCard("1234567812345678", YearMonth.now().plusYears(1), "John Doe");
        assertEquals("John Doe", cc.getCardHolderName());
    }

    @Test
    void maskedNumberIsCorrect() {
        CreditCard cc = new CreditCard("1234567812345678", YearMonth.now().plusYears(1), "John Doe");
        assertEquals("**** **** **** 5678", cc.getMaskedNumber());
    }

    @Test
    void expiredCardThrowsException() {
        YearMonth pastDate = YearMonth.now().minusMonths(1);
        assertThrows(InvalidInputException.class, 
            () -> new CreditCard("1234567812345678", pastDate, "John Doe"));
    }

    @Test
    void invalidNumberFormatThrowsException() {
        // Test with letters or wrong length
        assertThrows(InvalidInputException.class, 
            () -> new CreditCard("12345678ABC", YearMonth.now().plusYears(1), "John Doe"));
    }
}