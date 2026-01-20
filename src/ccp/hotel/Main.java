package ccp.hotel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class Main {

	public static void main(String[] args) {

		   System.out.println("----- CCP Hotel Chain Workflow Demo -----");

	        // 1️⃣ Create Hotel Chain
	        HotelChain chain = new HotelChain("CCP Hotel Chain");
	        System.out.println("Hotel chain created: " + chain.getName());

	        // 2️⃣ Create Hotel and add to chain
	        Hotel hotel = new Hotel("CCP Hotel");
	        chain.addHotel(hotel);
	        System.out.println("Hotel added: " + hotel.getName());

	        // 3️⃣ Create RoomType and Room
	        RoomType deluxe = new RoomType("RT1", "Deluxe", new BigDecimal("5000"));
	        Room room101 = new Room(101, deluxe);
	        hotel.addRoom(room101);
	        System.out.println("Room added: " + room101.getRoomNumber() + " (" + deluxe.getName() + ")");

	        // 4️⃣ Create Customer
	        Customer customer = new Customer("Mohsin Abbas", "Karachi");
	        System.out.println("Customer created: " + customer.getName() + ", Address: " + customer.getAddress());

	        // 5️⃣ Make Reservation
	        Reservation reservation = chain.makeReservation(
	                hotel,
	                customer,
	                deluxe,
	                LocalDate.now().plusDays(1),
	                LocalDate.now().plusDays(3)
	        );
	        System.out.println("Reservation created with ID: " + reservation.getReservationId());
	        System.out.println("Reservation status: " + reservation.getStatus());

	        // 6️⃣ Confirm Reservation
	        reservation.confirm();
	        System.out.println("Reservation confirmed. Current status: " + reservation.getStatus());

	        // 7️⃣ Check-in Customer
	        chain.checkIn(room101, customer);
	        System.out.println("Customer checked in: " + customer.getName() + " to room " + room101.getRoomNumber());
	        System.out.println("Room occupied? " + room101.isOccupied());

	        // 8️⃣ Check-out Customer
	        chain.checkOut(room101);
	        System.out.println("Customer checked out: " + customer.getName() + " from room " + room101.getRoomNumber());
	        System.out.println("Room occupied after check-out? " + room101.isOccupied());

	        // 9️⃣ Create Credit Card
	        CreditCard card = new CreditCard(
	                "1234567812345678",
	                YearMonth.now().plusYears(1),
	                "Mohsin Abbas"
	        );
	        System.out.println("Credit card created for: " + card.getCardHolderName());
	        System.out.println("Masked card number: " + card.getMaskedNumber());
	        System.out.println("Card expiry: " + card.getExpiryDate());

	        System.out.println("----- Workflow Completed Successfully -----");
	    }
	}