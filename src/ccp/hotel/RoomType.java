package ccp.hotel;
import java.math.BigDecimal;
import java.util.Objects;

public final class RoomType {

	 private final String id;
	    private final String name;
	    private final BigDecimal pricePerNight;

	    public RoomType(String id, String name, BigDecimal pricePerNight) {
	        if (id == null || id.isBlank())
	            throw new InvalidInputException("RoomType id is required");

	        if (name == null || name.isBlank())
	            throw new InvalidInputException("RoomType name is required");

	        if (pricePerNight == null || pricePerNight.signum() < 0)
	            throw new InvalidInputException("Invalid room price");

	        this.id = id;
	        this.name = name;
	        this.pricePerNight = pricePerNight;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public BigDecimal getPricePerNight() {
	        return pricePerNight;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof RoomType)) return false;
	        RoomType other = (RoomType) obj;
	        return id.equals(other.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	}

