package com.rishabh.movieticketbookingsystem.booking.service;

import com.rishabh.movieticketbookingsystem.notification.model.Notification;
import com.rishabh.movieticketbookingsystem.notification.model.NotificationType;
import com.rishabh.movieticketbookingsystem.notification.service.NotificationService;
import com.rishabh.movieticketbookingsystem.payment.model.Payment;
import com.rishabh.movieticketbookingsystem.payment.model.PaymentStatus;
import com.rishabh.movieticketbookingsystem.payment.service.PaymentService;
import com.rishabh.movieticketbookingsystem.user.model.User;
import com.rishabh.movieticketbookingsystem.booking.model.Movie;
import com.rishabh.movieticketbookingsystem.booking.model.Theater;
import com.rishabh.movieticketbookingsystem.booking.model.Show;
import com.rishabh.movieticketbookingsystem.booking.model.Booking;
import com.rishabh.movieticketbookingsystem.booking.model.Seat;
import com.rishabh.movieticketbookingsystem.booking.model.BookingStatus;
import com.rishabh.movieticketbookingsystem.booking.model.SeatStatus;
import com.rishabh.movieticketbookingsystem.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MovieTicketBookingService {
	private static MovieTicketBookingService instance;
	private final List<Movie> movies;
	private final List<Theater> theaters;
	private final Map<String, Show> shows;
	private final Map<String, Booking> bookings;
	private final PaymentService paymentService;
	private final NotificationService notificationService;
	
	private MovieTicketBookingService() {
		movies = new ArrayList<>();
		theaters = new ArrayList<>();
		shows = new ConcurrentHashMap<>();
		bookings = new ConcurrentHashMap<>();
		paymentService = new PaymentService();
		notificationService = new NotificationService();
	}
	
	public static synchronized MovieTicketBookingService getInstance() {
		if (instance == null) {
			instance = new MovieTicketBookingService();
		}
		return instance;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void addTheater(Theater theater) {
		theaters.add(theater);
	}
	
	public void addShow(Show show) {
		shows.put(show.getId(), show);
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public List<Theater> getTheaters() {
		return theaters;
	}
	
	public Show getShow(String showId) {
		return shows.get(showId);
	}
	
	public synchronized Booking bookTickets(User user, Show show, List<Seat> selectedSeats) {
		if (areSeatsAvailable(show, selectedSeats)) {
			markSeatsAsBooked(show, selectedSeats);
			double totalPrice = calculateTotalPrice(selectedSeats);
			String bookingId = IdGenerator.generateBookingId();
			Booking booking = new Booking(bookingId, user, show, selectedSeats, totalPrice, BookingStatus.PENDING);
			bookings.put(bookingId, booking);
			return booking;
		}
		return null;
	}
	
	private boolean areSeatsAvailable(Show show, List<Seat> selectedSeats) {
		for (Seat seat : selectedSeats) {
			Seat showSeat = show.getSeats().get(seat.getId());
			if (showSeat == null || showSeat.getStatus() != SeatStatus.AVAILABLE) {
				return false;
			}
		}
		return true;
	}
	
	private void markSeatsAsBooked(Show show, List<Seat> selectedSeats) {
		for (Seat seat : selectedSeats) {
			Seat showSeat = show.getSeats().get(seat.getId());
			showSeat.setStatus(SeatStatus.BOOKED);
		}
	}
	
	private double calculateTotalPrice(List<Seat> selectedSeats) {
		return selectedSeats.stream().mapToDouble(Seat::getPrice).sum();
	}
	
	public synchronized void confirmBooking(String bookingId) {
		Booking booking = bookings.get(bookingId);
		if (booking != null && booking.getStatus() == BookingStatus.PENDING) {
			Payment payment = paymentService.createPayment(booking.getUser(), booking);
			if (paymentService.processPayment(payment)) {
				booking.setStatus(BookingStatus.CONFIRMED);
				Notification notification = notificationService.createNotification(booking.getUser(), booking, NotificationType.BOOKING_CONFIRMATION);
				notificationService.sendNotification(notification);
			} else {
				// Handle payment failure if necessary
				System.out.println("Payment processing failed for Booking ID: " + bookingId);
			}
		}
	}
	
	public synchronized void cancelBooking(String bookingId) {
		Booking booking = bookings.get(bookingId);
		if (booking != null && booking.getStatus() != BookingStatus.CANCELLED) {
			Payment payment = new Payment(UUID.randomUUID().toString(), booking.getUser(), booking, booking.getTotalPrice(), PaymentStatus.SUCCESS);
			if (paymentService.processRefund(payment)) {
				booking.setStatus(BookingStatus.CANCELLED);
				markSeatsAsAvailable(booking.getShow(), booking.getSeats());
				Notification notification = notificationService.createNotification(booking.getUser(), booking, NotificationType.BOOKING_CANCELLATION);
				notificationService.sendNotification(notification);
			} else {
				// Handle refund failure if necessary
				System.out.println("Refund processing failed for Booking ID: " + bookingId);
			}
		}
	}
	
	private void markSeatsAsAvailable(Show show, List<Seat> seats) {
		for (Seat seat : seats) {
			Seat showSeat = show.getSeats().get(seat.getId());
			showSeat.setStatus(SeatStatus.AVAILABLE);
		}
	}
}