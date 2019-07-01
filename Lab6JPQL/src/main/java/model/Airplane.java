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
public class Airplane {
	@Id
	@GeneratedValue
	private long id;
	private String serialnr;
	private String model;
	private int capacity;
	@OneToMany(mappedBy="airplane")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airplane() {
	}

	public Airplane(String serialnr, String model, int capacity) {
		this.serialnr = serialnr;
		this.model = model;
		this.capacity = capacity;
	}


	/* Collection Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) { 
			flight.setAirplane(this);
			success = true;
		}
		return success;
	}
	
	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirplane(null);
			success = true;
		}
		return success;
	}
}
