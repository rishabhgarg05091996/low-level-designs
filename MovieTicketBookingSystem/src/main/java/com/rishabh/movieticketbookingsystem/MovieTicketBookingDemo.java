package com.rishabh.movieticketbookingsystem;

import com.rishabh.movieticketbookingsystem.booking.model.Movie;
import com.rishabh.movieticketbookingsystem.booking.model.Show;
import com.rishabh.movieticketbookingsystem.booking.model.Theater;
import com.rishabh.movieticketbookingsystem.booking.model.Booking;
import com.rishabh.movieticketbookingsystem.booking.model.Seat;
import com.rishabh.movieticketbookingsystem.booking.model.SeatType;
import com.rishabh.movieticketbookingsystem.booking.model.SeatStatus;
import com.rishabh.movieticketbookingsystem.booking.service.MovieTicketBookingService;
import com.rishabh.movieticketbookingsystem.user.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class MovieTicketBookingDemo {
	public static void main(String[] args) {
		MovieTicketBookingService bookingService = MovieTicketBookingService.getInstance();
		
		// Add movies
		Movie movie1 = new Movie("M1", "Movie 1", "Description 1", 120);
		Movie movie2 = new Movie("M2", "Movie 2", "Description 2", 135);
		bookingService.addMovie(movie1);
		bookingService.addMovie(movie2);
		
		// Add theaters
		Theater theater1 = new Theater("T1", "Theater 1", "Location 1", new ArrayList<>());
		Theater theater2 = new Theater("T2", "Theater 2", "Location 2", new ArrayList<>());
		bookingService.addTheater(theater1);
		bookingService.addTheater(theater2);
		
		// Add shows
		Show show1 = new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()), createSeats(10, 10));
		Show show2 = new Show("S2", movie2, theater2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie2.getDurationInMinutes()), createSeats(8, 8));
		bookingService.addShow(show1);
		bookingService.addShow(show2);
		
		// Book tickets
		User user = new User("U1", "John Doe", "john@example.com");
		List<Seat> selectedSeats = Arrays.asList(show1.getSeats().get("1-5"), show1.getSeats().get("1-6"));
		Booking booking = bookingService.bookTickets(user, show1, selectedSeats);
		if (booking != null) {
			System.out.println("Booking successful. Booking ID: " + booking.getId());
			bookingService.confirmBooking(booking.getId());
		} else {
			System.out.println("Booking failed. Seats not available.");
		}
		
		// Uncomment to cancel booking
		// bookingService.cancelBooking(booking.getId());
	}
	
	private static Map<String, Seat> createSeats(int rows, int columns) {
		Map<String, Seat> seats = new HashMap<>();
		for (int row = 1; row <= rows; row++) {
			for (int col = 1; col <= columns; col++) {
				String seatId = row + "-" + col;
				SeatType seatType = (row <= 2) ? SeatType.PREMIUM : SeatType.NORMAL;
				double price = (seatType == SeatType.PREMIUM) ? 150.0 : 100.0;
				Seat seat = new Seat(seatId, row, col, seatType, price, SeatStatus.AVAILABLE);
				seats.put(seatId, seat);
			}
		}
		return seats;
	}
}
