package model;

import lombok.Data;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalTime;
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

	private LocalTime departureTime;
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;

	private LocalTime arrivalTime;
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

	public Flight(String flightnr, Date departureDate, LocalTime departureTime,
			Date arrivalDate, LocalTime arrivalTime) {
		this.flightnr = flightnr;
		this.setDepartureDate(departureDate);
		this.setDepartureTime(departureTime);
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);

	}

	public Flight(String flightnr, Date departureDate, LocalTime departureTime,
			Date arrivalDate, LocalTime arrivalTime, Airline airline,
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


//	public Flight(String d23, Date parse, Date parse1, Date parse2, Date parse3, Airline airline, Airport airport, Airplane airplane) {
//	}
}
