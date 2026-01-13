package ccp.hotel;

import java.time.YearMonth;
import java.util.Objects;

public final class CreditCard {

    private final String cardNumber;
    private final YearMonth expiryDate;
    private final String cardHolderName;

    public CreditCard(String cardNumber, YearMonth expiryDate, String cardHolderName) {
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new InvalidInputException("Credit card number must be 16 digits");
        }
        if (expiryDate == null || expiryDate.isBefore(YearMonth.now())) {
            throw new InvalidInputException("Credit card is expired");
        }
        if (cardHolderName == null || cardHolderName.isBlank()) {
            throw new InvalidInputException("Card holder name is required");
        }

        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cardHolderName = cardHolderName;
    }

    public String getMaskedNumber() {
        return "**** **** **** " + cardNumber.substring(12);
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CreditCard)) return false;
        CreditCard other = (CreditCard) obj;
        return cardNumber.equals(other.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }
}
