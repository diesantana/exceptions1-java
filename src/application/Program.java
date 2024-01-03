package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int number = scanner.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			String checkIn = scanner.next();
			LocalDate checkInDate = LocalDate.parse(checkIn, Reservation.getDateFormat());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			String checkOut = scanner.next();
			LocalDate checkOutDate = LocalDate.parse(checkOut, Reservation.getDateFormat());

			Reservation reserve = new Reservation(number, checkInDate, checkOutDate);

			System.out.println(reserve);
			System.out.println();

			System.out.println("Enter date to update the reservation:");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = scanner.next();
			checkInDate = LocalDate.parse(checkIn, Reservation.getDateFormat());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = scanner.next();
			checkOutDate = LocalDate.parse(checkOut, Reservation.getDateFormat());

			reserve.updateDates(LocalDate.parse(checkIn, Reservation.getDateFormat()),
					LocalDate.parse(checkOut, Reservation.getDateFormat()));

			System.out.println(reserve);
		} catch (DomainException e) {
			System.out.println(e.getMessage());;
		}

		scanner.close();
	}
}
