package com.rishabh.movieticketbookingsystem.payment.service;

import com.rishabh.movieticketbookingsystem.booking.model.Booking;
import com.rishabh.movieticketbookingsystem.payment.model.Payment;
import com.rishabh.movieticketbookingsystem.payment.model.PaymentStatus;
import com.rishabh.movieticketbookingsystem.user.model.User;

import java.util.UUID;

public class PaymentService {
	public Payment createPayment(User user, Booking booking) {
		return new Payment(UUID.randomUUID().toString(), user, booking, booking.getTotalPrice(), PaymentStatus.PENDING);
	}
	
	public boolean processPayment(Payment payment) {
		// Implement actual payment processing logic here
		payment.setStatus(PaymentStatus.SUCCESS);
		System.out.println("Payment processed successfully for Payment ID: " + payment.getId());
		return true;
	}
	
	public boolean processRefund(Payment payment) {
		// Implement actual refund processing logic here
		payment.setStatus(PaymentStatus.REFUNDED);
		System.out.println("Refund processed successfully for Payment ID: " + payment.getId());
		return true;
	}
}
