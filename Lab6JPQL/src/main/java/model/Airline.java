package model;

import lombok.Data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Data
@Entity
public class Airline {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "airline")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airline() {
	}

	public Airline(String name) {
		this.name = name;
	}

	/* Collections Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) {
			flight.setAirline(this);
			success = true;
		}
		return success;
	}

	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirline(null);
			success = true;
		}
		return success;
	}
}
