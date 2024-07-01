package com.rishabh.movieticketbookingsystem.payment.model;

import com.rishabh.movieticketbookingsystem.booking.model.Booking;
import com.rishabh.movieticketbookingsystem.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payment {
	private String id;
	private User user;
	private Booking booking;
	private double amount;
	private PaymentStatus status;
}