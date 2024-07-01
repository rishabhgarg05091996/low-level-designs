package com.rishabh.movieticketbookingsystem.booking.model;

import com.rishabh.movieticketbookingsystem.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Booking {
	private final String id;
	private final User user;
	private final Show show;
	private final List<Seat> seats;
	private final double totalPrice;
	@Setter
	private BookingStatus status;
}