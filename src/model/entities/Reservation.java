package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private LocalDate now = LocalDate.now();
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Error in reservation: Reservation dates must be future dates");
		}
		if (checkOut.isBefore(checkIn) || duration(checkIn, checkOut) <= 0) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public Integer duration(LocalDate checkIn, LocalDate checkOut) {
		Duration duracao = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		long days = duracao.toDays();
		return Math.toIntExact(days);
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Error in reservation: Reservation dates must be future dates");
		}
		if (checkOut.isBefore(checkIn) || duration(checkIn, checkOut) <= 0) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public static DateTimeFormatter getDateFormat() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	@Override
	public String toString() {
		return String.format("Reservation: Room %d, check-in: %s, check-out: %s, %d nights", 
				roomNumber, 
				checkIn.format(getDateFormat()),
				checkOut.format(getDateFormat()), 
				duration(checkIn, checkOut));
	}
	
	
	
}
