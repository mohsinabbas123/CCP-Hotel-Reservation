package ccp.hotel;
import java.util.Objects;
import java.util.UUID;


public class Customer {

	 private final String id;
	    private final String name;
	    private final String address;

	    public Customer(String name, String address) {
	        if (name == null || name.isBlank()) {
	            throw new InvalidInputException("Customer name is required");
	        }

	        this.id = UUID.randomUUID().toString();
	        this.name = name;
	        this.address = address == null ? "" : address;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getAddress() {
	        return address;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Customer)) return false;
	        Customer other = (Customer) obj;
	        return id.equals(other.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	}
