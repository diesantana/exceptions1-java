package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
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
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
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