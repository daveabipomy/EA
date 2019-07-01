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
public class Airport {
	@Id
	@GeneratedValue
	private long id;
	private String airportcode;
	private String name;
	private String city;
	private String country;
	@OneToMany(mappedBy = "destination")
	@OrderBy("arrivalDate, arrivalTime")
	private List<Flight> arrivals;
	@OneToMany(mappedBy = "origin")
	@OrderBy("departureDate, departureTime")
	private List<Flight> departures;

	/* Constructors */
	public Airport() {
	}

	public Airport(String airportcode, String name, String city, String country) {
		this.airportcode = airportcode;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	/* Collection methods */
	public boolean addArrival(Flight flight) {
		boolean success = false;
		if (arrivals.add(flight)) {
			flight.setDestination(this);
			success = true;
		}
		return success;
	}

	public boolean removeArrival(Flight flight) {
		boolean success = false;
		if (arrivals.remove(flight)) {
			flight.setDestination(null);
			success = true;
		}
		return success;
	}

	public boolean addDeparture(Flight flight) {
		boolean success = false;
		if (departures.add(flight)) {
			flight.setOrigin(this);
			success = true;
		}
		return success;
	}

	public boolean removeDeparture(Flight flight) {
		boolean success = false;
		if (departures.remove(flight)) {
			flight.setOrigin(null);
			success = true;
		}
		return success;
	}
}
