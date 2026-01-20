package ccp.hotel;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Reservation {

	 private final String reservationId;
	    private final Customer customer;
	    private final RoomType roomType;
	    private final LocalDate checkInDate;
	    private final LocalDate checkOutDate;
	    private BookingStatus status;

	    public Reservation(Customer customer,
	                       RoomType roomType,
	                       LocalDate checkInDate,
	                       LocalDate checkOutDate) {

	        if (customer == null)
	            throw new InvalidInputException("Customer is required");

	        if (roomType == null)
	            throw new InvalidInputException("Room type is required");

	        if (checkInDate == null || checkOutDate == null)
	            throw new InvalidInputException("Dates cannot be null");

	        if (!checkOutDate.isAfter(checkInDate))
	            throw new InvalidInputException("Check-out must be after check-in");

	        this.reservationId = UUID.randomUUID().toString();
	        this.customer = customer;
	        this.roomType = roomType;
	        this.checkInDate = checkInDate;
	        this.checkOutDate = checkOutDate;
	        this.status = BookingStatus.CREATED;
	    }

	    public String getReservationId() {
	        return reservationId;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public RoomType getRoomType() {
	        return roomType;
	    }

	    public BookingStatus getStatus() {
	        return status;
	    }

	    public boolean canBeCancelled() {
	        return status == BookingStatus.CREATED;
	    }

	    public void cancel() {
	        if (!canBeCancelled()) {
	            throw new IllegalStateException("Reservation cannot be cancelled");
	        }
	        status = BookingStatus.CANCELLED;
	    }

	    public void confirm() {
	        if (status != BookingStatus.CREATED) {
	            throw new IllegalStateException("Only new reservations can be confirmed");
	        }
	        status = BookingStatus.CONFIRMED;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Reservation)) return false;
	        Reservation other = (Reservation) obj;
	        return reservationId.equals(other.reservationId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(reservationId);
	    }
	}
