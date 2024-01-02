package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Room number: ");
		int number = scanner.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		String checkIn = scanner.next();
		LocalDate checkInDate = LocalDate.parse(checkIn, Reservation.getDateFormat());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		String checkOut = scanner.next();
		LocalDate checkOutDate = LocalDate.parse(checkOut, Reservation.getDateFormat());

		if (checkOutDate.isBefore(checkInDate)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
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

			if (reserve.updateDates(checkInDate, checkOutDate) == null) {
				
				reserve.updateDates(LocalDate.parse(checkIn, Reservation.getDateFormat()),
						LocalDate.parse(checkOut, Reservation.getDateFormat())
				);

				System.out.println(reserve);

			} else {
				System.out.println(reserve.updateDates(checkInDate, checkOutDate));
			}

		}

		scanner.close();
	}
}
