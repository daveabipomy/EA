package model;

import lombok.Data;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@Entity
public class Flight {
	@Id
	@GeneratedValue
	private long id;
	private String flightnr;
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Airline airline;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Airport origin;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Airport destination;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Airplane airplane;

	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
	private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
			Locale.US);

	/* Constructors */
	public Flight() {
	}

	public Flight(String flightnr, Date departureDate, Date departureTime,
			Date arrivalDate, Date arrivalTime) {
		this.flightnr = flightnr;
		this.setDepartureDate(departureDate);
		this.setDepartureTime(departureTime);
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);

	}

	public Flight(String flightnr, Date departureDate, Date departureTime,
			Date arrivalDate, Date arrivalTime, Airline airline,
			Airport origin, Airport destination, Airplane airplane) {
		this.flightnr = flightnr;
		this.setDepartureDate(departureDate);
		this.setDepartureTime(departureTime);
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.airplane = airplane;
	}


}
